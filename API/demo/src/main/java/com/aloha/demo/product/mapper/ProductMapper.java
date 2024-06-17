package com.aloha.demo.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aloha.demo.product.dto.Product;

@Mapper
public interface ProductMapper {

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
