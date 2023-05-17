package com.insurance.BillingManagementMicroservice.controller;

import com.insurance.BillingManagementMicroservice.entity.BillingDetails;
import com.insurance.BillingManagementMicroservice.service.BillingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/billing")
public class BillingController
{
    @Autowired
    private BillingService billingService;

    //creating the billing
    @PostMapping
    public ResponseEntity<BillingDetails> createBilling(@RequestBody BillingDetails billingDetails)
    {
        log.info("A billing is being created and the flow is in createBilling of billingController.");
        BillingDetails billingDetails1 = billingService.saveBilling(billingDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(billingDetails1);
    }

    //get or display single billing details
    @GetMapping("/{billingId}")
    public ResponseEntity<BillingDetails> getSingleBilling(@PathVariable String billingId)
    {
        log.info("A billing is being displayed with the given id and the flow is in getSingleBilling of billingController.");
        BillingDetails billingDetails = billingService.getBilling(billingId);
        return ResponseEntity.ok(billingDetails);
    }

    //get or display all the billing details at once
    @GetMapping
    public  ResponseEntity<List<BillingDetails>> getALlBillingDetails()
    {
        log.info("A billing is being displayed and the flow is in getALlbillingDetails of billingController.");
        List<BillingDetails> allBilling = billingService.getAllBillings();
        return ResponseEntity.status(HttpStatus.FOUND).body(allBilling);
    }

    //update billing details with the help of given id
    @PutMapping("/{billingId}")
    public ResponseEntity<BillingDetails> updateBilling(@RequestBody BillingDetails billingDetails,@PathVariable String billingId)
    {
        log.info("A billing is being updated and the flow is in updatebilling of billingController.");
        BillingDetails billingDetails1 = billingService.updateBilling(billingDetails,billingId);
        return ResponseEntity.ok(billingDetails1);
    }


    //delete billing with given id
    @DeleteMapping("/{billingId}")
    public  ResponseEntity<BillingDetails> deleteSingleBilling(@PathVariable String billingId)
    {
        log.info("A billing is being deleted with the given id and the flow is in deleteSingleBilling of billingController.");
        BillingDetails billingDetails = billingService.deleteBilling(billingId);
        return ResponseEntity.ok(billingDetails);
    }

    //delete AllBillings
    @DeleteMapping
    public ResponseEntity<BillingDetails> deleteAllBillings()
    {
        log.info("All billings are being created and the flow is in deleteAllBillings of billingController.");
        BillingDetails billingDetails = billingService.deleteAllBillings();
        return ResponseEntity.ok(billingDetails);
    }

    //get Billing by User Id
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<BillingDetails>> getBillingByUserId(@PathVariable String userId)
    {
        return ResponseEntity.ok(billingService.getBillingByUserId(userId));
    }

    //get Billing by Claims id
    @GetMapping("/claims/{claimsId}")
    public ResponseEntity<List<BillingDetails>> getBillingByClaimsId(@PathVariable String claimsId)
    {
        return ResponseEntity.ok(billingService.getBillingByClaimsId(claimsId));
    }
}
