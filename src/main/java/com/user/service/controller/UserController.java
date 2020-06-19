package com.user.service.controller;

import com.user.service.response.UserRegistrationBean;
import com.user.service.response.UserResponseBean;
import com.user.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/v1/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping(value = "/register",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseBean> register(@RequestBody @Valid UserRegistrationBean userRegistrationBean) throws Exception {
        log.info("Received request to createContact user {}", userRegistrationBean);
        return  new ResponseEntity<UserResponseBean>(userService.register(userRegistrationBean), CREATED);
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseBean> getUserById(@PathVariable Long userId) throws Exception {
        log.info("Request to get user id {} info", userId);
        return  new ResponseEntity<UserResponseBean>(userService.getUserById(userId), OK);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserResponseBean>> listAllUser() throws Exception {
        log.info("Request to get all user");
        return  new ResponseEntity<List<UserResponseBean>>(userService.getAllUser(), OK);
    }


}
