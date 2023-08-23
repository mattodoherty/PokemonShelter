package PokemonShelter;
import java.io.*;


public class CSVFile{

    /**
     * @param filePath
     * @param adoptee
     */
    public static void writeToData(File fileData, Adoptee adoptee){

        

        try{
            
            FileWriter outFile = new FileWriter(fileData, true);
            String header =  "Name " + "," + " Type" + "," + "Weight" + "," + "Cost Per Day" + "," + "Date Added" + "," + "Rehoming Date";
            BufferedWriter bw = new BufferedWriter(outFile);

            //Adding a header to CSV with params - check if file is empty
            if(fileData.length() == 0) {

                bw.write(header);
            
            }
            
           // System.out.println("Working Directory: " + System.getProperty("user.dir"));
 
            //Adding data to CSV
            String data = 
            adoptee.getName() +","+ 
            adoptee.getType() + "," +
            adoptee.getWeight() + "," +
            adoptee.getCostPerDay() + "," +
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
            String line;
            boolean found = false;
            reader = new BufferedReader(new FileReader(file));
            String headerLine = reader.readLine();
            while ((line = reader.readLine()) != null)
            {
                String[] fields = line.split(",");

                if(file.length() == 0) 
                {

                    System.out.println("Oops! Looks like our database is empty!");
                
                }
                else
                {
                    String firstColumnValue = fields[0].trim();
                    String secondColumnValue = fields[1].trim();
                    if(firstColumnValue.equalsIgnoreCase(searchTerm1) && secondColumnValue.equalsIgnoreCase(searchTerm2)) 
                        {
                            System.out.println("====================================================");
                            System.out.println("Name     Type    Weight(kg)  Cost P/D    Date Joined");
                            System.out.println("====================================================");
                            System.out.println("");
                            System.out.println(line);
                            System.out.println("");
                            found = true;
                        } 
                    
                    }
            }
            if (!found){
                System.out.println("No record found for '" + searchTerm1 + "'" + " the '" + searchTerm2 + "'.");
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



    


