package com.insurance.UserManagementMicroservice.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResourceNotFoundException extends RuntimeException
{
    //Exception if the details entered has not found
    public ResourceNotFoundException()
    {
        super("Resource not found on the server/Database !!... ");
        log.warn("An Exception has encountered.");
    }

    //exception if sender has some parametrised message
    public ResourceNotFoundException(String message)
    {
        super(message);
        log.warn("The user has thrown a message and exception has encountered.");
    }
}
