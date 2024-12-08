package com.todo.todo.service;

import com.todo.todo.repository.TodoRepository;
import com.todo.todo.model.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TodoServiceTest {

    @Mock
    TodoRepository todoRepository;

    @InjectMocks
    TodoService todoService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTodo(){
        Todo todo = new Todo();
        todo.setTitle("Test Task");

        when(todoRepository.save(any(Todo.class))).thenReturn(todo);

        Todo result=todoService.create(todo);

        assertNotNull(result);
        assertEquals("Test Task",result.getTitle());
        verify(todoRepository,times(1)).save(todo);
    }

    @Test
    public void testGetTodo() {
        Todo todo= new Todo();
        todo.setId("Test");

        when(todoRepository.findById("Test")).thenReturn(Optional.of(todo));

        Todo testTodo= todoService.getTodo("Test");
        assertEquals("Test",testTodo.getId());
    }
}