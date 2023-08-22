package PokemonShelter;
import java.util.Scanner;
import java.util.Date;

public class Adoptee extends Animal{
 
      public Adoptee(){}
 
      public Adoptee(String name, String type, Date dateAdded, Date rehomingDate, double costPerDay){
              super(name, type, dateAdded, rehomingDate, costPerDay);
      }

      public void Initialise(Scanner input, String newEntry){
        System.out.println(" ");
        System.out.println("Enter " + newEntry + "'s name: ");
        String name = input.nextLine();
        this.setName(name);
        this.setType(newEntry);
        this.setCostPerDay(12.5);
      }
}