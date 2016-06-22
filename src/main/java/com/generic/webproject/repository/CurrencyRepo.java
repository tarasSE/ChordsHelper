package com.generic.webproject.repository;

import com.generic.webproject.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CurrencyRepo extends JpaRepository<Currency, Integer>{
}
