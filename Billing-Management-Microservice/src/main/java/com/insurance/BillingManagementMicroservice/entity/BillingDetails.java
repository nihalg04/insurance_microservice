package com.insurance.BillingManagementMicroservice.entity;

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
@Table(name = "Billing_Details")
public class BillingDetails
{
    @Id
    @Column(name = "BillingId")
    private String billingId;
    @Column(name = "referenceId")
    private String referenceId;
    @Column(name = "transactionId")
    private String transactionId;
    @Column(name = "amountPaid")
    private long amountPaid;
    @Column(name = "payoutDate")
    private String payoutDate;
    @Column(name = "paymentMethode")
    private String paymentMethode;
    @Column(name = "paymentStatus")
    private String paymentStatus;
    private String userId;
    private String claimsId;
}
