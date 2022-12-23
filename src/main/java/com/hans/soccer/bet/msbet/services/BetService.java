package com.hans.soccer.bet.msbet.services;

import com.hans.soccer.bet.msbet.documents.Bet;

import java.util.List;
import java.util.Optional;

public interface BetService {

    Bet save(Bet entity);

    Optional<Bet> findById (String id);

    List<Bet> findAll();

}
