package com.coding404.myweb.testcode;

import com.coding404.myweb.command.DemoMemberVO;
import com.coding404.myweb.command.DemoOrderVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestCode02 {

    @Autowired
    private TestMapper testMapper;

    @Test
    public void testCode01() {
        List<DemoOrderVO> list = testMapper.manyToOne();
        System.out.println(list.toString());
    }

    @Test void testCode02() {
        DemoMemberVO vo = testMapper.oneToMany();
        System.out.println(vo.toString());
    }
}
