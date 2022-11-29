package com.example.RestAPIController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MyController {

    @Autowired
    OtherController obj;
    Map<Integer , User> users = new HashMap<>();

    @GetMapping("/bean")
    public int getBean(){
        return obj.getId();
    }

    @GetMapping("/bean2")
    public int getBean2(){
        obj.setId(5);
        return obj.getId();
    }

    @GetMapping("/get_users")
    public List<User> getUsers(){
        List<User> listOfUsers = new ArrayList<>();
        for(User user : users.values()){
            listOfUsers.add(user);
        }

        return listOfUsers;
    }

    @PostMapping("/add_users")
    public void addUser(@RequestParam("id") int id,
                        @RequestParam("name") String name,
                        @RequestParam("country") String country,
                        @RequestParam("age") int age){
        User user = new User(id , name , country , age);
        users.put(id, user);
    }


    @PostMapping("/add_users_body")
    public void addUserBody(@RequestBody(required = true)User user){
        users.put(user.getId() , user);
    }

    @GetMapping("/get_users/{id}")
    public User getUsers(@PathVariable("id") int u){
        return users.get(u);
    }

    @DeleteMapping("/del_user/{id}")
    public void deleteUser(@PathVariable("id") int x){
        users.remove(x);
    }

    @PutMapping("/update_user/{id}")
    public void updateUser(@PathVariable("id") int id , @RequestBody(required=true)User user){
        users.put(id , user);
    }



}
