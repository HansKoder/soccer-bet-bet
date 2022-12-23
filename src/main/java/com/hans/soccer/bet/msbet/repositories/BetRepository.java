package com.hans.soccer.bet.msbet.repositories;

import com.hans.soccer.bet.msbet.documents.Bet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetRepository extends MongoRepository<Bet, String> {
}
