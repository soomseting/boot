package com.example.jpa;

import com.example.jpa.entity.Member;
import com.example.jpa.entity.MemberMemoDTO;
import com.example.jpa.entity.Memo;
import com.example.jpa.repository.MemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class JPACustom05 {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testCode01() {
        int result =memoRepository.updateTest("커스텀레포지토리",100L);
        System.out.println("업데이트 성공여부 : " + result);
    }


    /// ////////////////
    //매니 투 원 조인
    @Test
    public void testCode02() {
        List<Memo> list = memoRepository.mtoJoin1(2);
//        List<Memo> list = memoRepository.mtoJoin2(2L);

        for (Memo m : list) {
            System.out.println(m.toString());
        }

    }

    @Test
    public void testCode03() {
        List<Memo> list = memoRepository.mtoJoin3("홍길동");
        System.out.println(list.toString());
    }

    //원투매니 조인 - default조인방식은 lazy (조인을 걸고 필요한 시점에 붙일 Entity를 select하는 방식)
    // -> 실행 메서드에서 @Transactional을 반드시 붙여야 한다.
    // 또는 조인방식을 eager(즉시 조인을 걸어서 수행을 하겠다)
    @Transactional
    @Test
    public void testCode04() {
        Member m = memoRepository.otmJoin1("aaa");
        System.out.println(m.toString());
    }

    //dto로 받기
    @Test
    public void testCode05() {
        List<MemberMemoDTO> list = memoRepository.getList("aaa");
        System.out.println(list.toString());
    }

    /// //
    @Test
    public void testCode06() {
        List<MemberMemoDTO> list = memoRepository.getList2("sample");
        System.out.println(list.toString());
    }

}
