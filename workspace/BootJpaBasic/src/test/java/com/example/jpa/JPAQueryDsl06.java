package com.example.jpa;

import com.example.jpa.entity.Memo;
import com.example.jpa.repository.MemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JPAQueryDsl06 {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testCode01() {
        Memo m =memoRepository.selectDsl();
        System.out.println(m);

    }

    @Test
    public void testCode02() {
        List<Memo> list = memoRepository.selectDsl2();
        System.out.println(list.toString());
    }

    @Test
    public void testCode03() {
//        List<Memo> list = memoRepository.selectDsl3("writer", "5"); //writer검색, 값
        List<Memo> list = memoRepository.selectDsl3("text", "6"); //writer검색, 값
        System.out.println(list.toString());
    }

}
