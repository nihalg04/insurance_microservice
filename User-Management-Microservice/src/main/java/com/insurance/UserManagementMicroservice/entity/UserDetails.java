package com.insurance.UserManagementMicroservice.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Entity annotation will by default create a table in the database.
@Entity
@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "User_Details")
public class UserDetails
{
    @Id
    @Column(name = "UserId")
    private String userId;
    @Column(name = "UserName")
    private String name;
    @Column(name = "ContactNumber")
    private long phoneNumber;
    @Column(name = "EmailId")
    private String emailId;
    @Column(name = "Sex")
    private String sex;
    @Column(name = "Age")
    private long age;
}
