//package org.example.controller;
//
//import org.example.model.Account;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/new-style")
//public class RestAPIHttpMethod {
//
//    @GetMapping(path = "/users/info")
//    public String getAllData(){
//        return "Returns all users Data";
//    }
//
//    @PostMapping(path = "/users/info")
//    public String createUser(@RequestBody Account requestData){
//        String Acc_num = requestData.getAcc_num();
//        String Name = requestData.getName();
//        String city = requestData.getCity();
//        String phone = requestData.getPhone();
//        String email = requestData.getEmail();
//        double balance = requestData.getBalance();
//        return "Create new user";
//    }
//
//    @GetMapping(path = "/users/info/{id}")
//    public String getInfoById(@PathVariable int id){
//        return "Returns all users based on ID";
//    }
//
//    @PutMapping(path = "/users/info")
//    public String putUser(@RequestBody Map<String, Object> requestData){
//        String Acc_num = (String)requestData.get("Acc_num");
//        String Name = (String)requestData.get("Name");
//        String city =(String) requestData.get("city");
//        String phone = (String)requestData.get("Phone");
//        String email = (String)requestData.get("Email");
//        double balance =(Double) requestData.get("Balance");
//        return "Full update complete for user with ID ";
//    }
//
//    @DeleteMapping(path = "/users/info")
//    public String deleteUser(@RequestBody Map<String, Object> requestData){
//        String Acc_num = (String)requestData.get("Acc_num");
//        return "Partial update complete for ID 101";
//    }
//
//}
