package PokemonShelter;
import java.util.*;

public class Program {

  public static void main(String[] args){  
    
    System.out.println("------------------POKÉMON SHELTER-----------------");
    System.out.println("---------------------WELCOME!---------------------");
    System.out.println("--Please Enter Pokémon choice, or Enter 0 to Exit:");
    System.out.println("                                                  ");
    Boolean loop = true;
    String[] typeArray = new String[]{
      "pikachu" , "bulbasaur",  
      "charmander", "squirtle" , "pichu",
      "charizard", "blastoise", 
      "raichu", "venusaur"};
      List<String> typeList = new ArrayList<>(Arrays.asList(typeArray));
      Scanner input = new Scanner(System.in);
      Adoptee myAnimal = new Adoptee();
    
      while (loop){
        
        String choice = input.nextLine();
        
        if (choice.equals ("0")) {
          
          System.out.println("Thanks for stopping by. Have a great day!");
          
          loop = false;
        }  
        
        else if (typeList.contains(choice.toLowerCase())){
          myAnimal.Initialise(input,choice);
          
          System.out.println(myAnimal.getName() + " the " + myAnimal.getType() + " is being added to our database...");
          Date date = new Date();
          myAnimal.setDateAdded(date);
          CSVFile.writeToData(myAnimal);
          
          loop = false;
        }
        
        else{
          
          System.out.println("Oops! Invalid input. Please try again:");
          
        }
      }
      
      //myAnimal.printDetails();
      //CSVFile.readData();
      input.close();
      
      
      
      
      
      
    }
  }
  
  