package com.bankSystem.model;

import com.bankSystem.model.enums.AccountName;
import com.bankSystem.model.enums.Currency;
import com.bankSystem.model.enums.StatusAccount;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "account_name")
    @Enumerated(value = EnumType.STRING)
    private AccountName accountName;
    @Enumerated(value = EnumType.STRING)
    private Currency currency;
    @Column(name = "account_number")
    private long accountNumber;
    private double balance;
    @Enumerated(value = EnumType.STRING)
    private StatusAccount status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;

    public void setBalance(double balance) {
        this.balance = Math.ceil(balance * 100) / 100;
    }
}
