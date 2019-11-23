package com.todo.restfulwebservice.controller;


import com.todo.restfulwebservice.model.Todo;
import com.todo.restfulwebservice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable("username") String username){
    return todoService.getAllTodos();

    }

    @GetMapping("users/{username}/todos/{id}")
    public Todo getAllTodos(@PathVariable("username") String username, @PathVariable("id") Long id){
        return todoService.findById(id);
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> saveTodo(@PathVariable("username") String username, @RequestBody Todo todo){
              Todo todoCreated = todoService.save(todo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todoCreated.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("username") String username, @PathVariable("id") long id,@RequestBody Todo todo){

        Todo todoUpdated=todoService.update(todo);
        ResponseEntity<Todo> todoResponseEntity = new ResponseEntity<>(todoUpdated, HttpStatus.OK);

        return todoResponseEntity;
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("username") String username, @PathVariable("id") long id){
        Todo todo=todoService.deleteById(id);
        if(todo!=null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
