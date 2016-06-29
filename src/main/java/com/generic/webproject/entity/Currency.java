package com.generic.webproject.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dozer.Mapping;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "currencies")
@Component
public class Currency extends GenericEntity {

    @Mapping("currencyName")
    private String name;

    @Column(name = "short_name")
    private String shortName;

    private int code = 000;

    private char symbol = 's';
}
