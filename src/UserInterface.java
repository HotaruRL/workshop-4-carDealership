import java.util.Scanner;

public class UserInterface {
    // fields
    Dealership dealership;
    Scanner in = new Scanner(System.in);
    // constructor
    UserInterface(){
        this.dealership = init();
    }

    // methods
    private Dealership init(){
        DealershipFileManager dealershipFM = new DealershipFileManager();
        return dealershipFM.getDealership();
    }

    public void display(){
        init();
        Menu m = new Menu("=", 56, 5);
        int userInput = -1;
        while(userInput != 99){
            try{
                m.menuHeader("Main Menu");
                System.out.print("""
                        1 - Find vehicles within a price range
                        2 - Find vehicles by make / model
                        3 - Find vehicles by year range
                        4 - Find vehicles by color
                        5 - Find vehicles by mileage range
                        6 - Find vehicles by type (car, truck, SUV, van)
                        7 - List ALL vehicles
                        8 - Add a vehicle
                        9 - Remove a vehicle
                        99 - Quit
                
                Please enter the appropriate number to execute the task: 
                """);
                userInput = in.nextInt();
                String _ = in.nextLine();
                switch (userInput){
//                    case 1 -> dealership.getVehiclesByPrice();
//                    case 2 -> dealership.getVehiclesByMakeModel();
//                    case 3 -> dealership.getVehiclesByYear();
//                    case 4 -> dealership.getVehiclesByColor();
//                    case 5 -> dealership.getVehiclesByMileage();
//                    case 6 -> dealership.getVehiclesByType();
                    case 7 -> dealership.getAllVehicles();
//                    case 8 -> dealership.addVehicle();
//                    case 9 -> dealership.removeVehicle();
                    case 99 -> userInput = 99;
                    default -> System.out.println("\nCommand not found. Please try again!");
                }
            } catch (Exception e) {
                System.out.println("Invalid command. Please try again!");
                in.nextLine();
            }
        }
    }

}
