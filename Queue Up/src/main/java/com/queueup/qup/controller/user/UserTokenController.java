package com.queueup.qup.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user-token")
public class UserTokenController{
    @GetMapping
    public String openUserTokenPage(){
        return "userToken";
    }
}
