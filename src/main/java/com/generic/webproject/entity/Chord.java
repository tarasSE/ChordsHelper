package com.generic.webproject.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "chords")
@Component
public class Chord extends GenericEntity {

    private Note baseNote;

    private boolean isDefault;

    @Fetch(FetchMode.JOIN)
    @OneToMany(fetch = FetchType.EAGER)
    private List<ChordPattern> patterns;

    public enum Note{
        C, Csh, D, Dsh, E, F, Fsh, G, Gsh, A, B, H
    }
}
