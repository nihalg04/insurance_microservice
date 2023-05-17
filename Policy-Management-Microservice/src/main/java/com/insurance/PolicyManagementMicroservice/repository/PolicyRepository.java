package com.insurance.PolicyManagementMicroservice.repository;

import com.insurance.PolicyManagementMicroservice.entity.PolicyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyRepository extends JpaRepository<PolicyDetails,String>
{
    //we will get everything we required from the JpaRepository ,so we have extended that class here.

    List<PolicyDetails> findByUserId(String userId);
}
