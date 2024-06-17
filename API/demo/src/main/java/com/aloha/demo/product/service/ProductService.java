package com.aloha.demo.product.service;

import java.util.List;

import com.aloha.demo.product.dto.Product;

public interface ProductService {

    // 등록
    public int insert(Product product) throws Exception;

    // 아이디로 조회
    public Product selectProductId(int no) throws Exception;

    // 전체 조회
    public List<Product> selectAllProducts() throws Exception;

    // 수정
    public int updateProduct(Product product) throws Exception;

    // 삭제
    public int deleteProduct(int no) throws Exception;

}
