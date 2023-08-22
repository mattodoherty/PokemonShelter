package PokemonShelter;
import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class CSVFile{

    /**
     * @param filePath
     * @param adoptee
     */
    public static void writeToData(Adoptee adoptee){

        File fileData = new File(System.getProperty("user.dir") + "\\data.csv");

        try{
            
            FileWriter outFile = new FileWriter(fileData, true);
            String header =  "Name " + "," + " Type" + "," + "Cost Per Day" + "," + "Date Added" + "," + "Rehoming Date";
            BufferedWriter bw = new BufferedWriter(outFile);

            //Adding a header to CSV with params - check if file is empty
            if(fileData.length() == 0) {

                bw.write(header);
            
            }

            
            
            System.out.println("Working Directory: " + System.getProperty("user.dir"));
            
            String directory = System.getProperty("user.dir");
            
            
            
            //Adding data to CSV
            String data = 
            adoptee.getName() +","+ 
            adoptee.getType() + "," +
            adoptee.getCostPerDay() + "," +
            //toString converts dates to strings
            adoptee.getDateAdded().toString() + "," ;
            //adoptee.getRehomingDate().toString();
            bw.newLine();
            bw.write(data);
            bw.close();
               
            System.out.println("Pokémon added successfully!");
        }
        catch (IOException e) {
            // TODO auto-generated catch block
            e.printStackTrace();
        }

    }

     public static void readData(String fileData, String searchTerm)
     {
        
        String file = System.getProperty("user.dir") + "\\data.csv";
        BufferedReader reader = null;
        
        try 
        {
            String line = "";
            reader = new BufferedReader(new FileReader(fileData));
            String headerLine = reader.readLine();

            while((line = reader.readLine()) != null)
            {

                String[] fields = line.split(",");
                
                if (fields.length >= 2) 
                {
                    String firstColumnValue = fields[0].trim();
                    String secondColumnValue = fields[1].trim();
                    for (String index : fields)
                    {
                        System.out.printf("%-10s", index);
                    }
                    
                    if(firstColumnValue.equalsIgnoreCase(searchTerm)) 
                    {
                        System.out.println("Found a matching record: " + line);
                    }
                    else
                    {
                    }
                    System.out.print("No record found for '" + searchTerm + "'");
                }
                System.out.println();
            }
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        finally
        {

            try {
                reader.close();
            } catch (IOException e) {

                e.printStackTrace();

            }
        }
    }

  /*private static Scanner x;

public static void readFile(String searchTerm, String filepath)
  {
    boolean found = false;
  
    try
    {
        x = new Scanner (new File(filepath));
        x.useDelimiter("[,\n]");
        while(x.hasNext() && !found)
        {
            setType(x.next());
            name = x.next();
            costPerDay = x.next();
            dateAdded = x.next();
            rehomingDate = x.next();

            if(ID.equals(searchTerm))
            {
                found = true;
            }

        if (found)
        {
            myAnimal.printDetails();
        } 
        }
    }
    catch(Exception e)
    {

    }
    }*/
  }



    


