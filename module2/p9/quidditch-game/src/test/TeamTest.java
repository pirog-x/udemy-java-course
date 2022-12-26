package src.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.main.models.Team;


public class TeamTest {

    @Test
    public void hasNullCheck() {
        String house = "houseTest";
        String keeper = "keeperTest";
        String seeker = "seekerTest";

        String[] chasers = new String[] {null, "Ginny", "Katie"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Team(house, keeper, seeker, chasers));
    }

    @Test
    public void hasBlankChasersTest() {
        String house = "houseTest";
        String keeper = "keeperTest";
        String seeker = "seekerTest";

        String[] chasers = new String[] {" ", "Ginny", "Katie"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Team(house, keeper, seeker, chasers));
    }

    @Test
    public void hasMissedTest() {
        String house = "houseTest";
        String keeper = "keeperTest";
        String seeker = "seekerTest";

        String[] chasers = new String[] {"Ginny", "Katie"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Team(house, keeper, seeker, chasers));
    }

    @Test
    public void hasBlankFieldTest() {
        String house = "houseTest";
        String keeper = "keeperTest";
        String seeker = "";

        String[] chasers = new String[] {"Ginny", "Katie"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Team(house, keeper, seeker, chasers));

    }
}
