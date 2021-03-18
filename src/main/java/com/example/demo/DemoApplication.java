package com.example.demo;

import org.apache.catalina.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@Controller
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    Cache cache = new Cache();

    @GetMapping("/get-user-data")
    @ResponseBody
    public String getUserData(@RequestParam int userId){

        //Tjek om Id'et er i cachen?
        cache.has(userId); //Den gav false

        //add value to the cache
        cache.set(1,"Flottefyr");
        cache.set(2,"Sebber");
        cache.set(3,"Simnumsen");

        //Få valuen printet via userId
        cache.get(userId);

        //Delete the value from cache
        cache.delete(userId);

        return "wuhu";
    }

    @GetMapping("/get-user-data-improved")
    @ResponseBody
    public String getUserDataImproved(@RequestParam int userId) throws InterruptedException {

        if(cache.has(userId)){
            return cache.get(userId);
        } else{
            user user0 = new user(userId);
            cache.set(userId, user0.getDataSlow());
            return cache.get(userId);
        }
    }
}
