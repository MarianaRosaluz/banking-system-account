package br.rosaluz.banking.system.account.controller;

import br.rosaluz.banking.system.account.dto.AccountDTO;
import br.rosaluz.banking.system.account.dto.AccountToAccountDTO;
import br.rosaluz.banking.system.account.model.Account;
import br.rosaluz.banking.system.account.service.AccountService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/banking/system/account", produces="application/json")
@Api(value="API REST Banking System")
@AllArgsConstructor
public class AccountController {



    @Autowired
    private AccountService accountService;

    private final ConversionService conversionService;


    @GetMapping("/findByAccount/{accountNumber}")
    public ResponseEntity<?> findByAccount(@PathVariable String accountNumber)
    {

         Account account = accountService.findByAccount(accountNumber).get();
        return ResponseEntity.ok(conversionService.convert(account, AccountDTO.class));

    }
}
