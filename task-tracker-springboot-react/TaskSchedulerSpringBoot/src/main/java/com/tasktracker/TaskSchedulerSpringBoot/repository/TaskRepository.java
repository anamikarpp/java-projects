package com.tasktracker.TaskSchedulerSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tasktracker.TaskSchedulerSpringBoot.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
