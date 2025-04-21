package com.coding404.myweb.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoOrderVO {
    private int oid;
    private int mid;
    private String productName;

    //1st - 1관계 테이블 여러컬럼이 필요한 게 아니면, 단순히 컬럼명을 n에 추가하면 됨
    //private String name;

    //2nd - 객체맵핑
    private DemoMemberVO member;
}
