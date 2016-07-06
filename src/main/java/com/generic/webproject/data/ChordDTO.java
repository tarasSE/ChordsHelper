package com.generic.webproject.data;

import com.generic.webproject.entity.Chord;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Component
public class ChordDTO extends GenericDTO<Chord> {

    private Integer id;

    private String name;

    private List variants;

}
