package com.generic.webproject.data;

import com.generic.webproject.entity.ChordVariant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@EqualsAndHashCode(callSuper = true)
@Data
@Component
public class ChordVariantDTO extends GenericDTO<ChordVariant> {

    private Integer id;

    private String variant;

}
