package com.hans.soccer.bet.msbet.apis;

import com.hans.soccer.bet.msbet.documents.Bet;
import com.hans.soccer.bet.msbet.enums.BetStatus;
import com.hans.soccer.bet.msbet.services.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bets")
public class BetResource {

    @Autowired
    private BetService betService;

    @GetMapping("/")
    ResponseEntity<?> findAll() {
        List<Bet> betList = betService.findAll();

        if (betList.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(betList);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> findById(@PathVariable String id) {
        Optional<Bet> optionalBet = betService.findById(id);

        if (optionalBet.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(optionalBet.get());
    }

    @PostMapping("/")
    ResponseEntity<?> save(@RequestBody Bet entity) {
        if (Optional.ofNullable(entity.getMatchId()).isEmpty()) {
            String err = "MatchId is a field mandatory";
            return ResponseEntity.badRequest()
                    .body(Collections.singletonMap("error", err));
        }

        entity.setBetStatus(BetStatus.OPEN);
        Bet bet = betService.save(entity);
        return ResponseEntity.created(URI.create("/" + bet.getId())).body(bet);
    }
}
