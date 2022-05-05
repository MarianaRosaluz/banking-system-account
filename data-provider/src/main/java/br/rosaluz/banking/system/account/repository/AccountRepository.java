package br.rosaluz.banking.system.account.repository;

import br.rosaluz.banking.system.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByaccountNumber(String Login);
}
