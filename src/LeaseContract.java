public class LeaseContract extends Contract{
    private double residualValuePercentage = 0.5; // Ending Value is only 50% of the original price
    private double expectedEndingValue = vehicleSold.getPrice() * residualValuePercentage;
    private double leaseFee = vehicleSold.getPrice() * 0.07; // 7% of the original price
    private double monthlyPayment;
    private double monthlyInterestRate = 0.04 / 12; // 4.0% APR / 12 months
    private int numberOfPayments = 36; // ALL leases terms are set to 36 months

    LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
    }

    @Override
    double getTotalPrice() {
        return (vehicleSold.getPrice() * residualValuePercentage) + leaseFee;
    }

    @Override
    double getMonthlyPayment(boolean isFinanced) {
        this.monthlyPayment = getTotalPrice() * ((monthlyInterestRate * Math.pow((1 + monthlyInterestRate),numberOfPayments)) / ((Math.pow(1 + monthlyInterestRate, numberOfPayments)) - 1));
        return this.monthlyPayment;
    }

    // toStrings
    public String toString(){
        return String.format(
                "LEASE|%s|%s|%s|%s|%s|%s|%s|%s",
                this.date,
                this.customerName,
                this.customerEmail,
                this.vehicleSold.toString(),
                this.expectedEndingValue,
                this.leaseFee,
                this.getTotalPrice(),
                this.monthlyPayment
        );
    }
    public String toStringDisplay(){
        return String.format("""
                LEASE
                Date: %s
                Name: %s
                Email: %s
                Vehicle Leased:
                %s
                Expected Ending Value: %.2f
                Leasing Fee: %.2f
                Total Price: %.2f
                Monthly Payment: %.2f""",
                this.date,
                this.customerName,
                this.customerEmail,
                this.vehicleSold.toStringDisplay(),
                this.expectedEndingValue,
                this.leaseFee,
                this.getTotalPrice(), //it is off by $100!?
                this.monthlyPayment
        );
    }
}
