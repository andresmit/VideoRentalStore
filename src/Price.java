/**
 * Created by Andres on 07/04/2016.
 */

abstract class Price {


    abstract int getPriceCode();}

    class OldFilmPrice extends Price {
        int getPriceCode() {
            return Movie.OLD_FILM;
        }
    }
    class NewReleasePrice extends Price {
        int getPriceCode() {
            return Movie.NEW_RELEASE;
        }
    }
    class RegularPrice extends Price {
        int getPriceCode() {
            return Movie.REGULAR;
        }
    }