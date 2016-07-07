package com.generic.webproject.service;

import com.generic.webproject.data.ChordDTO;
import com.generic.webproject.data.ChordPatternDTO;
import com.generic.webproject.entity.Chord;
import com.generic.webproject.repository.ChordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ChordService extends GenericService<Chord, ChordDTO, ChordRepository> {

    @Inject
    private ChordRepository chordRepository;
    @Inject
    private ChordPatternService patternService;

    @Override
    public ChordDTO toDto(Chord entity) {
        List<ChordPatternDTO> patternDTOs = Collections.EMPTY_LIST;

        if (entity.getPatterns() != null){
            entity.getPatterns()
                    .parallelStream()
                    .map(patternService::toDto)
                    .collect(Collectors.toList());
        }

        ChordDTO result = super.toDto(entity);
        result.setPatterns(patternDTOs);
        return result;
    }

    @Override
    public ChordRepository getRepository() {
        return chordRepository;
    }

    @Override
    public Class<Chord> getEntityClass() {
        return Chord.class;
    }

    @Override
    public Class<ChordDTO> getDtoClass() {
        return ChordDTO.class;
    }


    //    public ChordDTO repeat() {
//
//        PriorityQueue<ChordDTO> progresses =
//                new PriorityQueue<ChordDTO>(10, (x, y) ->
//                        x.getProgress().getValue()
//                                .compareTo(y.getProgress().getValue()));
//
//        progresses.addAll(getAll()
//                .parallelStream()
//                .sorted((x, y) ->
//                        x.getProgress().getLastSeen()
//                                .compareTo(y.getProgress().getLastSeen()))
//                .collect(Collectors.toList()));
//
//        ChordDTO chordDTO = progresses.poll();
//
//        refreshLastSeen(chordDTO);
//
//        return chordDTO;
//    }
//
//    private void refreshLastSeen(ChordDTO chordDTO) {
//        ChordProgressDTO progressDTO = progressService.getById(chordDTO.getId());
//        progressService.update(progressDTO, progressDTO.getId());
//    }
//
//    private ChordDTO assembleChordDTO(ChordDTO chord) {
//        ChordProgressDTO progressDTO = progressService.getByChordId(chord.getId());
//        if (progressDTO != null) {
//            chord.setProgress(progressDTO);
//        }
//
//        ChordDifficultyDTO difficultyDTO = difficultyService.getByChordId(chord.getId());
//        if (difficultyDTO != null) {
//            chord.setDifficulty(difficultyDTO);
//        }
//
//        return chord;
//    }

}
