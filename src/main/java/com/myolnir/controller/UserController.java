package com.myolnir.controller;

import com.myolnir.dto.UserDto;
import com.myolnir.model.UserDO;
import com.myolnir.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController{


    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/user/info", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    UserDto retrieveUserInfo(@RequestHeader(value = "Authorization") String authorization) throws Exception {
        //At this the provided token are authenticated so we can get the username email from the security context from spring.
        SecurityContext context = SecurityContextHolder.getContext();
        String userName = context.getAuthentication().getName();
        UserDO user = userRepository.findByEmail(userName);
        //Here you have the user from your own database and can get the user details.
        UserDto jsonUser = new UserDto();
        jsonUser.setName(user.getName());
        jsonUser.setId(String.valueOf(user.getUserId()));
        return jsonUser;
    }

}

