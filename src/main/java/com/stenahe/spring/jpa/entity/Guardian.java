package com.stenahe.spring.jpa.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Guardian {
    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;

}
