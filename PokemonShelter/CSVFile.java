package PokemonShelter;
import java.io.*;


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

            
            
            //System.out.println("Working Directory: " + System.getProperty("user.dir"));
            
            
            
            
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
    public static void readData(){

        String file = "src\\Adoptees.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){

                String[] row = line.split(",");

                for (String index : row){
                    System.out.printf("%-10s", index);
                }
                System.out.println();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally{

        }
    }


}