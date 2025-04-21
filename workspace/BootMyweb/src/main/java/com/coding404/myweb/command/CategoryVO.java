package com.coding404.myweb.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryVO {

    private Integer categoryId;
    private String groupId;
    private Integer categoryLv;
    private String categoryNm;
    private Integer categoryDetailLv;
    private String categoryDetailNm;
    private Integer categoryParentLv;
    private Integer categoryDetailParentLv;
}
