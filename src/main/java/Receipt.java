import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by mariellesari on 09/04/16.
 */

public class Receipt {

    // Hardcoded locale
    Locale estonia = new Locale("et", "EE");
    NumberFormat estFormat = NumberFormat.getCurrencyInstance(estonia);

    Customer customer;

    ArrayList<Rental> rentals;

    public Receipt(ArrayList<Rental> rentals, Customer customer) {
        this.rentals = rentals;
        this.customer = customer;
    }


    /**
     * Concatenates regular/late receipt string
     *
     * @return Receipt String for printing
     */

    public String printReceipt() {
        double totalSum = 0;
        String result = "";

        for (Rental r : rentals) {
            double thisSum = 0;

            int days = r.getDaysRented();

            thisSum = r.getSum();
            totalSum += thisSum;

            result += r.getMovie().getTitle() + " " + days + " days  " + estFormat.format(thisSum) + "\n";
        }

        result += "Total " + " Sum: " + estFormat.format(totalSum) + "\n";
        return result;
    }


    /**
     * Created by mariellesari on 10/04/16.
     */
    public static class BonusReceipt extends Receipt {
        public BonusReceipt(ArrayList<Rental> rentals, Customer customer) {
            super(rentals, customer);


        }

        public String printReceipt() {
            double totalSum = 0;
            String result = "";

            int bonusPoints = customer.getBonusPoints();
            for (Rental r : rentals) {

                if (r.getMovie().getPriceCode() != Movie.NEW_RELEASE) {
                    throw new RuntimeException("Only new releases can be rented with bonus points!");
                }

                int days = r.getDaysRented();

                if (days * 25 > bonusPoints) {

                    result += r.getMovie().getTitle() + " " + days + " days  " + "paid with 25 bonus points" + "\n";

                    customer.setBonusPoints(customer.getBonusPoints()-25);
                    bonusPoints -= 25;
                }

            }

            result += "Total " + " Sum: " + estFormat.format(totalSum) + "\n";
            result += "Remaining Bonus points: " + bonusPoints + "\n";
            return result;
    }
    }

    /**
     * Created by mariellesari on 10/04/16.
     */
    public static class LateReceipt extends Receipt {
        public LateReceipt(ArrayList<Rental> rentals, Customer customer) {
            super(rentals, customer);
        }

        @Override
        public String printReceipt() {
            double totalSum = 0;
            String lateStr = "Late";
            String extraStr = "Extra";
            String result = "";

            for (Rental r : rentals) {
                double thisSum = 0;

                int days = r.getLateDays();

                thisSum = r.getSum();
                totalSum += thisSum;

                result += r.getMovie().getTitle() + " " + extraStr + " " + days + " days  " + estFormat.format(thisSum) + "\n";
            }

            result += "Total " + lateStr + " Sum: " + estFormat.format(totalSum) + "\n";

            return result;
        }
    }
}
