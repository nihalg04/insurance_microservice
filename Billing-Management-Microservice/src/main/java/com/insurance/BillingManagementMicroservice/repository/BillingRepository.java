package com.insurance.BillingManagementMicroservice.repository;

import com.insurance.BillingManagementMicroservice.entity.BillingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<BillingDetails,String>
{
    //we will get everything we required from the JpaRepository ,so we have extended that class here.
}
