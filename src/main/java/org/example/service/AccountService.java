package org.example.service;

import jakarta.transaction.Transactional;
import org.example.model.Account;
import org.example.model.Transactions;
import org.example.repository.AccountRepository;
import org.example.repository.TransactionsRepository;
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

    public Account getById(Long id) {
        return this.accountRepository.getById(id);
    }

    public List<Account> findAll() {
        return this.accountRepository.findAll();
    }

    public void delete(Long id) {
        this.accountRepository.delete(id);
    }

    public Account update(Long id, Account account){
        Account oldAcc = this.accountRepository.findById(id).orElse(null);
        if(oldAcc != null){
            oldAcc.setAcc_num(account.getAcc_num());
            oldAcc.setName(account.getName());
            oldAcc.setCity(account.getCity());
            oldAcc.setPhone(account.getPhone());
            oldAcc.setEmail(account.getEmail());
            oldAcc.setBalance(account.getBalance());
            return this.accountRepository.save(oldAcc);
        }
        return null;
    }


    public void deposit(Long acc_id, double amount) {
        accountRepository.deposit(acc_id, amount);
    }

    public void withdraw(Long acc_id, double amount) {
        accountRepository.withdraw(acc_id, amount);
    }

    public void transfer(Long fromAcc, Long toAcc, double amount) {
        accountRepository.transfer(fromAcc, toAcc, amount);
    }

}
