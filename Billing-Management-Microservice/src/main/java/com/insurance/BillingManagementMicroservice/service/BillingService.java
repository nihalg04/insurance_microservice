package com.insurance.BillingManagementMicroservice.service;

import com.insurance.BillingManagementMicroservice.entity.BillingDetails;

import java.util.List;

public interface BillingService
{
    //create or generate a Billing profile.
    BillingDetails saveBilling(BillingDetails BillingDetails);

    //get all Billing details at once
    List<BillingDetails> getAllBillings();

    //get single Billing of the given data or id
    BillingDetails getBilling(String BillingId);

    //update Billing details with the given id

    BillingDetails updateBilling(BillingDetails BillingDetails, String BillingId);

    //delete Billing with the given Id
    BillingDetails deleteBilling(String BillingId);

    BillingDetails deleteAllBillings();
}
