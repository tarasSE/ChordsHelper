package com.generic.webproject.service;

import com.generic.webproject.data.ChordDTO;
import com.generic.webproject.data.ChordDifficultyDTO;
import com.generic.webproject.data.ChordProgressDTO;
import com.generic.webproject.entity.*;
import com.generic.webproject.repository.ChordDifficultyRepository;
import com.generic.webproject.repository.ChordProgressRepository;
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
    private ChordDifficultyRepository difficultyRepository;
    @Inject
    private ChordProgressRepository progressRepository;

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
                        difficultyRepository.findByChordId(id),
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

        if (entity.getDifficulty() != null){
            chord.setDifficulty(entity.getDifficulty());
            chord = setDifficultyToChord(chord);
        }

        if (entity.getProgress() != null){
            chord.setProgress(entity.getProgress());
            chord = setProgressToChord(chord);
        }

        return chord;
    }

    @Override
    public ChordDTO update(final ChordDTO entity, final Integer id) {
        ChordDTO chord = super.update(entity, id);

        if (entity.getDifficulty() != null){
            chord.setDifficulty(entity.getDifficulty());
            chord = setDifficultyToChord(chord);
        }

        if (entity.getProgress() != null){
            chord.setProgress(entity.getProgress());
            chord = setProgressToChord(chord);
        }

        return chord;
    }

    private ChordDTO setDifficultyToChord(final ChordDTO chord){
        ChordDifficulty difficulty = difficultyRepository.saveAndFlush(
                ChordDifficultyFactory.getInstance(
                        chord.getDifficulty().getValue(),
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
    }

    private ChordDTO setProgressToChord(final ChordDTO chord){
        ChordProgress progress = progressRepository.saveAndFlush(
                ChordProgressFactory.getInstance(
                        chord.getProgress().getValue(),
                        chordRepository.getOne(
                                chord.getId()
                        ))
        );

        chord.setProgress(
                mapper.map(
                        progress,
                        ChordProgressDTO.class)
        );

        return chord;
    }
}
