package com.generic.webproject.service;

import com.generic.webproject.data.ChordProgressDTO;
import com.generic.webproject.entity.ChordProgress;
import com.generic.webproject.repository.ChordProgressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
@Transactional
public class ChordProgressService extends GenericService<ChordProgress, ChordProgressDTO, ChordProgressRepository>{

    @Inject
    private ChordProgressRepository progressRepository;


    @Override
    public ChordProgressRepository getRepository() {
        return progressRepository;
    }

    @Override
    public Class<ChordProgressDTO> getDtoClass() {
        return ChordProgressDTO.class;
    }

    @Override
    public Class<ChordProgress> getEntityClass() {
        return ChordProgress.class;
    }
}
