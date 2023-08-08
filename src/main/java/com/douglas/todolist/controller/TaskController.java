package com.douglas.todolist.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.douglas.todolist.model.TaskModel;
import com.douglas.todolist.service.TaskService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/task")
public class TaskController {
    
    @Autowired
    TaskService taskService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid TaskModel task, BindingResult bindingResult ){
        if(bindingResult.hasErrors()){
            List<String> erros = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
                    return ResponseEntity.badRequest().body(erros);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.create(task));
    }

    @GetMapping
    public ResponseEntity<List<TaskModel>> list(){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Integer id){
        try{
            TaskModel getById = taskService.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(getById);
        }catch(EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Integer id, @RequestBody @Valid TaskModel task, 
    BindingResult bindingResult ){
        try{
            if(bindingResult.hasErrors()){
            List<String> erros = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
                    return ResponseEntity.badRequest().body(erros);
            }
            return ResponseEntity.status(HttpStatus.OK).body(taskService.update(id, task));
        }catch(EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Integer id){
        try{
            taskService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Tarefa Deletada");
        }catch(EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
