package com.example.jpa.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.data.util.Lazy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MEMBER")
@EntityListeners(AuditingEntityListener.class) //자동입력되는 날짜
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString
public class Member {

    @Id
    private String id;
    @Column(nullable = false, length = 50)
    private String name;
    //기본으로 지정되는 날짜
    @CreatedDate//JPA를 통해서 날짜가 자동입력되는 어노테이션 (오디팅리스너랑 함께 사용)
    @Column(updatable = false)//JPA에 의해서 자동으로 변경되는 것을 막음
    private LocalDateTime signDate; //가입일

    //원투매니 조인 - default조인방식은 lazy (조인을 걸고 필요한 시점에 붙일 Entity를 select하는 방식)
    // -> 실행 메서드에서 @Transactional을 반드시 붙여야 한다.
    // 또는 조인방식을 eager(즉시 조인을 걸어서 수행을 하겠다)
//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "member_id")
//    List<Memo> list = new ArrayList<>();

    //양방향조인 - toString 한쪽에서 반드시 지워줘야함
    //mapperdBy는 연관관계주인 - 메모테이블의 member 변수를 의미함
    @OneToMany(mappedBy = "member",  fetch = FetchType.LAZY)
    List<Memo> list = new ArrayList<>();


}
