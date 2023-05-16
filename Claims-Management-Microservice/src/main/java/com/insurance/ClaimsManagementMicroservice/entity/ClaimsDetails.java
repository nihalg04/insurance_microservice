package com.insurance.ClaimsManagementMicroservice.entity;

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
@Table(name = "Claims_Details")
public class ClaimsDetails
{
    @Id
    @Column(name = "claimsId")
    private String claimsId;
    @Column(name = "lossDate")
    private String lossDate;
    @Column(name = "lossDescription")
    private String lossDescription;
    @Column(name = "claimStatus")
    private String claimStatus;
    @Column(name = "amountSanctioned")
    private long amountSanctioned;
    @Column(name = "policeReport")
    private String policeReport;
    @Column(name = "hasEvidence")
    private String hasEvidence;
}
