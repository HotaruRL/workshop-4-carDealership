public class Program {
    public static void main(String[] args) {
//        UserInterface UI = new UserInterface();
//        UI.display();

        // to test SalesContract
        UserInterface ui = new UserInterface();
        ui.init();
        SalesContract sale = new SalesContract(
                "20250515",
                "Jone Doe",
                "jdoe@wa.com",
                ui.dealership.getAllVehicles().get(1));
        sale.getMonthlyPayment(true);
        System.out.println(sale.toStringDisplay());
    }
}
