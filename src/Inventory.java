import java.util.ArrayList;

/**
 * Created by Andres on 07/04/2016.
 */
public class Inventory {
    private ArrayList<Movie> movies;

    void addFilm(Movie movie){
        movies.add(movie);
    }

    void removeFilm(Movie movie) {
        movies.remove(movie);
    }

    public ArrayList<Movie> getAllMovies(){
        return movies;
    }

    public ArrayList<Movie> getAllMoviesInStore(){
        ArrayList<Movie> inStore = new ArrayList<Movie>();

        for (Movie movie:movies){

            inStore.add(movie);
        }
        return movies;
    }
}
