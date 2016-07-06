package com.generic.webproject.controller;

import com.generic.webproject.data.GenericDTO;
import com.generic.webproject.entity.GenericEntity;
import com.generic.webproject.service.GenericService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

public abstract class GenericCrudController<
        E extends GenericEntity,
        ED extends GenericDTO<E>,
        S extends GenericService<E, ED, ?>> {

    public abstract S getService();

    @RequestMapping(method = GET)
    public List<ED> getAll() {
        return getService().getAll();
    }

    @RequestMapping(value = "/{id}", method = GET)
    public ED getById(@PathVariable Integer id) {
        return getService().getById(id);
    }

    @RequestMapping(method = POST)
    @ResponseBody
    public ED create(@RequestBody ED entity) throws IllegalAccessException, InstantiationException {
        return getService().create(entity);
    }

    @RequestMapping(value = "/{id}", method = PUT)
    @ResponseBody
    public ED update(@RequestBody ED entity, @PathVariable Integer id) throws IllegalAccessException, InstantiationException {
       return getService().update(entity, id);
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public void delete(@PathVariable Integer id) {
        getService().delete(id);
    }
}
