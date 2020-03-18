package com.eci.cosw.springbootsecureapi.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.eci.cosw.springbootsecureapi.model.*;

/**
 *
 * @author Amalia
 */

public class AppTasksPersistence{

    //private final Map<String, Cinema> cinemas = new HashMap<>();    
    private Map<String, Task> tasks = new HashMap<>();
    private Map<String, User> users =  new HashMap<String, User>();

    public AppTasksPersistence() {
        User user0 = new User("00000", "Amalia", "Alfonso", "amaliaalfonso@gmail.com", "123", "amalia");
        User user1 = new User("11111", "Daniela", "Ospina", "danielaospina@gmail.com", "123", "daniela");
        User user2 = new User("22222", "Ana María", "Ospina", "anamariaospina@gmail.com", "123", "ana");
        User user3 = new User("33333", "Manuel", "Carmona", "manuelcarmona@gmail.com", "123", "manuel");
        users.put(user0.getId(), user0);
        users.put(user1.getId(), user1);
        users.put(user2.getId(), user2);
        users.put(user3.getId(), user3);

        String dueDate = "2018-12-18";
        Task task0 = new Task("0","Comprar cuadernos", user0.getId(), "In progress", dueDate);
        Task task1 = new Task("1", "Ordenar archivos", user3.getId(), "Ready", dueDate);
        Task task2 = new Task("2", "Entregar trabajo", user2.getId(), "Done", dueDate);
        
        tasks.put(task0.getTaskId(),task0);
        tasks.put(task1.getTaskId(), task1);
        tasks.put(task2.getTaskId(), task2);
        user0.addTask(task0);
        user3.addTask(task1);
        user2.addTask(task2);
    }   

    public List<User> getAllUsers() {
        List<User> listUsers = new ArrayList<>();
        for (String key : users.keySet()) {
            listUsers.add(users.get(key));
        }
        return listUsers;
    }

    public User getUserById(String userId) {
        User user = users.get(userId);
        return user;
    }

    public User addUser(User newUser) {
        users.put(newUser.getId(), newUser);
        return newUser;
    }

    public User updateUser(User updateUser) {
        users.replace(updateUser.getId(), updateUser);
        return updateUser;
    }

    public void deleteUser(String userId) {
        users.remove(userId);
    }

/*------------------------- TASKS -------------------------*/
    public List<Task> getAllTasks() {
        List<Task> listTasks = new ArrayList<>();
        for (String key : tasks.keySet()) {
            listTasks.add(tasks.get(key));
        }
        return listTasks;
    }

    public Task getTaskById(String taskId) {
        Task task = tasks.get(taskId);
        return task;
    }

    public List<Task> getTaskByUserId(String userId) {
        User user = users.get(userId);
        List<Task> listTasks = user.getTasks();
        return listTasks;
    }

    public Task assignTaskToUser(String taskId, String userId) {
        User user = users.get(userId);
        Task task = tasks.get(taskId);
        user.addTask(task);
        return task;
    }


    public void addTask(Task newTask) {
        tasks.put(newTask.getTaskId(), newTask);
    }

    public Task updateTask(Task updateTask) {
        tasks.replace(updateTask.getTaskId(), updateTask);
        return updateTask;
    }

    public void deleteTask(String taskId) {
        tasks.remove(taskId);
    }
    

}