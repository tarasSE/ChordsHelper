package com.generic.webproject.data;

import com.generic.webproject.entity.ChordProgress;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@EqualsAndHashCode(callSuper = true)
@Data
@Component
public class ChordProgressDTO extends GenericDTO<ChordProgress> {

//    private Integer id;

    private ChordProgress.ChordProgressEnum value;
}
