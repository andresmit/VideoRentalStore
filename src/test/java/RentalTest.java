import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mariellesari on 09/04/16.
 */
public class RentalTest {

    @Test
    public void testGetSum() throws RuntimeException {

        Movie movieNew = new Movie("New", 0);
        Movie movieReg = new Movie("Reg", 1);
        Movie movieOld = new Movie("Old", 2);

        Rental rental1 = new Rental(movieReg, 6);
        Rental rental2 = new Rental(movieOld, 8);
        Rental rental = new Rental(movieNew, 10);

        Assert.assertEquals(rental.getSum(), 40, 0);
        Assert.assertEquals(rental1.getSum(), 12, 0);
        Assert.assertEquals(rental2.getSum(), 12, 0);
    }
}