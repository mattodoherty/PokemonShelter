package PokemonShelter;
import java.io.File;
import java.util.*;

public class Program {

  public static void main(String[] args)
  {  
     System.out.println("====================================================");
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
      "raichu", "venusaur"};
      List<String> typeList = new ArrayList<>(Arrays.asList(typeArray));
      Scanner input = new Scanner(System.in);
      Adoptee myAnimal = new Adoptee();
      File fileData = new File(System.getProperty("user.dir") + "\\data.csv");
      
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
          System.out.println("====================================================");
          System.out.println(myAnimal.getName() + " the " + myAnimal.getType() + " is being added to our database...");
          myAnimal.setDateAdded(new Date());
          CSVFile.writeToData(fileData, myAnimal);
          myAnimal.printDetails();
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
        System.out.println("Please Enter Pokémon's name:                  ");
        String searchTerm1 = input.nextLine();
        System.out.println("Please Enter Pokémon's type:                  ");
        String searchTerm2 = input.nextLine();
        //Call the search function
        boolean foundFlag = false;
        myAnimal = CSVFile.readData( fileData.getAbsolutePath(), searchTerm1, searchTerm2, foundFlag);
        foundFlag = myAnimal.getName() != null ? true : false;
        loop = false;

        //adopt
        if(foundFlag){
        System.out.println("====================================================");
        System.out.println("-------Would you like to adopt this Pokémon?--------");
        System.out.println("------------------(Y) [YES] (N) [NO]----------------");
        System.out.println("====================================================");
        String adoptChoice = input.nextLine();
        boolean loop2 = true;
        while(loop2)
        {
          if(adoptChoice.equalsIgnoreCase("y")){
            
            //the adopt function
            myAnimal.Adopt();
            System.out.println("Great! " + myAnimal.getName() + " seems really happy to see you!" );
            System.out.println("We're sure you'll make a great Pokémon trainer!");
            System.out.println("Adopted On: " + myAnimal.getRehomingDate());
            loop2 = false;
          }
          else if (adoptChoice.equalsIgnoreCase("n")){
            System.out.println("----------------Have a great day!-------------------");
            System.out.println("====================================================");
            loop2 = false;
          }
          else{
            System.out.println("Invalid input, try again.");
          }
        }
        }
      }
        
      else if(choice.equals("3"))
      {
        //Call the info function
        loop = false;
      }
      
      else 
      {
        System.out.println("Oops! Invalid input. Please try again:");
      }
    }
      //CSVFile.readData();
      input.close();
  }
}
  
  