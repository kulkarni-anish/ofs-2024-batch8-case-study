package com.ofss.main.domain;

public class BankSlip {
    public BankSlip(int slipId, Cheque chequeNo, String slipDate, boolean approvalStatus, boolean completionStatus) {
        this.slipId = slipId;
        this.chequeNo = chequeNo;
        this.slipDate = slipDate;
        this.approvalStatus = approvalStatus;
        this.completionStatus = completionStatus;
    }
    private int slipId;
    private Cheque chequeNo;
    private String slipDate;
    private boolean approvalStatus;
    private boolean completionStatus;
    public int getSlipId() {
        return slipId;
    }
    public void setSlipId(int slipId) {
        this.slipId = slipId;
    }
    public Cheque getChequeNo() {
        return chequeNo;
    }
    public void setChequeNo(Cheque chequeNo) {
        this.chequeNo = chequeNo;
    }
    public String getSlipDate() {
        return slipDate;
    }
    public void setSlipDate(String slipDate) {
        this.slipDate = slipDate;
    }
    public boolean isApprovalStatus() {
        return approvalStatus;
    }
    public void setApprovalStatus(boolean approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
    public boolean isCompletionStatus() {
        return completionStatus;
    }
    public void setCompletionStatus(boolean completionStatus) {
        this.completionStatus = completionStatus;
    }
}
