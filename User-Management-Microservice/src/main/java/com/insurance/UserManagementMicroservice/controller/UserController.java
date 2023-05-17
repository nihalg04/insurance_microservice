package com.insurance.UserManagementMicroservice.controller;

import com.insurance.UserManagementMicroservice.entity.UserDetails;
import com.insurance.UserManagementMicroservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserService userService;

    //creating the user
    @PostMapping
    public ResponseEntity<UserDetails> createUser(@RequestBody UserDetails userDetails)
    {
        log.info("A user is being created and the flow is in createUser of UserController.");
        UserDetails userDetails1 = userService.saveUser(userDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDetails1);
    }

    //get or display single user details
    @GetMapping("/{userId}")
    public ResponseEntity<UserDetails> getSingleUser(@PathVariable String userId)
    {
        log.info("A user is being displayed with the given id and the flow is in getSingleUser of UserController.");
        UserDetails userDetails = userService.getUser(userId);
        return ResponseEntity.ok(userDetails);
    }

    //get or display all the User details at once
    @GetMapping
    public  ResponseEntity<List<UserDetails>> getALlUserDetails()
    {
        log.info("A user is being displayed and the flow is in getALlUserDetails of UserController.");
        List<UserDetails> allUser = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.FOUND).body(allUser);
    }

    //update User details with the help of given id
    @PutMapping("/{userId}")
    public ResponseEntity<UserDetails> updateUser(@RequestBody UserDetails userDetails,@PathVariable String userId)
    {
        log.info("A user is being updated and the flow is in updateUser of UserController.");
        UserDetails userDetails1 = userService.updateUser(userDetails,userId);
        return ResponseEntity.ok(userDetails1);
    }


    //delete User with given id
    @DeleteMapping("/{userId}")
    public  ResponseEntity<UserDetails> deleteSingleUser(@PathVariable String userId)
    {
        log.info("A user is being deleted with the given id and the flow is in deleteSingleUser of UserController.");
        UserDetails userDetails = userService.deleteUser(userId);
        return ResponseEntity.ok(userDetails);
    }

    //delete AllUsers
    @DeleteMapping
    public ResponseEntity<UserDetails> deleteAllUsers()
    {
        log.info("All users are being created and the flow is in deleteAllUsers of UserController.");
        UserDetails userDetails = userService.deleteAllUsers();
        return ResponseEntity.ok(userDetails);
    }
}
