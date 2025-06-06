package com.coding404.myweb.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductVO {
    private Integer prodId;
    private LocalDateTime prodRegdate;
    private String prodEnddate;
    private String prodCategory;
    private String prodWriter;
    private String prodName;
    private Integer prodPrice;
    private Integer prodCount;
    private Integer prodDiscount;
    private String prodPurchaseYn;
    private String prodContent;
    private String prodComment;

    //N:1조인을 위한 컬럼
    private String categoryNav;
}
