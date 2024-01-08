package com.caiolelis.todosimple.repositories;

import org.springframework.stereotype.Repository;

import com.caiolelis.todosimple.models.Task;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface TaskRepository extends JpaRepository<Task, Long> {

}
