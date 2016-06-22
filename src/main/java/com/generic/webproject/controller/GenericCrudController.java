package com.generic.webproject.controller;

import com.generic.webproject.entity.GenericEntity;
import com.generic.webproject.service.GenericService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

public abstract class GenericCrudController<E extends GenericEntity, S extends GenericService<E, ?>> {

    public abstract S getService();

    @RequestMapping(method = GET)
    public List<E> getAll() {

        return getService().getAll();
    }

    @RequestMapping(value = "/{id}", method = GET)
    public E getById(@PathVariable Integer id) {
        return getService().getById(id);
    }

    @RequestMapping(method = POST)
    @ResponseBody
    public E create(@RequestBody E currency) {
        return getService().create(currency);
    }

    @RequestMapping(value = "/{id}", method = PUT)
    @ResponseBody
    public E update(@RequestBody E currency, @PathVariable Integer id) {
        return getService().update(currency, id);
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public void delete(@PathVariable Integer id) {
        getService().delete(id);
    }
}
