package com.pollServiceProject.controller;

import com.pollServiceProject.userServiceFeignClient.UserService;
import com.pollServiceProject.userServiceFeignClient.UserServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-service-client")
public class UserServiceController {
    @Autowired
    private UserService userService;
    @GetMapping("/{userId}")
    public UserServiceResponse getUserById(@PathVariable Long userId){
       return userService.getUserById(userId);
    }
    @GetMapping("/check-registration/{userId}")
    public Boolean isUserRegistered(@PathVariable Long userId){
        return userService.isUserRegistered(userId);
    }
}
