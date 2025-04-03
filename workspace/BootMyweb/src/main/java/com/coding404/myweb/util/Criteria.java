package com.coding404.myweb.util;

import lombok.Data;

@Data//getter, setter, toString
public class Criteria {

    //사용자가 조회하는 페이지번호, 데이터 개수
    private int page; //페이지번호
    private int amount; //데이터개수

    public Criteria() {
        this(1,10);
    }

    public Criteria(int page, int amount) {
        this.page = page;
        this.amount = amount;
    }

    //리미트 함수의 첫 번재 값에 전달될 함수임
    public int getPageStart(){
        return (page - 1) * amount;
    }
}
