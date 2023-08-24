package PokemonShelter;
import java.util.Scanner;
import java.io.File;
import java.util.Date;


public class Adoptee extends Animal{
 
      public Adoptee(){}
 
      public Adoptee(String name, String type, double weight, Date dateAdded, Date rehomingDate, double costPerDay){
              super(name, type, weight, dateAdded, rehomingDate, costPerDay);
      }

      public void Initialise(Scanner input, String newEntry){
        System.out.println(" ");
        System.out.println("Enter " + newEntry + "'s name: ");
        String name = input.nextLine();
        System.out.println("Enter " + name + "'s weight (kg): ");
        double weight = input.nextDouble();
        this.setName(name);
        this.setType(newEntry);
        this.setWeight(weight);
        this.setCostPerDay(weight * 0.2);
      }

      public void Adopt()
      {
        File fileData = new File(System.getProperty("user.dir") + "\\data.csv");
        this.setRehomingDate(new Date());
        this.setDateAdded(getDateAdded());
        CSVFile.writeToData(fileData, this);
        this.setCostPerDay(0);
      }



}