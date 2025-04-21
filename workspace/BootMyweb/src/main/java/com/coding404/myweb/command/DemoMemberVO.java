package com.coding404.myweb.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoMemberVO {
    private int mid;
    private String name;

    //1:N 조인에서는 list선언
    List<DemoOrderVO> orderList;

}
