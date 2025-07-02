/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GastadorPiggeryFarm;

import java.sql.Date;

/**
 *
 * @author Donald
 */
public class customerData {
    
    private Integer customerId;
    private String name;
    private String gender;
    private Integer age;
    private Integer phone;
    private String address;
    private String ageOfPig;
    private Integer pigId;
    private Integer quantity;
    private Double price;
    private Date date;
    
    public customerData(Integer customerId,String name, String gender,Integer age,Integer phone,String address,String ageOfPig, 
            Integer pigId, 
            Integer quantity, Double price, Date date){
    
        this.customerId = customerId;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.ageOfPig = ageOfPig;
        this.pigId = pigId;
        this.quantity = quantity;
        this.price = price;
        this.date = date; 
        
    }
    
    public Integer getCustomerId(){
        return customerId;
    }
    
    public String getName(){
        return name;
    }
    
    public String getGender(){
        return gender;
    }
    
    public Integer getAge(){
        return age;
    }
    
    public Integer getPhone(){
        return phone;
    }
    
    public String getAddress(){
        return address;
    }
    
    public String getAgeOfPig(){
        return ageOfPig;
    }
    
    public Integer getPigId(){
        return pigId;
    }
    
    public Integer getQuantity(){
        return quantity;
    }
    
    public Double getPrice(){
        return price;
    }
    
    public Date getDate(){
        return date;
    }
    
    
}
