package com.example.ai_generated_todo_list.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Testcontainers
public class TodoItemControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Container
  private static final MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:latest")
      .withDatabaseName("testdb")
      .withUsername("testuser")
      .withPassword("testpassword");

  // Set up your database properties using the container's URL, username, and password

  @Test
  public void testGetAllTodoItems() throws Exception {
    mockMvc.perform(get("/api/todo"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    // Add assertions for specific content if needed
  }

  @Test
  @Transactional
  public void testCreateAndGetTodoItem() throws Exception {
    String todoItemJson = "{\"title\":\"Task 1\",\"description\":\"Description for task 1\"}";

    mockMvc.perform(post("/api/todo")
            .contentType(MediaType.APPLICATION_JSON)
            .content(todoItemJson))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.title").value("Task 1"))
        .andExpect(jsonPath("$.description").value("Description for task 1"));
    // Add assertions for specific content if needed
  }

  @Test
  @Transactional
  public void testUpdateTodoItem() throws Exception {
    String todoItemJson = "{\"title\":\"Updated Task\",\"description\":\"Updated description\"}";

    mockMvc.perform(post("/api/todo")
            .contentType(MediaType.APPLICATION_JSON)
            .content(todoItemJson))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    String updatedJson = "{\"title\":\"Updated Title\",\"description\":\"Updated Description\"}";

    mockMvc.perform(put("/api/todo/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(updatedJson))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.title").value("Updated Title"))
        .andExpect(jsonPath("$.description").value("Updated Description"));
    // Add assertions for specific content if needed
  }

  @Test
  @Transactional
  public void testDeleteTodoItem() throws Exception {
    String todoItemJson = "{\"title\":\"Task to delete\",\"description\":\"Description for task to delete\"}";

    mockMvc.perform(post("/api/todo")
            .contentType(MediaType.APPLICATION_JSON)
            .content(todoItemJson))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    mockMvc.perform(delete("/api/todo/1"))
        .andExpect(status().isOk());
  }
}