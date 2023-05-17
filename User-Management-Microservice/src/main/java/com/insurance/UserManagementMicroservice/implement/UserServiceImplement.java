package com.insurance.UserManagementMicroservice.implement;

import com.insurance.UserManagementMicroservice.entity.UserDetails;
import com.insurance.UserManagementMicroservice.exception.ResourceNotFoundException;
import com.insurance.UserManagementMicroservice.repository.UserRepository;
import com.insurance.UserManagementMicroservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImplement implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserDetails saveUser(UserDetails userDetails)
    {
        log.info("A user is being created and the flow is in saveUser of UserServiceImplement");

        String randomUserId = UUID.randomUUID().toString();
        userDetails.setUserId(randomUserId);

        return userRepository.save(userDetails);
    }

    @Override
    public List<UserDetails> getAllUsers() {
        log.info("All user is being displayed and the flow is in getAllUser of UserServiceImplement");
        return userRepository.findAll();
    }

    @Override
    public UserDetails getUser(String userId) {
        log.info("A user is being displayed with the given Id and the flow is in getUser of UserServiceImplement");
        UserDetails userDetails = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given Id has not found in the server/Database !!..."+ userId));

        //fetch policy, claims made and billing details
        

        return userDetails;
    }

    @Override
    public UserDetails updateUser(UserDetails userDetails, String userId)
    {
        log.info("A user is being updated and the flow is in updateUser of UserServiceImplement");

        UserDetails getUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given Id has not found in the server/Database !!..."+ userId));

        getUser.setName(userDetails.getName());
        getUser.setPhoneNumber(userDetails.getPhoneNumber());
        getUser.setEmailId(userDetails.getEmailId());
        getUser.setSex(userDetails.getSex());
        getUser.setAge(userDetails.getAge());

        return userRepository.save(getUser);
    }

    @Override
    public UserDetails deleteUser(String userId)
    {
        log.info("A user is being deleted and the flow is in deleteUser of UserServiceImplement");
        userRepository.deleteById(userId);
        return null;
    }

    @Override
    public UserDetails deleteAllUsers()
    {
        log.info("All users are being deleted and the flow is in deleteAllUsers of UserServiceImplement");
        userRepository.deleteAll();
        return null;
    }
}
