/**
 * Created by mariellesari on 09/04/16.
 */

public class Front {

    public static void main(String[] args) throws RuntimeException {
        int n = 0;
        int r = 1;
        int o = 2;

        /*
        Get Inventory, Create movies, Add to inventory
         */

        Inventory inventory = Inventory.getInstance();

        Movie m1 = new Movie("Matrix Old", o);
        Movie m2 = new Movie("Matrix Regular", r);
        Movie m3 = new Movie("Matrix New", n);
        Movie m4 = new Movie("Louie Old", o);
        Movie m5 = new Movie("Louie Regular", r);
        Movie m6 = new Movie("Louie New", n);
        Movie m7 = new Movie("Xena New", n);

        inventory.addFilm(m1);
        inventory.addFilm(m2);
        inventory.addFilm(m3);
        inventory.addFilm(m4);
        inventory.addFilm(m5);
        inventory.addFilm(m6);
        inventory.addFilm(m7);

        /*
        Create rentals, create customers, rent 3 movies to a customer "Bob"
         */

        Rental r1 = null;
        Rental r2 = null;
        Rental r3 = null;
        Rental r4 = null;
        Rental r5 = null;
        Rental r6 = null;
        Rental r7 = null;
        try {
            r1 = new Rental(m1, 5);
            r2 = new Rental(m2, 5);
            r3 = new Rental(m3, 5);
            r4 = new Rental(m4, 5);
            r5 = new Rental(m5, 5);
            r6 = new Rental(m6, 5);
            r7 = new Rental(m1, 1); //Throws exception
        } catch (RuntimeException e) {
            e.getMessage();
        }

        Customer c1 = new Customer("Bob");
        Customer c2 = new Customer("Cat");
        Customer c3 = new Customer("Man");

        c1.addRental(r1);
        c1.addRental(r2);
        c1.addRental(r3);



        /*
        Create and print a regular receipt, Check inventory and "Bob" bonus points
         */

        Boolean late = false;
        Receipt rec1 = new Receipt(c1.getRentals(), c1);
        System.out.println(rec1.printReceipt());

        System.out.println(inventory.getAllMovies());
        System.out.println(inventory.getAllMoviesInStore());
        System.out.println(c1.getBonusPoints());

        /*
        Rent movie "Louie Old" to customer "Cat", create and print late receipt
         */


        c2.addRental(r4);
        r4.setLateDays(3);

        late = true;

        Receipt rec2 = new Receipt(c2.getRentals(), c2);
        System.out.println(rec2.printReceipt());

        /*
        Get Bob Bonus Points and all rentals, return a movie, check again for rentals
         */
        System.out.println(c2.getBonusPoints());
        System.out.println();

        System.out.println(c2.getRentals());

        c2.returnMovie(m4);

        System.out.println(c2.getRentals());

        /*
        Check inventory
         */

        System.out.println(inventory.getAllMoviesInStore());
        System.out.println(inventory.getAllMovies());


        /*
        Add bonus points to Bob
         */

        c3.setBonusPoints(30);
        c3.addRental(r6);
        Receipt.BonusReceipt bonusRec = new Receipt.BonusReceipt(c3.getRentals(), c3);
        System.out.println(bonusRec.printReceipt());
        c2.addRental(r6);
    }
}
