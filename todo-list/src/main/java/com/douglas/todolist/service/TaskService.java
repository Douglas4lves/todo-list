package com.douglas.todolist.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.todolist.model.TaskModel;
import com.douglas.todolist.repository.TaskRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;
    
    public List<TaskModel> list(){
        return taskRepository.findAll();
    }

    public TaskModel create(TaskModel task){
        return taskRepository.save(task);
    }

    public TaskModel update(Integer id, TaskModel task){
        getById(id);
        task.setId(id);
        return taskRepository.save(task);
    }

    public TaskModel getById(Integer id){
        return taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Id não encontrado: " + id));
        
    }

    public void delete(Integer id){
        getById(id);
        taskRepository.deleteById(id);
    }




}
