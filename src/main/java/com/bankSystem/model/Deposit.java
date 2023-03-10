package com.bankSystem.model;

import com.bankSystem.model.enums.Currency;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "deposit")
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "deposit_name")
    private String name;
    private double amount;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Column(name = "opening_date")
    private String openingDate;
    private int period;
    @Column(name = "deposit_annual_nominal_interest_rate")
    private double interestRate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @JsonBackReference
    @ToString.Exclude
    private Client client;
}
