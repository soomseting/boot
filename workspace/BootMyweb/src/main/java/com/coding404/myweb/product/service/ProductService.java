package com.coding404.myweb.product.service;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.util.Criteria;

import java.util.ArrayList;

public interface ProductService {
    int productRegist(ProductVO vo);
    //service에 먼저 선언함 getList라는 매개변수가 있다라고 하는 놈을 생성 //mapper.java에도 똑같이 생성
//    ArrayList<ProductVO> getList(String prodWriter);
    ArrayList<ProductVO> getList(String prodWriter, Criteria cri);
    int getTotal(String prodWriter);


    ProductVO getDetail(String prodId);
    void productUpdate(ProductVO vo);
    int productDelete(ProductVO vo);
}


//controller에서 넘어갈 화면에 필요한 뭘 적고 service로 와서 id와 반환값 적어주고 mapper에도 똑같이 적용한 후
// serviceimpl에 override한 후 mapperxml에다가 해당 sql을 작성 후 다시 controller로 이동해서