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

    public abstract Class<ED> getDtoClass();

    public abstract Class<E> getEntityClass();


    @Transactional
    public List<ED> getAll() {
        List<E> list = getRepository().findAll();
        list.sort((o1, o2) -> o1.getId() - o2.getId());

        return list.parallelStream()
                .map(x -> mapper.map(x, getDtoClass()))
                .collect(Collectors.toList());
    }

    @Transactional
    public ED create(ED entity) {
        E e = mapper.map(entity, getEntityClass());
        e.setId(0);
        E result = getRepository().saveAndFlush(e);
        return mapper.map(result, getDtoClass());
    }

    @Transactional
    public ED update(ED entity, Integer id) {
        E e = mapper.map(entity, getEntityClass());
        e.setId(id);
        E result = getRepository().saveAndFlush(e);
        return mapper.map(result, getDtoClass());
    }

    @Transactional
    public void delete(Integer id) {
        getRepository().delete(id);
    }

    @Transactional
    public ED getById(Integer id) {
        return mapper.map(getRepository().findOne(id), getDtoClass());
    }
}
