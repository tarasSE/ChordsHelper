package com.generic.webproject.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "currencies")
public class Currency extends GenericEntity {

    private String name;

    @Column(name = "short_name")
    private String shortName;

    private int code;

    private char symbol;
}
