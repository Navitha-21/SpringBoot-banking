package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="acc_id")
    private Long id;

    @Column(name="acc_num")
    private String acc_num;

    @Column(name="name")
    private String name;

    @Column(name="city")
    private String city;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    @Column(name="balance")
    private double balance;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getAcc_num(){
        return acc_num;
    }
    public void setAcc_num(String acc_num) {
        this.acc_num = acc_num;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name =name;
    }

    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city=city;
    }

    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone =phone;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public double getBalance(){

        return balance;
    }
    public void setBalance(double balance) {

        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "Id=" + id +
                ", Acc_num=" + acc_num  + ", Name=" + name+ ", City= " + city+
                ", email=" + email + ", Phone=" + phone + ", Balance=" + balance +  '}';
    }


}
