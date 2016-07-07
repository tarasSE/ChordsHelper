package com.generic.webproject.data;

import com.generic.webproject.entity.ChordPattern;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@EqualsAndHashCode(callSuper = true)
@Data
@Component
public class ChordPatternDTO extends GenericDTO<ChordPattern> {

    private Integer id;

    private String variant;

}
