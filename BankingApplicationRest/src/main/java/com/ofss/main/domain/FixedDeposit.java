package com.ofss.main.domain;

public class FixedDeposit {
    private int fdId;
    private int validityMonths;
    private float rate;
    public FixedDeposit(int fdId, int validityMonths, float rate) {
        this.fdId = fdId;
        this.validityMonths = validityMonths;
        this.rate = rate;
    }
    public int getFdId() {
        return fdId;
    }
    public void setFdId(int fdId) {
        this.fdId = fdId;
    }
    public int getValidityMonths() {
        return validityMonths;
    }
    public void setValidityMonths(int validityMonths) {
        this.validityMonths = validityMonths;
    }
    public float getRate() {
        return rate;
    }
    public void setRate(float rate) {
        this.rate = rate;
    }
}
