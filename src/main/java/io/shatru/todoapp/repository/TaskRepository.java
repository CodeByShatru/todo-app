package io.shatru.todoapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.shatru.todoapp.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	public Task findByTask(String task);

	public List<Task> findByCompletedTrue();

	public List<Task> findByCompletedFalse();

	public List<Task> findAll();

	public Task getById(Long id);
}
