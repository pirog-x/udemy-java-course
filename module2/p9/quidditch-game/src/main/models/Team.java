package src.main.models;

import java.util.Arrays;
import java.util.Objects;

public class Team {
    private String house;
    private String keeper;
    private String seeker;
    private String[] chasers;

    private static final String POSITION_CHASER = "chaser";
    private static final String POSITION_SEEKER = "seeker";
    private static final String POSITION_KEEPER = "keeper";


    public Team(String house, String keeper, String seeker, String[] chasers) {
        if (house == null || keeper == null || seeker == null || chasers == null) {
            throw new IllegalArgumentException("field cannot be null");
        }
        if (house.isBlank() || keeper.isBlank() || seeker.isBlank()) {
            throw new IllegalArgumentException("field cannot be blank");
        }
        if (chasers.length != 3) {
            throw new IllegalArgumentException("chasers length must equal to 3");
        }
        if (Arrays.stream(chasers).anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("Any field of chasers cannot be null");
        }
        if (Arrays.stream(chasers).anyMatch(String::isBlank)) {
            throw new IllegalArgumentException("Any of the chasers elements cannot be blanked");
        }

        this.house = house;
        this.keeper = keeper;
        this.seeker = seeker;
        this.chasers = Arrays.copyOf(chasers, chasers.length);
    }

    public Team(Team source) {
        this.house = source.house;
        this.keeper = source.keeper;
        this.seeker = source.seeker;
        this.chasers = Arrays.copyOf(source.chasers, source.chasers.length);
    }

    public String getHouse() {
        return house;
    }

    public String getKeeper() {
        return keeper;
    }

    public String getSeeker() {
        return seeker;
    }

    public String[] getChasers() {
        return Arrays.copyOf(chasers, chasers.length);
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setKeeper(String keeper) {
        this.keeper = keeper;
    }

    public void setSeeker(String seeker) {
        this.seeker = seeker;
    }

    public void setChasers(String[] chasers) {
        this.chasers = chasers;
    }

    public static String getPositionChaser() {
         return POSITION_CHASER;
     }

    public static String getPositionSeeker() {
         return POSITION_SEEKER;
     }

    public static String getPositionKeeper() {
         return POSITION_KEEPER;
     }

    @Override
    public String toString() {
        return "House: " + this.house + "\n" +
                "Keeper: " + this.keeper + "\n" +
                "Seeker: "  + this.seeker + "\n" +
                "Chasers: " + Arrays.toString(this.chasers) + "\n";
    }
}
