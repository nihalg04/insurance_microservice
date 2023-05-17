package com.insurance.UserManagementMicroservice.service;

import com.insurance.UserManagementMicroservice.entity.UserDetails;

import java.util.List;

public interface UserService
{
    //create or generate a user profile.
    UserDetails saveUser(UserDetails userDetails);

    //get all user details at once
    List<UserDetails> getAllUsers();

    //get single user of the given data or id
    UserDetails getUser(String UserId);

    //update user details with the given id

    UserDetails updateUser(UserDetails userDetails, String userId);

    //delete user with the given Id
    UserDetails deleteUser(String userId);

    UserDetails deleteAllUsers();
}
