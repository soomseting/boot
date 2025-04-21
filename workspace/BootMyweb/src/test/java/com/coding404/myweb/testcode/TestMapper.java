package com.coding404.myweb.testcode;

import com.coding404.myweb.command.DemoMemberVO;
import com.coding404.myweb.command.DemoOrderVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {

    List<DemoOrderVO> manyToOne(); // N:1 조인
    DemoMemberVO oneToMany();// 1:N 조인

}
