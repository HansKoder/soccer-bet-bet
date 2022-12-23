package com.hans.soccer.bet.msbet.models;

public class TeamPercentage {

    private Long id;
    private String team;
    private Double percentage;

    private Boolean apply;

    public TeamPercentage(Long id, String team, Double percentage) {
        this.id = id;
        this.team = team;
        this.percentage = percentage;
        this.apply = Boolean.FALSE;
    }

    public TeamPercentage() {
        this.apply = Boolean.FALSE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
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
