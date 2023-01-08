package com.demo.tododemo.rest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.tododemo.data.entities.ToDoItem;
import com.demo.tododemo.data.repositories.ToDoItemRepository;

@RestController
@RequestMapping("/todo")
public class ToDoResource {
    
    @Autowired
    private ToDoItemRepository repository;

    @GetMapping
    public ResponseEntity<?> getAllToDos(){
        List<ToDoItem> toDoList = repository.findAll();
        return new ResponseEntity<>(toDoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveToDo(@RequestBody ToDoItem newToDo){
        ToDoItem persistedToDo = repository.save(newToDo);
        return new ResponseEntity<>(persistedToDo, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateToDo(@RequestBody ToDoItem updatedToDo){
        ToDoItem persistedToDo = repository.save(updatedToDo);
        return new ResponseEntity<>(persistedToDo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteToDo(@PathVariable String id){
        try{
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(IllegalArgumentException exception){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
