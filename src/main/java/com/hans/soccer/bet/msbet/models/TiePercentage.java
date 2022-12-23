package com.hans.soccer.bet.msbet.models;

public class TiePercentage {

    private Double percentage;

    private Boolean apply;

    public TiePercentage(Double percentage) {
        this.percentage = percentage;
        this.apply = Boolean.FALSE;
    }

    public TiePercentage() {
        this.apply = Boolean.FALSE;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Boolean getApply() {
        return apply;
    }

    public void setApply(Boolean apply) {
        this.apply = apply;
    }
}
