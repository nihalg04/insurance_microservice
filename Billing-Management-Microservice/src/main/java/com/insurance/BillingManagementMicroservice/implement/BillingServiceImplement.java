package com.insurance.BillingManagementMicroservice.implement;

import com.insurance.BillingManagementMicroservice.entity.BillingDetails;
import com.insurance.BillingManagementMicroservice.exception.ResourceNotFoundException;
import com.insurance.BillingManagementMicroservice.repository.BillingRepository;
import com.insurance.BillingManagementMicroservice.service.BillingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class BillingServiceImplement implements BillingService
{
    @Autowired
    private BillingRepository billingRepository;

    @Override
    public BillingDetails saveBilling(BillingDetails billingDetails) {
        log.info("A Billing is being created and the flow is in saveBilling of BillingServiceImplement");

        String randomBillingId = UUID.randomUUID().toString();
        String randomReferenceId = UUID.randomUUID().toString();
        String randomTransactionId = UUID.randomUUID().toString();

        billingDetails.setBillingId(randomBillingId);
        billingDetails.setReferenceId(randomReferenceId);
        billingDetails.setTransactionId(randomTransactionId);

        return billingRepository.save(billingDetails);
    }

    @Override
    public List<BillingDetails> getAllBillings() {
        log.info("All billing is being displayed and the flow is in getAllBilling of billingServiceImplement");
        return billingRepository.findAll();
    }

    @Override
    public BillingDetails getBilling(String billingId) {
        log.info("A billing is being displayed with the given Id and the flow is in getBilling of billingServiceImplement");
        return billingRepository.findById(billingId).orElseThrow(() -> new ResourceNotFoundException("billing with given Id has not found in the server/Database !!..."+ billingId));
    }

    @Override
    public BillingDetails updateBilling(BillingDetails billingDetails, String billingId) {
        log.info("A billing is being updated and the flow is in updateBilling of billingServiceImplement");

        BillingDetails getBilling = billingRepository.findById(billingId).orElseThrow(() -> new ResourceNotFoundException("billing with given Id has not found in the server/Database !!..."+ billingId));

        getBilling.setAmountPaid(billingDetails.getAmountPaid());
        getBilling.setPayoutDate(billingDetails.getPayoutDate());
        getBilling.setPaymentMethode(billingDetails.getPaymentMethode());
        getBilling.setPaymentStatus(billingDetails.getPaymentStatus());

        return billingRepository.save(getBilling);
    }

    @Override
    public BillingDetails deleteBilling(String billingId) {
        log.info("A billing is being deleted and the flow is in deleteBilling of billingServiceImplement");
        billingRepository.deleteById(billingId);
        return null;
    }

    @Override
    public BillingDetails deleteAllBillings() {
        log.info("All billings are being deleted and the flow is in deleteAllBillings of billingServiceImplement");
        billingRepository.deleteAll();
        return null;
    }
}
