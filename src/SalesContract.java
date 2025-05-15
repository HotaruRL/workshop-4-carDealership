public class SalesContract extends Contract{
    private final double SALE_TAX = 0.05;
    private double salesTaxAmount = vehicleSold.getPrice() * SALE_TAX;
    private double recordingFee = 100;
    private double processingFee;
    private double totalPrice;
    private boolean isFinanced;
    private double monthlyPayment;
    private double interestRate;
    private int numberOfPayments;
    private final int HURDLE = 10000;

    SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        if (vehicleSold.getPrice() < HURDLE){
            this.processingFee = 295;
            this.interestRate = 0.0525 / 12.0; // 5.25% APR
            this.numberOfPayments = 24;
        }else {
            this.processingFee = 495;
            this.interestRate = 0.0425 / 12.0; // 4.25% APR
            this.numberOfPayments = 48;
        }

    }

    @Override
    double getTotalPrice() {
        this.totalPrice = (vehicleSold.getPrice() * (1 + SALE_TAX)) + recordingFee + processingFee;
        return totalPrice;
    }

    @Override
    double getMonthlyPayment(boolean isFinanced) {
        if (isFinanced){
            this.isFinanced = isFinanced;
            this.monthlyPayment = getTotalPrice() * ((interestRate * Math.pow((1 + interestRate),numberOfPayments)) / ((Math.pow(1 + interestRate, numberOfPayments)) - 1));
        } else {
            this.monthlyPayment = 0;
        }
        return monthlyPayment;
    }

    // toStrings
    public String toString(){
        return String.format(
                "SALE|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s",
                this.date,
                this.customerName,
                this.customerEmail,
                this.vehicleSold.toString(),
                this.salesTaxAmount,
                this.recordingFee,
                this.processingFee,
                this.getTotalPrice(),
                this.isFinanced,
                this.monthlyPayment
        );
    }

    public String toStringDisplay(){
        return String.format("""
                SALE
                Date: %s
                Name: %s
                Email: %s
                Vehicle Sold:
                %s
                Sale Tax Amount: %.2f
                Recording Fee: %.2f
                Processing Fee: %.2f
                Total One-Time Payment: %.2f
                Financed?: %s
                Monthly Payment: %.2f""",
                this.date,
                this.customerName,
                this.customerEmail,
                this.vehicleSold.toStringDisplay(),
                this.salesTaxAmount,
                this.recordingFee,
                this.processingFee,
                this.getTotalPrice(),
                this.isFinanced,
                this.monthlyPayment
        );
    }
}
