public class Vehicle {
    // fields
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    // constructor
    Vehicle(
            int vin,
            int year,
            String make,
            String model,
            String vehicleType,
            String color,
            int odometer,
            double price
    ){
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    // getters
    public int getVin() {return this.vin;}
    public int getYear() {return this.year;}
    public String getMake() {return this.make;}
    public String getModel() {return this.model;}
    public String getVehicleType() {return this.vehicleType;}
    public String getColor() {return this.color;}
    public int getOdometer() {return this.odometer;}
    public double getPrice() {return this.price;}

    // setters
    public void setVin(int vin){this.vin = vin;}
    public void setYear(int year){this.year = year;}
    public void setMake(String make){this.make = make;}
    public void setModel(String model){this.model = model;}
    public void setVehicleType(String vehicleType){this.vehicleType = vehicleType;}
    public void setColor(String color){this.color = color;}
    public void setOdometer(int odometer){this.odometer = odometer;}
    public void setPrice(double price){this.price = price;}

    // methods
    public String toString(){
        return String.format(
                "%s|%s|%s|%s|%s|%s|%s|%s",
                this.vin,
                this.year,
                this.make,
                this.model,
                this.vehicleType,
                this.color,
                this.odometer,
                this.price
        );
    }
    public String toStringDisplay(){
        return String.format("""
                VIN: %s
                Year: %s
                Make: %s
                Model: %s
                Vehicle Type: %s
                Color: %s
                Odometer: %s
                Price: %s
                """,
                this.vin,
                this.year,
                this.make,
                this.model,
                this.vehicleType,
                this.color,
                this.odometer,
                this.price
        );
    }
}
