package com.hans.soccer.bet.msbet.dtos;

import com.hans.soccer.bet.msbet.models.TeamPercentage;
import com.hans.soccer.bet.msbet.models.TiePercentage;

public class UpdateBetDTO {

    private TeamPercentage betTeamA;
    private TeamPercentage betTeamB;
    private TiePercentage tiePercentage;

    public UpdateBetDTO() {
    }

    public UpdateBetDTO(TeamPercentage betTeamA, TeamPercentage betTeamB, TiePercentage tiePercentage) {
        this.betTeamA = betTeamA;
        this.betTeamB = betTeamB;
        this.tiePercentage = tiePercentage;
    }

    public TeamPercentage getBetTeamA() {
        return betTeamA;
    }

    public void setBetTeamA(TeamPercentage betTeamA) {
        this.betTeamA = betTeamA;
    }

    public TeamPercentage getBetTeamB() {
        return betTeamB;
    }

    public void setBetTeamB(TeamPercentage betTeamB) {
        this.betTeamB = betTeamB;
    }

    public TiePercentage getTiePercentage() {
        return tiePercentage;
    }

    public void setTiePercentage(TiePercentage tiePercentage) {
        this.tiePercentage = tiePercentage;
    }
}
