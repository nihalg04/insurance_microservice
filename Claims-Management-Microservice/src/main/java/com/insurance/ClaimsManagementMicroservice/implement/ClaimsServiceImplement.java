package com.insurance.ClaimsManagementMicroservice.implement;

import com.insurance.ClaimsManagementMicroservice.entity.ClaimsDetails;
import com.insurance.ClaimsManagementMicroservice.exception.ResourceNotFoundException;
import com.insurance.ClaimsManagementMicroservice.repository.ClaimsRepository;
import com.insurance.ClaimsManagementMicroservice.service.ClaimsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class ClaimsServiceImplement implements ClaimsService
{
    @Autowired
    private ClaimsRepository claimsRepository;

    @Override
    public ClaimsDetails saveClaims(ClaimsDetails claimsDetails)
    {
        log.info("A claims is being created and the flow is in saveClaims of claimsServiceImplement");

        String randomClaimsId = UUID.randomUUID().toString();
        claimsDetails.setClaimsId(randomClaimsId);

        return claimsRepository.save(claimsDetails);
    }

    @Override
    public List<ClaimsDetails> getAllClaims()
    {
        log.info("All claims is being displayed and the flow is in getAllClaims of claimsServiceImplement");
        return claimsRepository.findAll();
    }

    @Override
    public ClaimsDetails getClaims(String claimsId)
    {
        log.info("A claims is being displayed with the given Id and the flow is in getClaims of claimsServiceImplement");
        return claimsRepository.findById(claimsId).orElseThrow(() -> new ResourceNotFoundException("claims with given Id has not found in the server/Database !!..."+ claimsId));
    }

    @Override
    public ClaimsDetails updateClaims(ClaimsDetails claimsDetails, String claimsId)
    {
        log.info("A claims is being updated and the flow is in updateClaims of claimsServiceImplement");

        ClaimsDetails getClaims = claimsRepository.findById(claimsId).orElseThrow(() -> new ResourceNotFoundException("claims with given Id has not found in the server/Database !!..."+ claimsId));

        getClaims.setLossDate(claimsDetails.getLossDate());
        getClaims.setLossDescription(claimsDetails.getLossDescription());
        getClaims.setClaimStatus(claimsDetails.getClaimStatus());
        getClaims.setAmountSanctioned(claimsDetails.getAmountSanctioned());
        getClaims.setPoliceReport(claimsDetails.getPoliceReport());
        getClaims.setHasEvidence(claimsDetails.getHasEvidence());

        return claimsRepository.save(getClaims);
    }

    @Override
    public ClaimsDetails deleteClaims(String claimsId)
    {
        log.info("A claims is being deleted and the flow is in deleteClaims of claimsServiceImplement");
        claimsRepository.deleteById(claimsId);
        return null;
    }

    @Override
    public ClaimsDetails deleteAllClaims()
    {
        log.info("All claims are being deleted and the flow is in deleteAllclaims of claimsServiceImplement");
        claimsRepository.deleteAll();
        return null;
    }
}
