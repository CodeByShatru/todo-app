package io.shatru.todoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.shatru.todoapp.entity.Task;
import io.shatru.todoapp.repository.TaskRepository;

@Service
public class TaskService {

	
	private TaskRepository taskRepository;

	@Autowired
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public Task createNewTask(Task task) {
		return taskRepository.save(task);
	}

	public List<Task> getAllTask() {
		return taskRepository.findAll();
	}

	public Task getTaskById(Long id) {
		return taskRepository.getById(id);
	}

	public List<Task> getAllCompletedTask() {
		return taskRepository.findByCompletedTrue();
	}

	public List<Task> getAllInCompleteTask() {
		return taskRepository.findByCompletedFalse();
	}

	public void deleteTask(Task task) {
		taskRepository.delete(task);
	}

	public Task updateTask(Task task) {
		return taskRepository.save(task);
	}
}
