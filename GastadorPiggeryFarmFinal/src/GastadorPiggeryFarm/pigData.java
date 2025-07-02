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
public class pigData {
    
    private Integer pigId;
    private String status;
    private Double price;
    private Date date;
    private Integer ageOfPig;
    
                        // MAKE SURE TO FOLLOW THESES DATA TYPES
    public pigData(Integer pigId, String status, Double price, Date date, Integer ageOfPig){
        
        this.pigId = pigId;
        this.status = status;
        this.price = price;
        this.date = date;
        this.ageOfPig = ageOfPig;
    }
    
    public Integer getPigId(){
        return pigId;
    }
    
    public String getStatus(){
        return status;
    }
    
    public Double getPrice(){
        return price;
    }
    
    public Date getDate(){
        return date;
    }
    
    public Integer getAgeOfPig(){
        return ageOfPig;
    }
    
}
