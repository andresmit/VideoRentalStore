import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by mariellesari on 09/04/16.
 */
public class CustomerTest {

    private Customer customer;
    private Movie movieNew;
    private Movie movieReg;
    private Movie movieOld;
    Rental rental;
    Rental rental2;
    Rental rental1;


    @Before
    public void initObjects() {

        customer = new Customer("TestPerson");
        movieNew = new Movie("New", 0);
        movieReg = new Movie("Reg", 1);
        movieOld = new Movie("Old", 2);
        rental = new Rental(movieNew, 10);
        rental2 = new Rental(movieOld, 8);
        rental1 = new Rental(movieReg, 6);
    }


    @Test
    public void testCalcBonus() throws RuntimeException {


        assertEquals(customer.calcBonus(rental), 2);
    }


    @Test
    public void testAddRental() {

        customer.addRental(rental1);
        assertTrue(rental1.getMovie().isRented());
        assertEquals(customer.getRentals().get(0).getMovie(), movieReg);

    }

    @Test
    public void testReturnMovie() throws Exception {
        customer.returnMovie(rental1.getMovie());
        assertFalse(rental1.getMovie().isRented());
        assertEquals(customer.getRentals().size(), 0);
    }
}