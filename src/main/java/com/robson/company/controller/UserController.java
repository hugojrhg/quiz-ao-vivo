package com.robson.company.controller;

import com.robson.company.dto.UserDTO;
import com.robson.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("save")
    public UserDTO save(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @GetMapping("find-by-id/{id}")
    public UserDTO findById(@PathVariable Long id){
        return userService.fundById(id).get();
    }


}
