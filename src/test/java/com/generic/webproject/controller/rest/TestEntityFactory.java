//package com.generic.webproject.controller.rest;
//
//import org.springframework.test.context.ContextConfiguration;
//
//import javax.inject.Inject;
//import java.util.Random;
//
//@ContextConfiguration(classes = {
//        InMemoryDataBaseConfig.class,
//        CurrencyService.class
//       })
//public class TestEntityFactory {
//
//    @Inject
//    private CurrencyService currencyService;
//
//    protected final static Random random = new Random();
//
//    public Currency getCurrency() {
//        Currency currency = new Currency();
//        currency.setName("" + (random.nextLong()));
//        currency.setShortName("" + (random.nextInt()));
//        currency.setSymbol('$');
//        currency.setCode(random.nextInt());
//        return currency;
//    }
//}
