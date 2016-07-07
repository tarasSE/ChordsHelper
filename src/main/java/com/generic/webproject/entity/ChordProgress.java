package com.generic.webproject.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dozer.Mapping;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "chord_progresses")
@Component
public class ChordProgress extends GenericEntity {

    @Mapping("value")
    private ChordProgressEnum progress;

    @Fetch(FetchMode.JOIN)
    @OneToOne
    private Chord chord;

//    @ManyToOne
//    private User user;

    public static enum ChordProgressEnum {
        A, B, C, D, E, F
    }
}
