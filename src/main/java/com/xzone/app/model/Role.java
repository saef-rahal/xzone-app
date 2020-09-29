package com.xzone.app.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

/**
 * Created by Saef Rahal on 9/30/2020.
 */
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    private RoleName roleName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }
}
