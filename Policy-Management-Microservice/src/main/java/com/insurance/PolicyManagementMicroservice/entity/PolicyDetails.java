package com.insurance.PolicyManagementMicroservice.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Policy_Details")
public class PolicyDetails
{
    @Id
    @Column(name = "PolicyId")
    private String policyId;
    @Column(name = "PolicyName")
    private String policyName;
    @Column(name = "PolicyType")
    private String policyType;
    @Column(name = "PolicyOwner")
    private String policyOwner;
    @Column(name = "PolicyDescription")
    private String policyDescription;
    @Column(name = "PolicyStatus")
    private String policyStatus;
    @Column(name = "PolicyCoverageTime")
    private String policyCoverageTime;
    @Column(name = "PremiumAmount")
    private String premiumAmount;
    @Column(name = "PolicyCoverageAmount")
    private String policyCoverageAmount;
    private String userId;
}
