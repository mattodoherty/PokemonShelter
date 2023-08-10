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
      "charmander", "squirtle" ,
     "pikachu" , "bulbasaur", 
     "eevee", "lucario", 
     "charizard", "blastoise", 
     "raichu", "dragonite"};
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

        System.out.println(myAnimal.getName() + " the " + myAnimal.getType() + " is being added to our database.");
      
        loop = false;
      }

      else{

        System.out.println("Oops! Invalid input. Please try again:");

      }
    }

    CSVFile.writeToData(myAnimal);

    input.close();

         //A method for the date the animal was added   


        Date date = new Date();
        myAnimal.setDateAdded(date);

  }
}

