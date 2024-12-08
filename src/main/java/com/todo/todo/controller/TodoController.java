package com.todo.todo.controller;

import com.todo.todo.model.Todo;
import com.todo.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService=todoService;
    }

    @PostMapping("/todo")
    public Todo createTodo(@RequestBody Todo todo){
        return todoService.create(todo);
    }

    @GetMapping("/todo/{id}")
    public Todo getTodo(@PathVariable String id){
        return todoService.getTodo(id);
    }
}
