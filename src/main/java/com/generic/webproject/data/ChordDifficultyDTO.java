package com.generic.webproject.data;

import com.generic.webproject.entity.ChordDifficulty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@EqualsAndHashCode(callSuper = true)
@Data
@Component
public class ChordDifficultyDTO extends GenericDTO<ChordDifficulty> {

//    private Integer id;

    private ChordDifficulty.ChordDifficultyEnum value;
}
