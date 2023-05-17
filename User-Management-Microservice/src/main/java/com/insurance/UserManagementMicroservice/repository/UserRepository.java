package com.insurance.UserManagementMicroservice.repository;

import com.insurance.UserManagementMicroservice.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetails,String>
{
    //we will get everything we required from the JpaRepository ,so we have extended that class here.
}
