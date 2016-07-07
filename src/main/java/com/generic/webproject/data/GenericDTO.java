package com.generic.webproject.data;

import com.generic.webproject.entity.GenericEntity;
import lombok.Data;

@Data
public abstract class GenericDTO<E extends GenericEntity> {
    private Integer id;
}
