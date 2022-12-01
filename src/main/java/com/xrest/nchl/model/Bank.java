package com.xrest.nchl.model;

import com.xrest.nchl.dto.AccountDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Bank extends BaseModel<Long>{
    private String name;
    private String location;
    private String valuation;
    @Transient
    private List<AccountDto> accounts = new ArrayList<>();
}
