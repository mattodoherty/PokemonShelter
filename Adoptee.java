package AnimalShelterProject;
import java.util.Scanner;
import java.util.Date;

public class Adoptee extends Animal{
 
      public Adoptee(){}
 
      public Adoptee(String name, String type, Date dateAdded, Date rehomingDate, double costPerDay){
              super(name, type, dateAdded, rehomingDate, costPerDay);
      }

      public void Initialise(Scanner input, String choice){
        System.out.println("Enter " + choice + "'s name: ");
        String name = input.nextLine();
        this.setName(name);
        this.setType(choice);
        this.setCostPerDay(12.5);
      }
}