package com.bankSystem.model;

import com.bankSystem.model.enums.Sex;
import com.bankSystem.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank()
    private String name;
    @NotBlank
    private String surname;
    @Column(name = "patronymic_name")
    private String patronymicName;
    @NonNull
    @Column(name = "passport_number")
    private String passportNumber;
    @NonNull
    private String nationality;
    @NonNull
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @NonNull
    @Enumerated(value = EnumType.STRING)
    private Sex sex;
    @NonNull
    @Column(name = "date_of_issue")
    private String dateOfIssue;
    @NonNull
    @Column(name = "date_of_expiry")
    private String dateOfExpiry;
    @NonNull
    private int authority;
    @Column(name = "social_card")
    private long socialCard;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @ToString.Exclude
    private List<Address> address;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @ToString.Exclude
    private List<Account> accounts = new ArrayList<>();

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @ToString.Exclude
    private List<Deposit> deposit;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @ToString.Exclude
    private List<Loan> loan;

    @Email
    private String email;
    @Enumerated(EnumType.STRING)
    private Status status;
}