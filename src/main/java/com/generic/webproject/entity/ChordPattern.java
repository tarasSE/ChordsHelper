package com.generic.webproject.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "chord_variant")
public class ChordPattern extends GenericEntity {

    private int one;
    private int two;
    private int three;
    private int four;
    private int five;
    private int six;

}