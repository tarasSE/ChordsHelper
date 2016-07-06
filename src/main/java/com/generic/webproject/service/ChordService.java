package com.generic.webproject.service;

import com.generic.webproject.data.ChordDTO;
import com.generic.webproject.entity.Chord;
import com.generic.webproject.repository.ChordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
@Transactional
public class ChordService extends GenericService<Chord,ChordDTO, ChordRepository>{

    @Inject
    private ChordRepository chordRepository;

    @Override
    public ChordRepository getRepository() {
        return chordRepository;
    }

    @Override
    public Class<ChordDTO> getDtoClass() {
        return ChordDTO.class;
    }

    @Override
    public Class<Chord> getEntityClass() {
        return Chord.class;
    }

}
