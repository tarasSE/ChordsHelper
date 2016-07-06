package com.generic.webproject.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dozer.Mapping;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "chords")
@Component
public class Chord extends GenericEntity {

    @Mapping("name")
    @NotEmpty
    @Size(min = 1, max = 10)
    private String name;

    private boolean isDefault;

    @Mapping("variants")
    @OneToMany(fetch = FetchType.EAGER)
    private List<ChordVariant> variants;
}
