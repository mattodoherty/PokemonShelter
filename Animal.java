package PokemonShelter;
import java.util.Date;


public abstract class Animal {

    private String name;
    
    private String type;

    
    private Date dateAdded;
    
    private Date rehomingDate;
    
    private double costPerDay; 
    

   
    //No arg constrctor for animal
    public Animal(){}

    //Constructor for an animal
    public Animal(String name, String type, Date dateAdded, Date rehomingDate, double costPerDay){
        
        this.name = name;
        this.dateAdded = dateAdded;
        this.rehomingDate = rehomingDate;
        this.type = type;
        this.costPerDay = costPerDay;
           
}
//Method to print animal details
public void printDetails() {
    
    System.out.println ("Name: " + name);
    System.out.println ("Daily cost: " + costPerDay);
    System.out.println ("Joined us on: " + dateAdded);
    System.out.println ("Was rehomed on: " + rehomingDate);
    
}





//--------------------------------------------------Getters and Setters----------------------------------------------------------------

public String getType() {
    return type;
}

public void setType(String type) {
    this.type = type;
}
public String getName() {
    return name;
}
public void setName(String name){
    this.name = name;
}

public Date getDateAdded() {
    return dateAdded;
}
public void setDateAdded(Date dateAdded) {
    this.dateAdded = dateAdded;
}


public Date getRehomingDate() {
    return rehomingDate;
}
public void setRehomingDate(Date rehomingDate) {
    this.rehomingDate = rehomingDate;
}


public double getCostPerDay() {
    return costPerDay;
}
public void setCostPerDay(double costPerDay) {
        this.costPerDay = costPerDay;
    }
    
 //----------------------------------------------------------------------------------------------------------------------------------   
 
 
}
 
 
 
 
 
 
 