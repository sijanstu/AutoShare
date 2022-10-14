package com.sijanstu.autoshare.version3.dto.portfolio;

import lombok.Data;

@Data
public class Portfolio {
    private Integer totalItems;
    private String totalValueAsOfLastTransactionPrice;
    private String totalValueAsOfPreviousClosingPrice;
    private String totalValueOfLastTransPrice;
    private String totalValueOfPrevClosingPrice;
    private Stock[] meroShareMyPortfolio;
}
