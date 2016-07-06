package com.generic.webproject.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "chord_variants")
@Component
public class ChordVariant extends GenericEntity{
    private String variant;
}
