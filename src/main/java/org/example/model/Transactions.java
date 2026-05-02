package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name="transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    private Account account;

    @Column(name="fromacc_id")
    private Long fromacc;

    @Column(name="toacc_id")
    private Long  toacc;
    @Column(name="amount")
    private double amount;

    @Column(name="type")
    private String type;


    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public  Account getAccount() {
        return account;
    }
    public void setAccount(Account account){
        this.account = account;
    }

    public double getAmount(){
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType(){
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Long getFromacc(){
        return fromacc;
    }
    public void setFromacc(Long fromacc){
        this.fromacc=fromacc;
    }

    public Long getToacc(){
        return toacc;
    }
    public void setToacc(Long toacc){
        this.toacc=toacc;
    }


}

