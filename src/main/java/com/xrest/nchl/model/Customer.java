package com.xrest.nchl.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



@Entity
@Data
public class Customer extends BaseModel<Long> implements UserDetails {

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

    private String username;
    private String password;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
