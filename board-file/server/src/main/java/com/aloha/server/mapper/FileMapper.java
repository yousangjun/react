package com.aloha.server.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aloha.server.dto.Files;

@Mapper
public interface FileMapper {

    // 전체조회
    public List<Files> list() throws Exception;

    // 조회
    public Files select(int no) throws Exception;

    // 삭제
    public int delete(int no) throws Exception;

    // 수정
    public int update(Files file) throws Exception;

    // 등록
    public int insert(Files file) throws Exception;

    // 파일 목록 - 부모 기준
    public List<Files> listByParent(Files file) throws Exception;

}
