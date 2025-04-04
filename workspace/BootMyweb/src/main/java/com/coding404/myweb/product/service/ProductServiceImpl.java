package com.coding404.myweb.product.service;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.util.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("productService") //멤버변수 이름과 동일한 이름
public class ProductServiceImpl implements ProductService { //ProductService를 상속받음

    @Autowired
    private ProductMapper productMapper; //생성한 productMapper를 자동삽입

    @Override
    public int productRegist(ProductVO vo) {
        return productMapper.productRegist(vo);
    }

    @Override
    public ArrayList<ProductVO> getList(String prodWriter, Criteria cri) {
        return productMapper.getList(prodWriter, cri);//service에서 호출
    }

    @Override
    public int getTotal(String prodWriter, Criteria cri) {
        return productMapper.getTotal(prodWriter, cri); //전체 게시글 수
    }

    @Override
    public ProductVO getDetail(String prodId) {
        return productMapper.getDetail(prodId);
    }

    @Override
    public void productUpdate(ProductVO vo) {
        productMapper.productUpdate(vo);
    }

    @Override
    public int productDelete(ProductVO vo) {
        return productMapper.productDelete(vo);
    }

}
