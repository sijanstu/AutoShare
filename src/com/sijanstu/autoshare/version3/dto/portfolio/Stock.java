package com.sijanstu.autoshare.version3.dto.portfolio;

import lombok.Data;

import java.io.Serializable;

@Data
public class Stock implements Serializable {
    private Integer currentBalance;
    private String lastTransactionPrice;
    private String previousClosingPrice;
    private String script;
    private String scriptDesc;
    private String valueAsOfLastTransactionPrice;
    private String valueAsOfPreviousClosingPrice;
    private String valueOfLastTransPrice;
    private String valueOfPrevClosingPrice;
}
