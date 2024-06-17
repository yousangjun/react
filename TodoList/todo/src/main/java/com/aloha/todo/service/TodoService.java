package com.aloha.todo.service;

import java.util.List;

import com.aloha.todo.dto.Todo;

public interface TodoService {
    // 등록
    public Todo insert(Todo todo) throws Exception;

    // 전체조회
    public List<Todo> list() throws Exception;

    // no로 조회
    public Todo select(int no) throws Exception;

    // 수정
    public int update(Todo todo) throws Exception;

    // 삭제
    public int delete(int no) throws Exception;

    // 전체 삭제
    public int deletePro() throws Exception;

    // 전체 완료
    public int completeAll() throws Exception;
    
}
