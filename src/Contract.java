abstract class Contract {
    String date;
    String customerName;
    String customerEmail;
    Vehicle vehicleSold;


    Contract(
            String date,
            String customerName,
            String customerEmail,
            Vehicle vehicleSold){
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }
    // getters
    public String getDate(){return date;}
    public String getCustomerName(){return customerName;}
    public String getCustomerEmail(){return customerEmail;}
    public Vehicle getVehicleSold(){return vehicleSold;}
    abstract double getTotalPrice();
    abstract double getMonthlyPayment(boolean isFinanced);
}
