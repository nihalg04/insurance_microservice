package com.insurance.PolicyManagementMicroservice.controller;

import com.insurance.PolicyManagementMicroservice.entity.PolicyDetails;
import com.insurance.PolicyManagementMicroservice.service.PolicyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/policy")
public class PolicyController
{
    @Autowired
    private PolicyService policyService;

    //creating the user
    @PostMapping
    public ResponseEntity<PolicyDetails> createUser(@RequestBody PolicyDetails policyDetails)
    {
        log.info("A policy is being created and the flow is in createUser of PolicyController.");
        PolicyDetails policyDetails1 = policyService.savePolicy(policyDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(policyDetails1);
    }

    //get or display single user details
    @GetMapping("/{policyId}")
    public ResponseEntity<PolicyDetails> getSinglePolicy(@PathVariable String policyId)
    {
        log.info("A Policy is being displayed with the given id and the flow is in getSinglePolicy of PolicyController.");
        PolicyDetails userDetails = policyService.getPolicy(policyId);
        return ResponseEntity.ok(userDetails);
    }

    //get or display all the User details at once
    @GetMapping
    public  ResponseEntity<List<PolicyDetails>> getALlPoliciesDetails()
    {
        log.info("All policies are being displayed and the flow is in getALlPoliciesDetails of PolicyController.");
        List<PolicyDetails> allUser = policyService.getAllPolicies();
        return ResponseEntity.status(HttpStatus.FOUND).body(allUser);
    }

    //update User details with the help of given id
    @PutMapping("/{policyId}")
    public ResponseEntity<PolicyDetails> updatePolicy(@RequestBody PolicyDetails policyDetails,@PathVariable String policyId)
    {
        log.info("A policy is being updated and the flow is in updatePolicy of PolicyController.");
        PolicyDetails policyDetails1 = policyService.updatePolicy(policyDetails,policyId);
        return ResponseEntity.ok(policyDetails1);
    }


    //delete User with given id
    @DeleteMapping("/{policyId}")
    public  ResponseEntity<PolicyDetails> deleteSinglePolicy(@PathVariable String policyId)
    {
        log.info("A policy is being deleted with the given id and the flow is in deleteSinglePolicy of PolicyController.");
        PolicyDetails userDetails = policyService.deletePolicy(policyId);
        return ResponseEntity.ok(userDetails);
    }

    //delete AllUsers
    @DeleteMapping
    public ResponseEntity<PolicyDetails> deleteAllPolicies()
    {
        log.info("All policies are being created and the flow is in deleteAllPolicies of PolicyController.");
        PolicyDetails policyDetails = policyService.deleteAllPolicies();
        return ResponseEntity.ok(policyDetails);
    }

    @GetMapping("/users/userId")
    public ResponseEntity<List<PolicyDetails>> getPolicyByUserId(@PathVariable String userId)
    {
        return ResponseEntity.ok(policyService.getPolicyByUserId(userId));
    }
}
