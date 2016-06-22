package com.generic.webproject.service;

import com.generic.webproject.entity.Currency;
import com.generic.webproject.repository.CurrencyRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
@Transactional
public class CurrencyService extends GenericService<Currency, CurrencyRepo>{

    @Inject
    private CurrencyRepo currencyRepo;

    @Override
    public CurrencyRepo getRepository() {
        return currencyRepo;
    }
}
