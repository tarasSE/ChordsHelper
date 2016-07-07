package com.generic.webproject.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dozer.Mapping;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "chord_progresses")
@Component
public class ChordProgress extends GenericEntity {

    @Mapping("value")
    private ChordProgressEnum progress;

    @Mapping("lastSeen")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastSeen;

    @Fetch(FetchMode.JOIN)
    @OneToOne
    private Chord chord;

//    @ManyToOne
//    private User user;

    public static enum ChordProgressEnum {
        F, E, D, C, B, A
    }
}
