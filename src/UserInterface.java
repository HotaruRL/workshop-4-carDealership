import java.util.*;

public class UserInterface {
    // fields
    Dealership dealership;
    DealershipFileManager dealershipFM = new DealershipFileManager();
    Menu m = new Menu("=", 56, 5);
    Scanner in = new Scanner(System.in);
    // constructor
    UserInterface(){
        this.dealership = init();
    }
    // ------------------------------------------- USER INPUT VALIDATION -------------------------------------------- //
    // Input strings are not empty
    public String getValidatedInputString (String fieldName){
        String userInput;
        while (true) {
            System.out.printf("Please enter the %s: ", fieldName);
            userInput = in.nextLine().trim();
            if (!userInput.isEmpty()) {
                break;
            }else {
                System.out.printf("\n%s cannot be blank. Please hit [Enter] to try again!", fieldName);
//                in.nextLine();
            }
        }
        return userInput;
    } // End of getValidatedInputString method
    // Input numbers are decimals
    public double getValidatedInputDouble (String fieldName){
        double userInput = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.printf("Please enter the %s: ", fieldName);
                String text = in.nextLine();
                userInput = Double.parseDouble(text);
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.printf("\nInvalid input. Please enter a number value for %s!\n", fieldName);
            }
        }
        return userInput;
    }
    // ----------------------------------------- USER INPUT VALIDATION ENDS ----------------------------------------- //

    // ----------------------------------------------- DISPLAY METHODS ---------------------------------------------- //
    public Dealership init(){
        return dealershipFM.getDealership();
    }

    public void display(){
        init();
        int userInput = -1;
        while(userInput != 0){
            try{
                m.menuHeader("Main Menu");
                m.printMainMenu();
                userInput = in.nextInt();
                String _ = in.nextLine();
                switch (userInput){
                    case 1 -> processGetByPriceRequest();
                    case 2 -> processGetByMakeModelRequest();
                    case 3 -> processGetByYearRequest();
                    case 4 -> processGetByColorRequest();
                    case 5 -> processGetByMileageRequest();
                    case 6 -> processGetByVehicleTypeRequest();
                    case 7 -> processAllVehiclesRequest();
                    case 8 -> processAddVehicleRequest();
                    case 9 -> processRemoveVehicleRequest();
                    case 0 -> System.out.println("Thank you for visiting our dealership! See you again!");
                    default -> System.out.println("\nCommand not found. Please try again!");
                }
            } catch (Exception e) {
                System.out.println("Invalid command. Please try again!");
                in.nextLine();
            }
        }
    }// End of display()

    public void displayVehicles(ArrayList<Vehicle> list, String title){
        System.out.println(m.createPattern("🔻", 50));
        System.out.println(title);
        String prefix = m.createPattern("- ", 55) + "\n";
        for (Vehicle v : list) {
            System.out.println(prefix + v.toStringDisplay());
        }
        System.out.println(prefix + title);
        System.out.println(m.createPattern("🔺", 50));
    }// End of displayVehicles()

    public void respondToStringCriteria(String criteria){
        init();
        String filter1 = getValidatedInputString(criteria);
        ArrayList<Vehicle> filteredList = new ArrayList<>();
        switch (criteria) {
            case "Color" -> filteredList.addAll(dealership.getVehiclesByColor(filter1));
            case "Vehicle Type" -> filteredList.addAll(dealership.getVehiclesByType(filter1));
            default -> System.out.println("Error with respondToStringCriteria' switch");
        }
        String title = String.format("%d vehicles found that have the %s of %s",
                filteredList.size(), criteria, filter1);
        displayVehicles(filteredList, title);
    }
    public void respondToNumberCriteria(String criteria){
        init();
        String minName = "Minimum " + criteria;
        String maxName = "Maximum " + criteria;
        double min = Math.abs(getValidatedInputDouble(minName));
        double max = Math.abs(getValidatedInputDouble(maxName));
        ArrayList<Vehicle> filteredList = new ArrayList<>();
        switch (criteria){
            case "Price" -> filteredList.addAll(dealership.getVehiclesByPrice(min, max));
            case "Year" -> filteredList.addAll(dealership.getVehiclesByYear((int) min, (int) max));
            case "Mileage" -> filteredList.addAll(dealership.getVehiclesByMileage((int) min, (int) max));
            default -> System.out.println("Error with respondToNumberCriteria' switch");
        }
        String title = String.format("%d vehicles found within the %s range of %.2f - %.2f",
                filteredList.size(), criteria, min, max);
        displayVehicles(filteredList, title);
    }
    // -------------------------------------------- DISPLAY METHODS ENDS -------------------------------------------- //

    // ------------------------------------------ GET VEHICLE LIST METHODS ------------------------------------------ //
    public void processAllVehiclesRequest(){
        init();
        String title = String.format("%d vehicles found in inventory.", dealership.getAllVehicles().size());
        displayVehicles(dealership.getAllVehicles(),title);
    }// End of processAllVehiclesRequest()

    public void processGetByPriceRequest(){
        respondToNumberCriteria("Price");
    } // End of processGetByPriceRequest()

    public void processGetByMakeModelRequest(){
        init();
        ArrayList<Vehicle> filteredList = new ArrayList<>();
        System.out.print("Please enter the Make: ");
        String make = in.nextLine().trim();
        System.out.print("Please enter the Model: ");
        String model = in.nextLine().trim();
        filteredList.addAll(dealership.getVehiclesByMakeModel(make, model));
        String title = String.format("%d vehicles found that match Make: %s and/or Model: %s",
                filteredList.size(), make, model);
        displayVehicles(filteredList, title);
    } // End of processGetByMakeModelRequest()

    public void processGetByYearRequest(){
        respondToNumberCriteria("Year");
    } // End of processGetByYearRequest()

    public void processGetByColorRequest(){
        respondToStringCriteria("Color");
    } // End of processGetByColorRequest()

    public void processGetByMileageRequest(){
        respondToNumberCriteria("Mileage");
    } // End of processGetByMileageRequest()

    public void processGetByVehicleTypeRequest(){
        respondToStringCriteria("Vehicle Type");
    } // End of processGetByVehicleTypeRequest()
    // --------------------------------------- GET VEHICLE LIST METHODS ENDS ---------------------------------------- //

    // ----------------------------------------- ADD/REMOVE VEHICLE METHODS ----------------------------------------- //
    // TODO: add validation (range) for each field
    // TODO: refactor confirmation into its own method
    // TODO: change [Any Key] to a specific key and add loop to handle input
    public void processAddVehicleRequest(){
        String confirmation;
        do {
            m.menuHeader("Add a Vehicle");
            init();
            int vin = (int) getValidatedInputDouble("VIN");
            int year = (int) getValidatedInputDouble("Year");
            String make = getValidatedInputString("Make");
            String model = getValidatedInputString("Model");
            String vehicleType = getValidatedInputString("Vehicle Type");
            String color = getValidatedInputString("Color");
            int odometer = (int) getValidatedInputDouble("Odometer");
            double price = getValidatedInputDouble("Price");
            Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
            System.out.print("\nThe following vehicle will be added to inventory:\n" + newVehicle.toStringDisplay());
            System.out.print("\nEnter [1] to CONFIRM or press [Any Key] to CANCEL: ");
            confirmation = in.nextLine().trim();
            if (confirmation.equals("1")) {
                dealership.addVehicle(newVehicle);
                dealershipFM.saveDealership(dealership, dealership.getAllVehicles()); // TODO: move this save step to after exiting the program?
                System.out.println("The car has been successfully added!");
            }
            System.out.print("\n\nDo you want to add another vehicle?");
            System.out.print("\nEnter [Any Key] to CONFIRM or enter [0] to go back to Main Menu: ");
            confirmation = in.nextLine().trim();
        }while(!confirmation.equals("0"));
    }// End of processAddVehicleRequest()

    public void processRemoveVehicleRequest(){
        String confirmation;
        int vinToRemove;
        int found = 0;
        do {
            m.menuHeader("Remove a Vehicle");
            init();
            vinToRemove = (int) getValidatedInputDouble("VIN to REMOVE");
            for (Vehicle vehicle : (dealership.getAllVehicles())){
                if (vinToRemove == vehicle.getVin()){
                    found++;
                    System.out.print("\nThe following vehicle will be removed to inventory:\n" + vehicle.toStringDisplay());
                    System.out.print("\nEnter [1] to CONFIRM or enter [Any Key] to CANCEL: ");
                    confirmation = in.nextLine().trim();
                    if (confirmation.equals("1")) {
                        dealership.removeVehicle(vehicle);
                        dealershipFM.saveDealership(dealership, dealership.getAllVehicles()); // TODO: move this save step to after exiting the program?
                        System.out.println("The car has been successfully removed!");
                        break;
                    }else{
                        break;
                    }
                }
            }
            if (found == 0){
                System.out.printf("\nThere is no vehicle match with VIN# %s!", String.valueOf(vinToRemove));
            }
            System.out.print("\n\nDo you want to remove another vehicle?");
            System.out.print("\nEnter [Any Key] to CONFIRM or enter [0] to go back to Main Menu: ");
            found = 0;
            confirmation = in.nextLine().trim();
        }while (!confirmation.equals("0"));
    }

    // -------------------------------------- ADD/REMOVE VEHICLE METHODS ENDS --------------------------------------- //
}
