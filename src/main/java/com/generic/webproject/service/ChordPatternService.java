package com.generic.webproject.service;

import com.generic.webproject.data.ChordPatternDTO;
import com.generic.webproject.entity.ChordPattern;
import com.generic.webproject.repository.ChordPatternRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
@Transactional
public class ChordPatternService extends GenericService<ChordPattern, ChordPatternDTO, ChordPatternRepository>{

    @Inject
    private ChordPatternRepository chordPatternRepository;

    @Override
    public ChordPatternRepository getRepository() {
        return chordPatternRepository;
    }

    @Override
    public Class<ChordPattern> getEntityClass() {
        return ChordPattern.class;
    }

    @Override
    public Class<ChordPatternDTO> getDtoClass() {
        return ChordPatternDTO.class;
    }
}
