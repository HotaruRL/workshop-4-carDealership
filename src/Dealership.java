import java.util.ArrayList;

public class Dealership {
    // fields
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    // constructor
    Dealership(String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    // getters
    public String getName(){return this.name;}
    public String getAddress(){return this.address;}
    public String getPhone(){return this.phone;}

    // setters
    public void setName(String name){this.name = name;}
    public void setAddress(String address){this.address = address;}
    public void setPhone(String phone){this.phone = phone;}

    // toString methods
    public String toString(){
        return String.format(
                "%s|%s|%s",
                this.name,
                this.address,
                this.phone);
    }
    public String toStringDisplay(){
        return String.format(
                "%s\n%s\n%s",
                this.name,
                this.address,
                this.phone);
    }

    // add and remove methods
    public void addVehicle(Vehicle vehicle){inventory.add(vehicle);}
    public void removeVehicle(Vehicle vehicle){inventory.remove(vehicle);}

    // getVehicles methods
    public ArrayList<Vehicle> getAllVehicles(){
        return inventory;
    }// End of getAllVehicles method

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max){
        ArrayList<Vehicle> list = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (min <= v.getPrice() && v.getPrice() <= max){
                list.add(v);
            }
        }
        return list;
    }// End of getVehiclesByPrice method

    public void getVehiclesByMakeModel(String make, String model){
        for (Vehicle v : inventory) {
            System.out.println(v); // TODO add .toStringDisplay?
        }
    }// End of getVehiclesByMakeModel method

    public void getVehiclesByYear(int min, int max){
        for (Vehicle v : inventory) {
            System.out.println(v); // TODO add .toStringDisplay?
        }
    }// End of getVehiclesByYear method

    public void getVehiclesByColor(String color){
        for (Vehicle v : inventory) {
            System.out.println(v); // TODO add .toStringDisplay?
        }
    }// End of getVehiclesByColor method

    public void getVehiclesByMileage(int min, int max){
        for (Vehicle v : inventory) {
            System.out.println(v); // TODO add .toStringDisplay?
        }
    }// End of getVehiclesByMileage method

    public void getVehiclesByType(String vehicleType){
        for (Vehicle v : inventory) {
            System.out.println(v); // TODO add .toStringDisplay?
        }
    }// End of getVehiclesByType method

}
