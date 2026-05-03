package org.example.service;

import jakarta.transaction.Transactional;
import org.example.model.Account;
import org.example.model.Transactions;
import org.example.repository.AccountRepository;
import org.example.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    private final TransactionsRepository transactionsRepository;

    AccountService(AccountRepository accountRepository, TransactionsRepository transactionsRepository){
        this.accountRepository=accountRepository;
        this.transactionsRepository=transactionsRepository;
    }

    public Account save(Account account){
        return this.accountRepository.save(account);
    }

    public List<Account> findAll() {
        return this.accountRepository.findAll();
    }

    public Account findById(Long id){
        return accountRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        this.accountRepository.deleteById(id);
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

    @Transactional
    public void deposit(Long acc_id, double amount) {
        Account acc=accountRepository.findById(acc_id).get();
        if (acc == null) {
            System.out.println("Account not found");
        }
        acc.setBalance(acc.getBalance() + amount);
        accountRepository.save(acc);
        saveTransactions(acc_id,null,"Deposit",amount);

    }

    @Transactional
    public void withdraw(Long acc_id, double amount) {
        Account acc=accountRepository.findById(acc_id).get();
        if (acc.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        acc.setBalance(acc.getBalance() - amount );
        accountRepository.save(acc);
        saveTransactions(acc_id,null,"Withdraw",amount);
    }

    @Transactional
    public void transfer(Long fromAcc, Long toAcc, double amount) {
        Account from = accountRepository.findById(fromAcc).get();
        Account to = accountRepository.findById(toAcc).get();
        if (from == null || to == null || from.getBalance() < amount ) {
            System.out.println("Account not found");
        }
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
        accountRepository.save(from);
        accountRepository.save(to);
        saveTransactions(fromAcc,toAcc, "Transfer", amount);
    }

    public void saveTransactions(Long fromAcc, Long toAcc,String type, double amount){
        Transactions tnx=new Transactions();
        tnx.setFromacc(fromAcc);
        tnx.setToacc(toAcc);
        tnx.setType(type);
        tnx.setAmount(amount);
        transactionsRepository.save(tnx);
    }

//    @Transactional
//    public Account updateTransaction(Long acc_id, Account account){
//        Account newAcc=this.accountRepository.findById(acc_id).orElse(null);
//        if(newAcc!=null){
//            newAcc.setAcc_num(account.getAcc_num());
//            newAcc.setName(account.getName());
//            newAcc.setCity(account.getCity());
//            newAcc.setPhone(account.getPhone());
//            newAcc.setEmail(account.getEmail());
//            newAcc.setBalance(account.getBalance());
//            Account acc=this.accountRepository.save(newAcc);
//            if(acc!=null){
//                System.out.println("Error Updating Account");
//            }
//        }
//        return null;
//    }
}

