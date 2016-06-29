package com.generic.webproject.data;

import com.generic.webproject.entity.Currency;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@EqualsAndHashCode(callSuper = true)
@Data
@Component
public class CurrencyDTO extends GenericDTO<Currency> {

    private Integer id;

    private String currencyName;

    private String shortName;

    private int code;

    private char symbol;

}
