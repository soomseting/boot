package com.example.jpa.controller;

import com.example.jpa.entity.Memo;
import com.example.jpa.entity.QMemo;
import com.example.jpa.repository.MemoRepository;
import com.example.jpa.util.Criteria;
import com.example.jpa.util.PageDTO;
import com.querydsl.core.BooleanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JPARestController {

    //서비스영역 생략.......
    @Autowired
    private MemoRepository memoRepository;

    //클라이언트에서 값을 보낼때는 경로?page=1&amoun=10
    @GetMapping("/getFindAll")
    public ResponseEntity<PageDTO<Memo>> getFindAll(Criteria cri) {
        //필요한 값을 cri안에 다 들어옵니다.
        QMemo memo = QMemo.memo;
        BooleanBuilder builder = new BooleanBuilder();

        //동적쿼리
        if( cri.getSearchType() != null && cri.getSearchType().equals("mno")  ) { //번호검색
            builder.and( memo.mno.like( "%" + cri.getSearchName() + "%" ));
        }

        if( cri.getSearchType() != null && cri.getSearchType().equals("writer")  ) { //작성자검색
            builder.and( memo.writer.like( "%" + cri.getSearchName() + "%" ));
        }

        if( cri.getSearchType() != null && cri.getSearchType().equals("text")  ) { //내용검색
            builder.and( memo.text.like( "%" + cri.getSearchName() + "%" ));
        }

        if( cri.getSearchType() != null && cri.getSearchType().equals("textWriter")  ) { //내용 + 작성자
            //where 1=1 and (text like ~~~ or writer like ~~~~)
            //and와 or를 같이 사용하려면 주의 and가 or보다 빠름
            builder.andAnyOf(
                    memo.text.like( "%" + cri.getSearchName() + "%" ),
                    memo.writer.like( "%" + cri.getSearchName() + "%" )
            );
        }

        //Page<> = memoRepository.findAll(불린빌더, 페이지);
        Sort sort = Sort.by("mno").descending();

        Pageable pageable = PageRequest.of(
                cri.getPage()-1
                ,cri.getAmount()
                ,sort
        );

        Page<Memo> page = memoRepository.findAll(builder, pageable);
        PageDTO<Memo> pageDTO = new PageDTO<>(page);

        return new ResponseEntity(pageDTO, HttpStatus.OK);
    }

}
