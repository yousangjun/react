package com.aloha.server.service;

import java.util.List;

import com.aloha.server.dto.Board;

public interface BoardService {

    // 전체조회
    public List<Board> list() throws Exception;

    // 조회
    public Board select(int no) throws Exception;

    // 삭제
    public int delete(int no) throws Exception;

    // 수정
    public int update(Board board) throws Exception;

    // 등록
    public Board insert(Board board) throws Exception;
    
}
