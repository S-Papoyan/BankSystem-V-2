package com.bankSystem.model.requestDTO;

import com.bankSystem.model.enums.Sex;
import lombok.Data;

@Data
public class ClientDTO {

    private String name;
    private String surname;
    private String patronymicName;
    private String passportNumber;
    private String nationality;
    private String dateOfBirth;
    private Sex sex;
    private String dateOfIssue;
    private String dateOfExpiry;
    private Integer authority;
    private String socialCard;
    private String email;
}
