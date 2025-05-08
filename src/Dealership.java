import java.util.ArrayList;

public class Dealership {
    // fields
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory = new ArrayList<>();

    // constructor
    Dealership(String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    // getters
    public String getName(){return this.name;}
    public String getAddress(){return this.address;}
    public String getPhone(){return this.phone;}

    // setters
    public void setName(String name){this.name = name;}
    public void setAddress(String address){this.address = address;}
    public void setPhone(String phone){this.phone = phone;}

    // methods

    public String toString(){
        return String.format(
                "%s\n%s\n%s",
                this.name,
                this.address,
                this.phone);
    }

    public void addVehicle(Vehicle vehicle){inventory.add(vehicle);}
//    public void removeVehicle(Vehicle vehicle){inventory.remove(vehicle);}

    public void getAllVehicles(){
        for (Vehicle v : inventory) {
            System.out.println(v); // TODO add .toStringDisplay?
        }
    }// End of getVehiclesByPrice method

//    public void getVehiclesByPrice(min, max){
//        for (Vehicle v : inventory) {
//            System.out.println(v); // TODO add .toStringDisplay?
//        }
//    }// End of getVehiclesByPrice method

//    public void getVehiclesByMakeModel(make, model){
//        for (Vehicle v : inventory) {
//            System.out.println(v); // TODO add .toStringDisplay?
//        }
//    }// End of getVehiclesByMakeModel method

//    public void getVehiclesByYear(min, max){
//        for (Vehicle v : inventory) {
//            System.out.println(v); // TODO add .toStringDisplay?
//        }
//    }// End of getVehiclesByYear method

//    public void getVehiclesByColor(color){
//        for (Vehicle v : inventory) {
//            System.out.println(v); // TODO add .toStringDisplay?
//        }
//    }// End of getVehiclesByColor method

//    public void getVehiclesByMileage(min, max){
//        for (Vehicle v : inventory) {
//            System.out.println(v); // TODO add .toStringDisplay?
//        }
//    }// End of getVehiclesByMileage method

//    public void getVehiclesByType(vehicleType){
//        for (Vehicle v : inventory) {
//            System.out.println(v); // TODO add .toStringDisplay?
//        }
//    }// End of getVehiclesByType method

}
