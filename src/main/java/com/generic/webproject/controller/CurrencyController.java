package com.generic.webproject.controller;

import com.generic.webproject.entity.Currency;
import com.generic.webproject.service.CurrencyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/currency", headers = {"Accept=application/json"})
public class CurrencyController extends GenericCrudController<Currency, CurrencyService>{

    @Inject
    private CurrencyService currencyService;

    @Override
    public CurrencyService getService() {
        return currencyService;
    }
}
