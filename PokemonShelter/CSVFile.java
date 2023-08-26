package PokemonShelter;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
               
            System.out.println("Pokémon processed successfully!");
            System.out.println("*TESTING* Directory:" + System.getProperty("user.dir"));
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
                           
                            foundFlag = true;
                            searchAnimal.setName(fields[0]);
                            searchAnimal.setType(fields[1]);
                            searchAnimal.setWeight(Double.parseDouble(fields[2]));
                            searchAnimal.setDateAdded(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(fields[4]));
                            String rehomingDate = "";
                            if(fields.length == 6){
                                rehomingDate = fields[5];
                                searchAnimal.setRehomingDate(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(rehomingDate));
                                searchAnimal.setCostPerDay(0);
                            }
                            else{
                                searchAnimal.setRehomingDate(null);
                                line = line.replace(fields[3], "0");
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

    public static void ShelterStats(String fileData) throws IOException, ParseException
    {
        
        BufferedReader reader = new BufferedReader(new FileReader(fileData));
        String line;
        double totalCostPerDay = 0;
        Date earliestDate = null;
        String earliestPokemonName = "";
        String earliestPokemonType = "";
        Map<String, Integer> typeCount = new HashMap<>();
        boolean headerLine = true;

        while ((line = reader.readLine()) != null) {
            if (headerLine){
                headerLine = false;
                continue;

            }
            String[] fields = line.split(",");
            double costPerDay = Double.parseDouble(fields[3]);
            totalCostPerDay += costPerDay;

            Date dateAdded = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(fields[4]);
            if (earliestDate == null || dateAdded.before(earliestDate)) {
                earliestDate = dateAdded;
                earliestPokemonName = fields[0];
                earliestPokemonType = fields[1];
            }

            String type = fields[1];

            if (fields.length == 6){
                continue;
            }
            else{
                typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);

            }
        }

        System.out.println("Total cost per day: " + totalCostPerDay);
        System.out.println("Total cost per annum: " + (totalCostPerDay*365));
        System.out.println( earliestPokemonName + " the " + earliestPokemonType + " has been at the shelter for the longest.");
        System.out.println( earliestPokemonName + " joined us on " + earliestDate + ".");
        System.out.println("Pokémon of each type: " + typeCount);
        System.out.println("Total Pokémon: " + typeCount.size());

        reader.close();
    }

    }
  



    


