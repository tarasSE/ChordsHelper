package com.generic.webproject.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dozer.Mapping;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "chord_difficulties")
@Component
public class ChordDifficulty extends GenericEntity {

    @Mapping("difficulty")
    private ChordDifficultyEnum difficulty;

    @OneToOne
    private Chord chord;

//    @ManyToOne
//    private User user;

    public static enum ChordDifficultyEnum {
        VERY_EASY, EASY, NORMAL, HARD, VERY_HARD, NIGHTMARE
    }
}
