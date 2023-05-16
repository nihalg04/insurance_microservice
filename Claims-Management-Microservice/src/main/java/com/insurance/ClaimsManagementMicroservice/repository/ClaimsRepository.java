package com.insurance.ClaimsManagementMicroservice.repository;

import com.insurance.ClaimsManagementMicroservice.entity.ClaimsDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimsRepository extends JpaRepository<ClaimsDetails,String>
{
    //we will get everything we required from the JpaRepository ,so we have extended that class here.
}
