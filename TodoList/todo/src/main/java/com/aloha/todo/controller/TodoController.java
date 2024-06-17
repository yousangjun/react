package com.aloha.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aloha.todo.dto.Todo;
import com.aloha.todo.service.TodoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    // 완
    @GetMapping()
    public ResponseEntity<?> getAll() {
        try {
            List<Todo> todoList = todoService.list();
            return new ResponseEntity<>(todoList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 완
    @GetMapping("/{no}")
    public ResponseEntity<?> getOne(@PathVariable("no") int no) {
        try {
            Todo todo = todoService.select(no);
            return new ResponseEntity<>("Todo 조회 완료", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 완
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Todo todo) {
        try {
            Todo newTodo = todoService.insert(todo);
            if (newTodo != null)
                return new ResponseEntity<>(newTodo, HttpStatus.OK);
            else
                return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Todo todo) {

        int no = todo.getNo();
        log.info("todo : " + todo);
        log.info("no : " + no);

        try {
            if (no == 0) {
                todoService.completeAll();
                return new ResponseEntity<>("전체 완료", HttpStatus.OK);
            } else {
                todoService.update(todo);
                return new ResponseEntity<>("Todo 수정 완료", HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 완
    @DeleteMapping("/{no}")
    public ResponseEntity<?> destroy(@PathVariable("no") int no) {
        try {
            todoService.delete(no);
            return new ResponseEntity<>("Todo 삭제완료", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping()
    public ResponseEntity<?> destroy() {
        try {
            todoService.deletePro();
            return new ResponseEntity<>("Todo 전체 삭제완료", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
