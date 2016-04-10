import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by mariellesari on 09/04/16.
 */
public class InventoryTest {

    int n = 0;
    int r = 1;
    int o = 2;

    Movie m1 = new Movie("Matrix Old", o);
    Movie m2 = new Movie("Matrix Regular", r);
    Movie m3 = new Movie("Matrix New", n);
    Movie m4 = new Movie("Louie Old", o);
    Movie m5 = new Movie("Louie Regular", r);
    Movie m6 = new Movie("Louie New", n);

    Inventory inventory = Inventory.getInstance();

    @Test
    public void testGetAllMovies() throws Exception {

        inventory.addFilm(m1);
        inventory.addFilm(m2);
        inventory.addFilm(m3);
        inventory.addFilm(m4);
        inventory.addFilm(m5);
        inventory.addFilm(m6);

        ArrayList<Movie> movies = inventory.getAllMovies();
        assert movies.size() == 6;

    }

    @Test
    public void testGetAllMoviesInStore() throws Exception {

    }
}