package com.hans.soccer.bet.msbet.apis;

import com.hans.soccer.bet.msbet.documents.Bet;
import com.hans.soccer.bet.msbet.dtos.UpdateBetDTO;
import com.hans.soccer.bet.msbet.enums.BetStatus;
import com.hans.soccer.bet.msbet.services.BetService;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PutMapping("/update-bet/{betId}")
    ResponseEntity<?> updateBet (@RequestBody UpdateBetDTO updateBetDTO, @PathVariable String betId) {
        Optional<Bet> optionalBet = betService.findById(betId);

        if (optionalBet.isEmpty()) {
            String err = "Bet with the ID " + betId + " Not found in the DB";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", err));
        }

        Bet bet = optionalBet.get();

        if (!bet.getBetStatus().equals(BetStatus.OPEN)) {
            String err = "Bet cannot modify";
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", err));
        }

        bet.setBetTeamA(updateBetDTO.getBetTeamA());
        bet.setBetTeamB(updateBetDTO.getBetTeamB());
        bet.setTiePercentage(updateBetDTO.getTiePercentage());

        betService.save(bet);

        return ResponseEntity.ok().body(Collections.singletonMap("message", "Update was successful"));
    }

    private ResponseEntity<?> modifyStatusOfBet (String betId, BetStatus currentStatus, BetStatus newStatus) {
        Optional<Bet> optionalBet = betService.findById(betId);

        if (optionalBet.isEmpty()) {
            String err = "Bet with the ID " + betId + " Not found in the DB";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", err));
        }

        Bet bet = optionalBet.get();

        if (!bet.getBetStatus().equals(currentStatus)) {
            String err = "Bet cannot modify";
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", err));
        }

        bet.setBetStatus(newStatus);
        betService.save(bet);

        return ResponseEntity.ok().body(Collections.singletonMap("message", "Bet was close with success"));
    }

    @PutMapping("/close-bet/{betId}")
    ResponseEntity<?> closeBet (@PathVariable String betId) {
        return modifyStatusOfBet(betId, BetStatus.OPEN, BetStatus.CLOSE);
    }

    @PutMapping("/payment-bet/{betId}")
    ResponseEntity<?> paymentBet (@PathVariable String betId) {
        return modifyStatusOfBet(betId, BetStatus.CLOSE, BetStatus.PAYMENT);
    }
}
