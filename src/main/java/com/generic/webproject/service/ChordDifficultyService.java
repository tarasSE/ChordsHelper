package com.generic.webproject.service;

import com.generic.webproject.data.ChordDifficultyDTO;
import com.generic.webproject.entity.ChordDifficulty;
import com.generic.webproject.repository.ChordDifficultyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
@Transactional
public class ChordDifficultyService extends GenericService<ChordDifficulty, ChordDifficultyDTO, ChordDifficultyRepository>{

    @Inject
    private ChordDifficultyRepository chordDifficultyRepository;

    @Override
    public ChordDifficultyRepository getRepository() {
        return chordDifficultyRepository;
    }

    @Override
    public Class<ChordDifficultyDTO> getDtoClass() {
        return ChordDifficultyDTO.class;
    }

    @Override
    public Class<ChordDifficulty> getEntityClass() {
        return ChordDifficulty.class;
    }

}
