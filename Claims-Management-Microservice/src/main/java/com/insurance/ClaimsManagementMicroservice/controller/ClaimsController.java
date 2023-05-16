package com.insurance.ClaimsManagementMicroservice.controller;

import com.insurance.ClaimsManagementMicroservice.entity.ClaimsDetails;
import com.insurance.ClaimsManagementMicroservice.service.ClaimsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/claims")
public class ClaimsController
{
    @Autowired
    private ClaimsService claimsService;

    //creating the Claims
    @PostMapping
    public ResponseEntity<ClaimsDetails> createClaims(@RequestBody ClaimsDetails claimsDetails)
    {
        log.info("A Claims is being created and the flow is in createClaims of ClaimsController.");
        ClaimsDetails claimsDetails1 = claimsService.saveClaims(claimsDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(claimsDetails1);
    }

    //get or display single Claims details
    @GetMapping("/{claimsId}")
    public ResponseEntity<ClaimsDetails> getSingleClaims(@PathVariable String claimsId)
    {
        log.info("A Claims is being displayed with the given id and the flow is in getSingleClaims of ClaimsController.");
        ClaimsDetails claimsDetails = claimsService.getClaims(claimsId);
        return ResponseEntity.ok(claimsDetails);
    }

    //get or display all the Claims details at once
    @GetMapping
    public  ResponseEntity<List<ClaimsDetails>> getALlClaimsDetails()
    {
        log.info("A Claims is being displayed and the flow is in getALlClaimsDetails of ClaimsController.");
        List<ClaimsDetails> allClaims = claimsService.getAllClaims();
        return ResponseEntity.status(HttpStatus.FOUND).body(allClaims);
    }

    //update Claims details with the help of given id
    @PutMapping("/{claimsId}")
    public ResponseEntity<ClaimsDetails> updateClaims(@RequestBody ClaimsDetails claimsDetails,@PathVariable String claimsId)
    {
        log.info("A Claims is being updated and the flow is in updateClaims of ClaimsController.");
        ClaimsDetails claimsDetails1 = claimsService.updateClaims(claimsDetails,claimsId);
        return ResponseEntity.ok(claimsDetails1);
    }


    //delete Claims with given id
    @DeleteMapping("/{claimsId}")
    public  ResponseEntity<ClaimsDetails> deleteSingleClaims(@PathVariable String claimsId)
    {
        log.info("A Claims is being deleted with the given id and the flow is in deleteSingleClaims of ClaimsController.");
        ClaimsDetails claimsDetails = claimsService.deleteClaims(claimsId);
        return ResponseEntity.ok(claimsDetails);
    }

    //delete AllClaims
    @DeleteMapping
    public ResponseEntity<ClaimsDetails> deleteAllClaims()
    {
        log.info("All Claims are being created and the flow is in deleteAllClaims of ClaimsController.");
        ClaimsDetails claimsDetails = claimsService.deleteAllClaims();
        return ResponseEntity.ok(claimsDetails);
    }
}
