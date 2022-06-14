package br.rosaluz.banking.system.account.controller;

import br.rosaluz.banking.system.account.dto.AccountDTO;
import br.rosaluz.banking.system.account.dto.BalanceDTO;
import br.rosaluz.banking.system.account.service.BalanceService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/banking/system/account/balance", produces="application/json")
@Api(value="API REST Banking System")
@AllArgsConstructor
public class BalanceController {

    @Autowired
    private BalanceService balanceService;

    @PostMapping("/increase")
    public ResponseEntity<?> increaseBalance(@RequestBody BalanceDTO balanceDTO){

        balanceService.increaseBalance(balanceDTO.getAccountNumber(), balanceDTO.getAmount());
        return ResponseEntity.ok().build();

    }

    @PostMapping("/decrease")
    public ResponseEntity<?> decreaseBalance(@RequestBody BalanceDTO balanceDTO){

        balanceService.decreaseBalance(balanceDTO.getAccountNumber(), balanceDTO.getAmount());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/accountNumber")
    public ResponseEntity<?> balance(@RequestBody String accountNumber){
        Double balance = balanceService.getBalance(accountNumber);
        return ResponseEntity.ok(balance);

    }
}
