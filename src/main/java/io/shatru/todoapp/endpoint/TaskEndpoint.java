package io.shatru.todoapp.endpoint;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.shatru.todoapp.entity.Task;
import io.shatru.todoapp.service.TaskService; 

@RestController
@RequestMapping("/api/v1/tasks") 
public class TaskEndpoint { 

	@Autowired
	private TaskService taskService; 
	@GetMapping("/") 
	public ResponseEntity<List<Task>> getAllTasks() { 
		return ResponseEntity.ok(taskService.getAllTask()); 
	} 
	@GetMapping("/completed") 
	public ResponseEntity<List<Task>> getAllCompletedTasks() { 
		return ResponseEntity.ok(taskService.getAllCompletedTask()); 
	} 
	@GetMapping("/incomplete") 
	public ResponseEntity<List<Task>> getAllIncompleteTasks() { 
		return ResponseEntity.ok(taskService.getAllInCompleteTask()); 
	} 
	@PostMapping("/") 
	public ResponseEntity<Task> createTask(@RequestBody Task task) { 
		return ResponseEntity.ok(taskService.createNewTask(task)); 
	} 
	@PutMapping("/{id}") 
	public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) { 
		task.setId(id); 
		return ResponseEntity.ok(taskService.updateTask(task)); 
	} 
	@DeleteMapping("/{id}") 
	public ResponseEntity<Boolean> getAllTasks(@PathVariable Long id) { 
		Task task = taskService.getTaskById(id);
		taskService.deleteTask(task); 
		return ResponseEntity.ok(true); 
	} 
}

