package com.douglas.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglas.todolist.model.TaskModel;

public interface TaskRepository extends JpaRepository<TaskModel, Integer> {

    
}
