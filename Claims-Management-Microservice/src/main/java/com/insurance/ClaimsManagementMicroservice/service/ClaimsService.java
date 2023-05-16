package com.insurance.ClaimsManagementMicroservice.service;

import com.insurance.ClaimsManagementMicroservice.entity.ClaimsDetails;

import java.util.List;

public interface ClaimsService
{
    //create or generate a Claims profile.
    ClaimsDetails saveClaims(ClaimsDetails claimsDetails);

    //get all Claims details at once
    List<ClaimsDetails> getAllClaims();

    //get single Claims of the given data or id
    ClaimsDetails getClaims(String claimsId);

    //update Claims details with the given id

    ClaimsDetails updateClaims(ClaimsDetails claimsDetails, String claimsId);

    //delete Claims with the given id
    ClaimsDetails deleteClaims(String claimsId);

    ClaimsDetails deleteAllClaims();
}
