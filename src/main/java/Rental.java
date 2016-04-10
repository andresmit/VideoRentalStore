/**
 * Created by mariellesari on 09/04/16.
 */
public class Rental{



    private Movie movie;
    private int daysRented;
    private int lateDays = 0;


    /**
     * Rental cant be constructed if the movie is already rented.
     *
     * @param movie
     * @param daysRented
     * @throws RuntimeException
     */
    public Rental(Movie movie, int daysRented) throws RuntimeException {
        if(movie.isRented()) {
            throw new RuntimeException("Movie is already rented!");
        }

        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return this.daysRented;
    }

    public Movie getMovie() {
        return this.movie;

    }

    double getSum(){
        return this.movie.getSum(this.daysRented);
    }

    @Override
    public String toString() {
        return "Rental{" +
                "movie=" + movie +
                ", daysRented=" + daysRented +
                ", lateDays=" + lateDays +
                '}';
    }

    public int getLateDays() {
        return lateDays;
    }

    public void setLateDays(int lateDays) {
        this.lateDays = lateDays;
    }


}
