package com.insurance.PolicyManagementMicroservice.service;

import com.insurance.PolicyManagementMicroservice.entity.PolicyDetails;

import java.util.List;

public interface PolicyService
{
    //create or generate a Policy profile.
    PolicyDetails savePolicy(PolicyDetails PolicyDetails);

    //get all Policy details at once
    List<PolicyDetails> getAllPolicies();

    //get single Policy of the given data or id
    PolicyDetails getPolicy(String PolicyId);

    //update Policy details with the given id

    PolicyDetails updatePolicy(PolicyDetails PolicyDetails, String PolicyId);

    //delete Policy with the given id
    PolicyDetails deletePolicy(String PolicyId);

    //delete all Policy information
    PolicyDetails deleteAllPolicies();
}
