package com.todo.restfulwebservice.service;

import com.todo.restfulwebservice.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todos=new ArrayList<Todo>();
    private static long idCounter=0;

    static {
        todos.add(new Todo(++idCounter, "NigusKidane", "Learn Node.js", new Date(), false));
        todos.add(new Todo(++idCounter, "JhonBob", "Visit Paris", new Date(), false));
        todos.add(new Todo(++idCounter, "SeliTeshome", "Visit my country", new Date(), false));
    }

    public List<Todo> getAllTodos(){
        return todos;
    }

    public Todo update(Todo todo){
        if(todo.getId()==-1 || todo.getId()==0){
            todo.setId(++idCounter);
            todos.add(todo);
        }else{
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }

    public Todo save(Todo todo){
        todo.setId(++idCounter);
        todos.add(todo);
        return todo;
    }

    public Todo deleteById(long id){
        Todo todo=findById(id);
        if(todo==null){
            return null;
        }
        if(todos.remove(todo)){
            return todo;
        }
        return null;
    }

    public Todo findById(long id){
        for(Todo todo:todos){
            if(todo.getId()==id){
                return todo;
            }
        }
        return null;
    }
}
