import java.io.BufferedReader;
import java.io.FileReader;


public class DealershipFileManager {
    String FilePath = "inventory.csv";

    public void getDealership(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FilePath));
            // get dealership info from 1st line and create a new dealership object
            String[] dealershipInfoParts = bufferedReader.readLine().trim().split("\\|");
            String dealershipName = dealershipInfoParts[0];
            String dealershipAddress = dealershipInfoParts[1];
            String dealershipPhone = dealershipInfoParts[2];
            Dealership dealership1 = new Dealership(dealershipName, dealershipAddress, dealershipPhone);
            System.out.println(dealership1); // TODO remove this line

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
                dealership1.addVehicle(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));
            }// End of getDealership while loop
            dealership1.getAllVehicles(); // TODO remove this line
        }catch (Exception e){
            System.out.println("File cannot be read. Please double check FilePath!");
            throw new RuntimeException(e); // TODO remove this line?
        }

    }

//    public void saveDealership(){} // TODO add code to this method later
}
