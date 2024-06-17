package com.aloha.todo.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Todo {

    private int no;
    private String name;
    private int status;
    private Date updDate;
    private Date regDAte;
    
}
