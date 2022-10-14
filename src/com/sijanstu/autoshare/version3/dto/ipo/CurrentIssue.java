package com.sijanstu.autoshare.version3.dto.ipo;

import lombok.Data;

/**
 *
 * @author Sijan Bhandari
 */
@Data
public class CurrentIssue {
    public int companyShareId;
    public String subGroup;
    public String scrip;
    public String companyName;
    public String reservationTypeName;
    public String shareTypeName;
    public String shareGroupName;
    public String statusName;
    public String issueOpenDate;
    public String issueCloseDate;
}
