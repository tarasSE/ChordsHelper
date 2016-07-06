package com.generic.webproject.service;

import com.generic.webproject.data.ChordDTO;
import com.generic.webproject.data.ChordDifficultyDTO;
import com.generic.webproject.entity.Chord;
import com.generic.webproject.entity.ChordDifficulty;
import com.generic.webproject.entity.ChordDifficultyFactory;
import com.generic.webproject.repository.ChordDifficultyRepository;
import com.generic.webproject.repository.ChordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
@Transactional
public class ChordService extends GenericService<Chord, ChordDTO, ChordRepository> {

    @Inject
    private ChordRepository chordRepository;
    @Inject
    private ChordDifficultyRepository chordDifficultyRepository;

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

    @Override
    public ChordDTO getById(final Integer id) {
        ChordDTO chord = super.getById(id);
        chord.setDifficulty(
                mapper.map(
                        chordDifficultyRepository.findByChordId(id),
                        ChordDifficultyDTO.class)
        );
        return chord;
    }

    @Override
    public List<ChordDTO> getAll() {
        return super.getAll();
    }

    @Override
    public ChordDTO create(final ChordDTO entity) {
        ChordDTO chord = super.create(entity);
        if (entity.getDifficulty() == null) {
            return chord;
        }
        chord.setDifficulty(entity.getDifficulty());
        return setDifficultyToChord(chord);
    }

    @Override
    public ChordDTO update(final ChordDTO entity, final Integer id) {
        ChordDTO chord = super.update(entity, id);
        if (entity.getDifficulty() == null){
            return chord;
        }
        chord.setDifficulty(entity.getDifficulty());
        return setDifficultyToChord(chord);
    }

    private ChordDTO setDifficultyToChord(final ChordDTO chord){
        ChordDifficulty difficulty = chordDifficultyRepository.saveAndFlush(
                ChordDifficultyFactory.getInstance(
                        chord.getDifficulty().getDifficulty(),
                        chordRepository.getOne(
                                chord.getId()
                        ))
        );

        chord.setDifficulty(
                mapper.map(
                        difficulty,
                        ChordDifficultyDTO.class)
        );

        return chord;
    }}
