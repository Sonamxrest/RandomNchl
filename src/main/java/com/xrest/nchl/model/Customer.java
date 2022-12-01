package com.xrest.nchl.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;



@Entity
@Data
public class Customer extends BaseModel<Long> {

    @JsonProperty("first_name")
    @NotBlank(message = "Cannot Be Blank")
    @NotNull(message = "Cannot Be Null")
    private String firstName;

    @JsonProperty("last_name")
    @NotBlank(message = "Cannot Be Blank")
    @NotNull(message = "Cannot Be Null")
    private String lastName;


    private Double balance;

    private String profile;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Account> accounts;

    @OneToOne(cascade = CascadeType.ALL)
    private Certificates certificates;

    @Transient
    private Double totalBalance = 0d;

    public Double getTotalBalance() {
        Double b = this.accounts.stream().mapToDouble(d ->  Double.parseDouble(d.getBalance())).sum();
        setBalance(b);
        return b;
    }
}
