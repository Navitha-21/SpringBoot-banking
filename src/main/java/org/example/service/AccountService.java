package org.example.service;

import org.example.model.Account;
import org.example.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    AccountService(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }
    public Account save(Account account){
        return this.accountRepository.save(account);
    }

    public Account getAccount(Long id) {
        return accountRepository.findById(id);
    }

    public List<Account> getAccount() {
        return accountRepository.getAccounts();
    }

    public void delete(Long id) {
        accountRepository.delete(id);
    }

//    public void deleteWithFailure(Long id) {
//        accountRepository.deleteWithFailure(id);
//    }
//
//    public void deposit(Long acc_id, double amount) {
//        accountRepository.deposit(acc_id, amount);
//    }
//
//    public void withdraw(Long acc_id, double amount) {
//        accountRepository.withdraw(acc_id, amount);
//    }
//
//    public void transfer(Long fromAcc, Long toAcc, double amount) {
//        accountRepository.transfer(fromAcc, toAcc, amount);
//    }

}
