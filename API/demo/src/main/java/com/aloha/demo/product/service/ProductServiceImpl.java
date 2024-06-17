package com.aloha.demo.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.demo.product.dto.Product;
import com.aloha.demo.product.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public int insert(Product product) throws Exception {

        int result = productMapper.insert(product);
        return result;
    }

    @Override
    public Product selectProductId(int no) throws Exception {

        return productMapper.selectProductId(no);
    }

    @Override
    public int updateProduct(Product product) throws Exception {

        int result = productMapper.updateProduct(product);
        return result;
    }

    @Override
    public int deleteProduct(int no) throws Exception {

        int result = productMapper.deleteProduct(no);
        return result;
    }

    @Override
    public List<Product> selectAllProducts() throws Exception {

        List<Product> productList = productMapper.selectAllProducts();

        return productList;
    }
    
}
