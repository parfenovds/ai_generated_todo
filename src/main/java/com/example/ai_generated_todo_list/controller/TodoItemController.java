package com.example.ai_generated_todo_list.controller;

import com.example.ai_generated_todo_list.entity.TodoItem;
import com.example.ai_generated_todo_list.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoItemController {

  @Autowired
  private TodoItemRepository todoItemRepository;

  @GetMapping
  public List<TodoItem> getAllTodoItems() {
    return todoItemRepository.findAll();
  }

  @GetMapping("/{id}")
  public TodoItem getTodoItemById(@PathVariable Long id) {
    return todoItemRepository.findById(id).orElse(null);
  }

  @PostMapping
  public TodoItem createTodoItem(@RequestBody TodoItem todoItem) {
    return todoItemRepository.save(todoItem);
  }

  @PutMapping("/{id}")
  public TodoItem updateTodoItem(@PathVariable Long id, @RequestBody TodoItem todoItem) {
    todoItem.setId(id);
    return todoItemRepository.save(todoItem);
  }

  @DeleteMapping("/{id}")
  public void deleteTodoItem(@PathVariable Long id) {
    todoItemRepository.deleteById(id);
  }
}
