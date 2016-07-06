package com.generic.webproject.service;

import com.generic.webproject.data.ChordVariantDTO;
import com.generic.webproject.entity.ChordVariant;
import com.generic.webproject.repository.ChordVariantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
@Transactional
public class ChordVariantService extends GenericService<ChordVariant, ChordVariantDTO, ChordVariantRepository>{

    @Inject
    private ChordVariantRepository chordVariantRepository;

    @Override
    public ChordVariantRepository getRepository() {
        return chordVariantRepository;
    }

    @Override
    public Class<ChordVariantDTO> getDtoClass() {
        return ChordVariantDTO.class;
    }

    @Override
    public Class<ChordVariant> getEntityClass() {
        return ChordVariant.class;
    }

}
