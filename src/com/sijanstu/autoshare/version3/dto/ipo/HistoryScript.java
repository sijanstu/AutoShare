package com.sijanstu.autoshare.version3.dto.ipo;

import lombok.Data;

import java.util.Date;
@Data
public class HistoryScript {
    public String accountNumber;
    public String action;
    public int amount;
    public int applicantFormId;
    public Date appliedDate;
    public int appliedKitta;
    public String clientName;
    public Date maxIssueCloseDate;
    public int meroShareId;
    public String meroshareRemark;
    public String reasonOrRemark;
    public int receivedKitta;
    public String registeredBranchName;
    public String remarks;
    public String stageName;
    public String statusDescription;
    public String statusName;
    public String suspectStatusName;
}
