package com.bankSystem.model.responseDTO;

import com.bankSystem.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Getter
@Setter
@JsonInclude
@JsonPropertyOrder({
        "id",
        "name",
        "surname",
        "year",
        "email",
        "password",
        "verify",
        "status",
        "resetToken",
})
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AccountResponseDTO {

    @JsonIgnore
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("year")
    private int year;
    @JsonProperty("email")
    private String email;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String verify;
    @JsonIgnore
    private Status status;
    @JsonIgnore
    private String resetToken;
}
