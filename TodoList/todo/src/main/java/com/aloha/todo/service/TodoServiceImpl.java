package com.aloha.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.todo.dto.Todo;
import com.aloha.todo.mapper.TodoMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoMapper todoMapper;

    @Override
    public Todo insert(Todo todo) throws Exception {
        int result = todoMapper.insert(todo);
        log.info("todo Service에서 조회 : " + todo);
        log.info("result : " + result);
        int newTodoNo = todo.getNo();
        log.info("newTodoNo : " + newTodoNo);
        Todo newTodo = todoMapper.select(newTodoNo);
        log.info("todo db갔다가와서 조회 : " + newTodo);
        return newTodo;
    }


    @Override
    public Todo select(int no) throws Exception {
        
        Todo todo = todoMapper.select(no);
        return todo;
    }

    @Override
    public int update(Todo todo) throws Exception {

        int result = todoMapper.update(todo);
        return result;
    }

    @Override
    public int delete(int no) throws Exception {

        int result = todoMapper.delete(no);
        return result;
    }


    @Override
    public List<Todo> list() throws Exception {

        List<Todo> todoList = todoMapper.list();

        return todoList;

        
    }


    @Override
    public int deletePro() throws Exception {

        int result = todoMapper.deletePro();

        return result;
    }


    @Override
    public int completeAll() throws Exception {

        int result = todoMapper.completeAll();

        return result;
    }

}
