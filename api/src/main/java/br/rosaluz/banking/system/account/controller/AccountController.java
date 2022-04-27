package br.rosaluz.banking.system.account.controller;

import br.rosaluz.banking.system.account.model.Account;
import br.rosaluz.banking.system.account.service.AccountService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/banking/system/singup", produces="application/json")
@Api(value="API REST Banking System")
public class AccountController {



    @Autowired
    private AccountService accountService;


    public AccountController(AccountService accountService) {

        this.accountService = accountService;


    }


    @PostMapping("/create")
    public ResponseEntity<?> create(UriComponentsBuilder uriBuider)
    {

         Account account = accountService.generateAccount();




        return ResponseEntity.ok().build();

    }
}
