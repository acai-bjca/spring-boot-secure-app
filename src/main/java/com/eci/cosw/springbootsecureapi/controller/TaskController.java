package com.eci.cosw.springbootsecureapi.controller;

import java.util.List;

import com.eci.cosw.springbootsecureapi.model.*;
import com.eci.cosw.springbootsecureapi.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Amalia Alfonso
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController // 1
@RequestMapping(value = "api/tasks") // 2
public class TaskController {
    
    @Autowired
    private TaskService taskService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Task>> manejadorGetRecursoTareas() {
        List<Task> tasks = taskService.getAll();
        return new ResponseEntity<>(tasks, HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{taskId}")
    public ResponseEntity<Task> manejadorGetRecursoTareaPorId(@PathVariable String taskId) {
        Task task = taskService.getById(taskId);
        return new ResponseEntity<>(task, HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    public ResponseEntity<List<Task>> manejadorGetRecursoTareas(@PathVariable String userId) {
        List<Task> tasks = taskService.getByUserId(userId);
        return new ResponseEntity<>(tasks, HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{userId}")
    public ResponseEntity<Task> manejadorPostRecursoTareas(@RequestBody Task newTask, @PathVariable String userId) {
        List<Task> tasks = taskService.getByUserId(userId);
        tasks.add(newTask);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{taskId}")
    public ResponseEntity<?> manejadorDeleteRecursoTarea(@PathVariable String taskId) {
        taskService.remove(taskId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> manejadorPutRecursoTarea(@RequestBody Task taskUpdate) {
        taskService.update(taskUpdate);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }    
}