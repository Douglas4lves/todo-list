package com.douglas.todolist.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import com.douglas.todolist.model.TaskModel;
import com.douglas.todolist.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;
    
    /**
     * @return
     */
    public List<TaskModel> list(){
        return taskRepository.findAll();
    }

    public TaskModel create(TaskModel task){
        return taskRepository.save(task);
    }

    public TaskModel update(Integer id, TaskModel task){
        task.setId(id);
        return taskRepository.save(task);
    }

    public Optional<TaskModel> findById(Integer id){
        return taskRepository.findById(id);
    }

    public void delete(Integer id){
        taskRepository.deleteById(id);
    }



}
