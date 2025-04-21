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
public class ProductUploadVO {

    private Integer uploadNo;
    private String filename;
    private String filepath;
    private String uuid;
    private LocalDateTime regdate;
    private Integer prodId;
    private String prodWriter;
}
