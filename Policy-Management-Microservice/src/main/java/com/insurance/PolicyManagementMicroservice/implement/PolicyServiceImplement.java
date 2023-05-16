package com.insurance.PolicyManagementMicroservice.implement;

import com.insurance.PolicyManagementMicroservice.entity.PolicyDetails;
import com.insurance.PolicyManagementMicroservice.exception.ResourceNotFoundException;
import com.insurance.PolicyManagementMicroservice.repository.PolicyRepository;
import com.insurance.PolicyManagementMicroservice.service.PolicyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class PolicyServiceImplement implements PolicyService
{
    @Autowired
    private PolicyRepository policyRepository;

    @Override
    public PolicyDetails savePolicy(PolicyDetails policyDetails)
    {
        log.info("A Policy is being created and the flow is in savePolicy of PolicyServiceImplement");

        String randomUserId = UUID.randomUUID().toString();
        policyDetails.setPolicyId(randomUserId);

        return policyRepository.save(policyDetails);
    }

    @Override
    public List<PolicyDetails> getAllPolicies()
    {
        log.info("All Policies are being displayed and the flow is in getAllPolicies of PolicyServiceImplement");
        return policyRepository.findAll();
    }

    @Override
    public PolicyDetails getPolicy(String policyId)
    {
        log.info("A Policy is being displayed with the given id and the flow is in getPolicy of PolicyServiceImplement");
        return policyRepository.findById(policyId).orElseThrow(() -> new ResourceNotFoundException("Policy with given Id has not found in the server/Database !!..."+ policyId));
    }

    @Override
    public PolicyDetails updatePolicy(PolicyDetails policyDetails, String policyId)
    {
        log.info("A Policy is being Updates and the flow is in updatePolicy of PolicyServiceImplement");

        PolicyDetails getPolicy = policyRepository.findById(policyId).orElseThrow(() -> new ResourceNotFoundException("Policy with given Id has not found in the server/Database !!..."+ policyId));

        getPolicy.setPolicyName(policyDetails.getPolicyName());
        getPolicy.setPolicyType(policyDetails.getPolicyType());
        getPolicy.setPolicyOwner(policyDetails.getPolicyOwner());
        getPolicy.setPolicyDescription(policyDetails.getPolicyDescription());
        getPolicy.setPolicyStatus(policyDetails.getPolicyStatus());
        getPolicy.setPolicyCoverageTime(policyDetails.getPolicyCoverageTime());
        getPolicy.setPremiumAmount(policyDetails.getPremiumAmount());
        getPolicy.setPolicyCoverageTime(policyDetails.getPolicyCoverageTime());

        return policyRepository.save(getPolicy);
    }

    @Override
    public PolicyDetails deletePolicy(String policyId)
    {
        log.info("A Policy is being deleted with the given id and the flow is in deletePolicy of PolicyServiceImplement");
        policyRepository.deleteById(policyId);
        return null;
    }

    @Override
    public PolicyDetails deleteAllPolicies()
    {
        log.info("All Policies are being deleted and the flow is in deleteAllPolicies of PolicyServiceImplement");
        policyRepository.deleteAll();
        return null;
    }
}
