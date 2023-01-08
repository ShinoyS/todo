package com.demo.tododemo.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.demo.tododemo.data.entities.ToDoItem;

public interface ToDoItemRepository extends MongoRepository<ToDoItem,String> {
    
}
