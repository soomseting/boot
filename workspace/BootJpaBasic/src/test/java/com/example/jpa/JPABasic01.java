package com.example.jpa;

import com.example.jpa.entity.Memo;
import com.example.jpa.repository.MemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class JPABasic01 {

    @Autowired
    private MemoRepository memoRepository;

    @Test
    public void textCode01() {

        for (int i = 2; i <= 300; i++) {


            Memo memo = Memo
                    .builder()
                    .writer("admin" + i)
                    .text("sample" + i)
                    .build();

            memoRepository.save(memo); //insert함수
        }
    }
    //select함수 - find키워드
    @Test
    public void textCode02() {
        Optional<Memo> memo = memoRepository.findById(1L);
        if (memo.isPresent()) { //값이 있다면
            Memo m = memo.get();//값을 꺼냄
            System.out.println(m.toString());
        }
    }

    //select함수
    @Test
    public void textCode03() {
        List<Memo> memos = memoRepository.findAll();
        System.out.println(memos);
    }

    //update함수
    //내부적으로 키를 확인한 후에 값이 있으면 update를 진행합니다
    @Test
    public void textCode04() {
        Memo memo = Memo.builder()
                        .mno(1L)
                        .writer("test")
                        .text("test")
                        .build();
        Memo result = memoRepository.save(memo);
        if (result == null) {
            System.out.println("업뎃 실패");
        }else{
            System.out.println("업뎃 결과 : " + result);
        }
    }

    //delete - delete, deleteById
    @Test
    public void textCode05() {
        memoRepository.deleteById(1L);
    }
}
