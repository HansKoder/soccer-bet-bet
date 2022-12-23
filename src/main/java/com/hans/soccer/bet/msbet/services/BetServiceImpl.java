package com.hans.soccer.bet.msbet.services;

import com.hans.soccer.bet.msbet.documents.Bet;
import com.hans.soccer.bet.msbet.repositories.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BetServiceImpl implements BetService{

    @Autowired
    private BetRepository betRepository;

    @Override
    public Bet save(Bet entity) {
        return betRepository.save(entity);
    }

    @Override
    public Optional<Bet> findById(String id) {
        return betRepository.findById(id);
    }

    @Override
    public List<Bet> findAll() {
        return betRepository.findAll();
    }
}
