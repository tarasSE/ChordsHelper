package com.generic.webproject.service;

import com.generic.webproject.entity.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class GenericService<
        E extends GenericEntity,
        R extends JpaRepository<E, Integer>> {

    public abstract R getRepository();

    @Transactional
    public List<E> getAll() {
        return getRepository().findAll();
    }

    @Transactional
    public E create(E entity) {
        entity.setId(0);
        return getRepository().saveAndFlush(entity);
    }

    @Transactional
    public E update(E entity, Integer id) {
        entity.setId(id);
        return getRepository().saveAndFlush(entity);
    }

    @Transactional
    public void delete(Integer id) {
        getRepository().delete(id);
    }

    @Transactional
    public E getById(Integer id) {
        return getRepository().findOne(id);
    }
}
