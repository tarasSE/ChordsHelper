package com.generic.webproject.controller;

import com.generic.webproject.data.CurrencyDTO;
import com.generic.webproject.entity.Currency;
import com.generic.webproject.service.CurrencyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

//TODO HATEOAS
@RestController
@RequestMapping(value = "/currency", headers = {"Accept=application/json"})
public class CurrencyController extends GenericCrudController<Currency, CurrencyDTO, CurrencyService>{

    @Inject
    private CurrencyService currencyService;

    @Override
    public CurrencyService getService() {
        return currencyService;
    }

    @Override
    public Class<CurrencyDTO> getDtoClass() {
        return CurrencyDTO.class;
    }

    @Override
    public Class<Currency> getEntityClass() {
        return Currency.class;
    }
}
