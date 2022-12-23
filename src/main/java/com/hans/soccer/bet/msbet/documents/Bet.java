package com.hans.soccer.bet.msbet.documents;

import com.hans.soccer.bet.msbet.enums.BetStatus;
import com.hans.soccer.bet.msbet.models.TeamPercentage;
import com.hans.soccer.bet.msbet.models.TiePercentage;
import org.springframework.data.annotation.Id;

public class Bet {

    @Id
    private String id;

    private String matchId;

    private TeamPercentage betTeamA;
    private TeamPercentage betTeamB;

    private TiePercentage tiePercentage;

    private BetStatus betStatus;

    public Bet(String matchId, TeamPercentage betTeamA, TeamPercentage betTeamB, TiePercentage tiePercentage, BetStatus betStatus) {
        this.matchId = matchId;
        this.betTeamA = betTeamA;
        this.betTeamB = betTeamB;
        this.tiePercentage = tiePercentage;
        this.betStatus = betStatus;
    }

    public Bet() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
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

    public BetStatus getBetStatus() {
        return betStatus;
    }

    public void setBetStatus(BetStatus betStatus) {
        this.betStatus = betStatus;
    }
}
