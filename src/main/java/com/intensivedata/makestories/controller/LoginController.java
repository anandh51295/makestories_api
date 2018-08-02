package com.intensivedata.makestories.controller;


import com.intensivedata.makestories.model.Users;
import com.intensivedata.makestories.repository.UsersRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/login")

public class LoginController {
    @Autowired
    UsersRepository usersRepository;

    @RequestMapping(value = "/{username}/{password}")
    public  Users read(@PathVariable String username,@PathVariable String password){
        Users name,pass;
        name=usersRepository.findByUsername(username);
        try{
            String hashed = name.getPassword();
            if (BCrypt.checkpw(password, hashed))
                return name;
            else
                System.out.println("It does not match");
            return null;
        }catch (Exception e){
            System.out.println("username not found");
            return null;
        }



    }


}
