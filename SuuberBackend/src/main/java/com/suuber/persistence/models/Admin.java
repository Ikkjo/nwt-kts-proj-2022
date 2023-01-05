package com.suuber.persistence.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity(name = "Admin")
@Table(name = "admins")
public class Admin extends User{

    public Admin() {
        super();
    }
}
