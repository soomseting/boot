package com.coding404.myweb.product.service;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.util.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface ProductMapper {
    int productRegist(ProductVO vo);
//    ArrayList<ProductVO> getList(String prodWriter);
    ArrayList<ProductVO> getList(@Param("prodWriter") String prodWriter,
                                 @Param("cri") Criteria cri);
    int getTotal(String prodWriter, Criteria cri);

    ProductVO getDetail(String prodId);
    void productUpdate(ProductVO vo);
    int productDelete(ProductVO vo);

}
