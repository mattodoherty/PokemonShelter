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
    public static void writeToData(File fileData, Adoptee adoptee){

        

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
            
            e.printStackTrace();
        }

    }

     public static void readData(String fileData, String searchTerm1, String searchTerm2)
     {
        
        String file = System.getProperty("user.dir") + "\\data.csv";
        BufferedReader reader = null;
        
        try 
        {
            if(fileData.length() == 0) 
            {

                System.out.println("Opps! Looks like our database is empty!");
            
            }
            else
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
                        if(firstColumnValue.equalsIgnoreCase(searchTerm1) && secondColumnValue.equalsIgnoreCase(searchTerm2)) 
                        {
                            System.out.println("====================================================");
                            System.out.println("Name     Type     Cost P/D     Date Joined");
                            System.out.println("====================================================");
                            System.out.println(line);
                        }
                        else
                        {
                            System.out.println("No record found for '" + searchTerm1 + "'" + " the '" + searchTerm2 + "'.");
                        }
                }
                System.out.println();
                 }
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
  }



    


