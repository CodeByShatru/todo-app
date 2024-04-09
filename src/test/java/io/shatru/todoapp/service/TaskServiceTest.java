package io.shatru.todoapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.shatru.todoapp.entity.Task;
import io.shatru.todoapp.repository.TaskRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TaskServiceTest {

	private TaskService taskService;
    private TaskRepository taskRepository;

    @BeforeEach
    public void setUp() {
        taskRepository = mock(TaskRepository.class);
        taskService = new TaskService(taskRepository);
    }


    @Test
    public void testCreateNewTask() {
        Task task = new Task();
        task.setId(1L);
        task.setTask("Test Task");
        task.setCompleted(false);

        when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task createdTask = taskService.createNewTask(task);

        assertEquals(task.getId(), createdTask.getId());
        assertEquals(task.getTask(), createdTask.getTask());
        assertFalse(createdTask.isCompleted());
    }

    @Test
    public void testGetAllTask() {
        List<Task> tasks = new ArrayList<>();
        Task task = new Task();
        task.setId(1L);
        task.setTask("Test Task");
        task.setCompleted(false);
        tasks.add(task);

        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> retrievedTasks = taskService.getAllTask();

        assertEquals(tasks.size(), retrievedTasks.size());
        assertEquals(tasks.get(0).getId(), retrievedTasks.get(0).getId());
        assertEquals(tasks.get(0).getTask(), retrievedTasks.get(0).getTask());
        assertEquals(tasks.get(0).isCompleted(), retrievedTasks.get(0).isCompleted());
    }
}
