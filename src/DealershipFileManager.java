import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class DealershipFileManager {
    String FilePath = "inventory.csv";
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;

    public Dealership getDealership(){
        Dealership dealership = new Dealership("","","");
        try {
            bufferedReader = new BufferedReader(new FileReader(FilePath));
            // get dealership info from 1st line
            String[] dealershipInfoParts = bufferedReader.readLine().trim().split("\\|");
            // update dealership instance with new info
            dealership.setName(dealershipInfoParts[0]);
            dealership.setAddress(dealershipInfoParts[1]);
            dealership.setPhone(dealershipInfoParts[2]);

            // get vehicles info from next line and add vehicles to the new dealership obj's inventory
            String input;
            while ((input = bufferedReader.readLine()) != null){
                String[] vehicleInfoParts = input.trim().split("\\|");
                int vin = Integer.parseInt(vehicleInfoParts[0]);
                int year = Integer.parseInt(vehicleInfoParts[1]);
                String make = vehicleInfoParts[2];
                String model = vehicleInfoParts[3];
                String vehicleType = vehicleInfoParts[4];
                String color = vehicleInfoParts[5];
                int odometer = Integer.parseInt(vehicleInfoParts[6]);
                double price = Double.parseDouble(vehicleInfoParts[7]);
                dealership.addVehicle(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));
            }// End of getDealership while loop
            bufferedReader.close();
        }catch (Exception e){
            System.out.println("File cannot be read. Please double check FilePath!");
            e.printStackTrace(); // TODO remove this line?
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership, ArrayList<Vehicle> dealershipInventory){
        try{
            bufferedWriter = new BufferedWriter(new FileWriter(FilePath));
            bufferedWriter.write(dealership.toString());
            for (Vehicle v : dealershipInventory){
                bufferedWriter.newLine();
                bufferedWriter.write(v.toString());
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("File cannot be written to. Please double check FilePath!");
            e.printStackTrace(); // TODO remove this line?
        }
    }
}
