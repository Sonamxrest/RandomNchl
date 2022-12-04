package com.xrest.nchl.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Certificates extends BaseModel<Long> {
    private String citizenshipNo;
    private String gender;
    private String nationality;
}
