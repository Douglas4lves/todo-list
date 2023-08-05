package com.douglas.todolist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/task")
public class TaskController {
    
    @Autowired
    TaskService taskService;

    @PostMapping
    public TaskModel create(@RequestBody TaskModel task){
        return taskService.create(task);
    }

    @GetMapping
    public List<TaskModel> list(){
        return taskService.list();
    }

    @GetMapping("/{id}")
    public Optional<TaskModel> findById(@PathVariable(value = "id") Integer id){
        return taskService.findById(id);
    }

    @PutMapping("/{id}")
    public TaskModel update(@PathVariable(value = "id") Integer id, @RequestBody TaskModel task){
        return taskService.update(id, task);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id") Integer id){
        taskService.delete(id);
        return "TASK DELETED";
    }

}
