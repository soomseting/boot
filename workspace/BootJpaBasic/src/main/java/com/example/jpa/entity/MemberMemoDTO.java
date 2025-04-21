package com.example.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberMemoDTO {
    //member와 memo의 필요한 컬럼들을 명시
    private String id; //member
    private String name; //member
    private LocalDateTime signDate; //member
    private long mno;
    private String writer;
    private String text;
}
