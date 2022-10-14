package com.sijanstu.autoshare.version3.dto;

import java.util.ArrayList;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author Sijan Bhandari
 */
@Data
public class Transactions {

    private int totalItems;
    private ArrayList<TransactionView> transactionView;
}

class TransactionView {

    public int balAfterTrans;
    public String creditQty;
    public String debitQty;
    public String historyDesc;
    public String script;
    public String scriptDesc;
    public int tranactionQty;
    public String transCode;
    public Date transactionDate;
}
