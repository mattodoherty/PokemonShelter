package PokemonShelter;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
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
            String header =  "Name " + "," + " Type" + "," + "Weight" + "," + "Cost Per Day" + "," + "Date Added" + "," + "Rehoming Date";
            BufferedWriter bw = new BufferedWriter(outFile);

            //Adding a header to CSV with params - check if file is empty
            if(fileData.length() == 0) {

                bw.write(header);
            
            }
            
           // System.out.println("Working Directory: " + System.getProperty("user.dir"));
            String validateRehomingDate;
           if(adoptee.getRehomingDate() != null){
                validateRehomingDate = adoptee.getRehomingDate().toString();
                
                File file = new File(System.getProperty("user.dir") + "\\data.csv");
                BufferedReader reader = new BufferedReader(new FileReader(file));
                List<String> lines = reader.lines().collect(Collectors.toList());
                String row = lines.get(0);
                //lines.set(0, row);
                FileWriter writer = new FileWriter(file);
                for (String line : lines) {
                    String[] fields = line.split(",");
                    if(!(adoptee.getName().equals(fields[0]) && adoptee.getType().equals(fields[1]))){
                        writer.write(line + System.lineSeparator());
                    }
                }
                writer.close();
            }
           else{
                validateRehomingDate = "";
           }
            //Adding data to CSV
            String data = 
            adoptee.getName() +","+ 
            adoptee.getType() + "," +
            adoptee.getWeight() + "," +
            adoptee.getCostPerDay() + "," +
            adoptee.getDateAdded().toString() + "," + 
            validateRehomingDate;
            if(validateRehomingDate.equals("")){
                bw.newLine();
            }
            bw.write(data);
            bw.close();
               
            System.out.println("Pokémon added successfully!");
        }
        catch (IOException e) {
            
            e.printStackTrace();
        }

    }

    public static Adoptee readData(String fileData, String searchTerm1, String searchTerm2, boolean foundFlag)
    {
        
        String file = System.getProperty("user.dir") + "\\data.csv";
        BufferedReader reader = null;
        Adoptee searchAnimal = new Adoptee();
        try 
        {
            String line;
            reader = new BufferedReader(new FileReader(file));
            //String headerLine = reader.readLine();
            while ((line = reader.readLine()) != null)
            {
                String[] fields = line.split(",");
                boolean found = false;
                
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
                            foundFlag = true;
                            searchAnimal.setName(fields[0]);
                            searchAnimal.setType(fields[1]);
                            searchAnimal.setWeight(Double.parseDouble(fields[2]));
                            searchAnimal.setCostPerDay(Double.parseDouble(fields[3]));
                            searchAnimal.setDateAdded(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(fields[4]));
                            String rehomingDate = "";
                            if(fields.length == 6){
                                rehomingDate = fields[5];
                                searchAnimal.setRehomingDate(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(rehomingDate));
                            }
                            else{
                                searchAnimal.setRehomingDate(null);
                            }
                            

                        } 
                    
                    }
            }
            if (!foundFlag){
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
        return searchAnimal;
    }
  }



    


