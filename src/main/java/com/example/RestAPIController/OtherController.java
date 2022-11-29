package com.example.RestAPIController;

import org.springframework.stereotype.Component;

@Component
public class OtherController {

    private int id = 10;

    public OtherController(){
        System.out.println("Spring is creating the object...");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
