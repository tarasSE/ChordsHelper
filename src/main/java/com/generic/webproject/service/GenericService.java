package com.generic.webproject.service;

import com.generic.webproject.data.GenericDTO;
import com.generic.webproject.entity.GenericEntity;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public abstract class GenericService<
        E extends GenericEntity,
        ED extends GenericDTO<E>,
        R extends JpaRepository<E, Integer>> {

    @Autowired
    protected Mapper mapper;

    public abstract R getRepository();
    public abstract Class<E> getEntityClass();
    public abstract Class<ED> getDtoClass();

    @Transactional
    public List<ED> getAll() {
        return getRepository().findAll()
                .parallelStream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public ED create(ED dto) {
        dto.setId(0);
        return toDto(getRepository().saveAndFlush(toEntity(dto)));
    }

    @Transactional
    public ED update(ED dto, Integer id) {
        dto.setId(id);
        return toDto(getRepository().saveAndFlush(toEntity(dto)));
    }

    @Transactional
    public void delete(Integer id) {
        getRepository().delete(id);
    }

    @Transactional
    public ED getById(Integer id) {
        return toDto(getRepository().findOne(id));
    }

    public ED toDto(E entity) {
        return mapper.map(entity, getDtoClass());
    }

    public E toEntity(ED dto) {
        return mapper.map(dto, getEntityClass());
    }
}
