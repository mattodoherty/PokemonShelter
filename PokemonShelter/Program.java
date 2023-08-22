package PokemonShelter;
import java.util.*;

public class Program {

  public static void main(String[] args)
  {  
    
    System.out.println("-------------------POKÉMON SHELTER------------------");
    System.out.println("====================================================");
    System.out.println("----------------------WELCOME!----------------------");
    System.out.println("====================================================");
    System.out.println("----------------Please Choose an Action-------------");
    System.out.println("====================================================");
    System.out.println("====================================================");
    System.out.println("-1) [  Add New Pokémon  ] -2) [Search For Existing]-");
    System.out.println("-3) [    Shelter Info   ] -0) [      Cancel       ]-");
    System.out.println("====================================================");
    System.out.println("====================================================");
    Boolean loop = true;
    String[] typeArray = new String[]
    {
      "pikachu" , "bulbasaur",  
      "charmander", "squirtle" , "pichu",
      "charizard", "blastoise", 
      "raichu", "venusaur"
    };

    List<String> typeList = new ArrayList<>(Arrays.asList(typeArray));
    Scanner input = new Scanner(System.in);
    Adoptee myAnimal = new Adoptee();
    
    while (loop){
        
      String choice = input.nextLine();
        
      if (choice.equals ("0")) 
      {
        System.out.println("Thanks for stopping by. Have a great day!");
        loop = false;
      }  
      else if(choice.equals("1"))
      {
        System.out.println("====================================================");
        System.out.println("------------------Add a New Adoptee-----------------");
        System.out.println("Please enter Pokémon Type:                          ");

        String newEntry = input.nextLine();
        myAnimal.Initialise(input, newEntry);
        if (typeList.contains(newEntry.toLowerCase()))
        {
          System.out.println(myAnimal.getName() + " the " + myAnimal.getType() + " is being added to our database...");
          Date date = new Date();
          myAnimal.setDateAdded(date);
          CSVFile.writeToData(myAnimal);
          loop = false;
        }
        else 
        {
          System.out.println("Oops! Invalid input. Please try again:");
        }
      }
      else if(choice.equals("2"))
      {
        System.out.println("====================================================");
        System.out.println("-------------Search For an Existing Adoptee---------");
        System.out.println("------Please Enter Pokémon's name:                  ");
        //Call the search function
        //CSVFile.readData(fileData, searchTerm);
        loop = false;
      }
        
      else if(choice.equals("3"))
      {
        //Call the search function
        loop = false;
      }
      
      else 
      {
        System.out.println("Oops! Invalid input. Please try again:");
      }
    }
      //myAnimal.printDetails();
      //CSVFile.readData();
      input.close();
  }
}
  
  