package com.generic.webproject.controller;

import com.generic.webproject.data.GenericDTO;
import com.generic.webproject.entity.GenericEntity;
import com.generic.webproject.service.GenericService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.*;

public abstract class GenericCrudController<
        E extends GenericEntity,
        ED extends GenericDTO<E>,
        S extends GenericService<E, ?>> {

    @Autowired
    protected Mapper mapper;

    public abstract S getService();

    public abstract Class<ED> getDtoClass();

    public abstract Class<E> getEntityClass();


    @RequestMapping(method = GET)
    public List<GenericDTO> getAll() {
        List<E> currencies = getService().getAll();
        currencies
                .sort((o1, o2) -> o1.getId() - o2.getId());

        return currencies
                .parallelStream()
                .map(x -> mapper.map(x, getDtoClass()))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/{id}", method = GET)
    public ED getById(@PathVariable Integer id) {
        return mapper.map(getService().getById(id), getDtoClass());
    }

    @RequestMapping(method = POST)
    @ResponseBody
    public ED create(@RequestBody ED entity) throws IllegalAccessException, InstantiationException {
        E e = getService().create(mapper.map(entity, getEntityClass()));
        return mapper.map(e, getDtoClass());
    }

    @RequestMapping(value = "/{id}", method = PUT)
    @ResponseBody
    public ED update(@RequestBody ED entity, @PathVariable Integer id) throws IllegalAccessException, InstantiationException {
        E e = getService().update(mapper.map(entity, getEntityClass()), id);
        return mapper.map(e, getDtoClass());
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public void delete(@PathVariable Integer id) {
        getService().delete(id);
    }
}
