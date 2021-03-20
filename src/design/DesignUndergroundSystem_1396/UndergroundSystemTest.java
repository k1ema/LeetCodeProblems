package design.DesignUndergroundSystem_1396;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UndergroundSystemTest {
    @Test
    public void test() {
        UndergroundSystem us = new UndergroundSystem();
        us.checkIn(45, "Leyton", 3);
        us.checkIn(32, "Paradise", 8);
        us.checkIn(27, "Leyton", 10);
        us.checkOut(45, "Waterloo", 15);
        us.checkOut(27, "Waterloo", 20);
        us.checkOut(32, "Cambridge", 22);
        assertEquals(14d, us.getAverageTime("Paradise", "Cambridge"));
        assertEquals(11d, us.getAverageTime("Leyton", "Waterloo"));
        us.checkIn(10, "Leyton", 24);
        assertEquals(11d, us.getAverageTime("Leyton", "Waterloo"));
        us.checkOut(10, "Waterloo", 38);
        assertEquals(12d, us.getAverageTime("Leyton", "Waterloo"));

        us = new UndergroundSystem();
        us.checkIn(10, "Leyton", 3);
        us.checkOut(10, "Paradise", 8);
        assertEquals(5d, us.getAverageTime("Leyton", "Paradise")); // return 5.00000
        us.checkIn(5, "Leyton", 10);
        us.checkOut(5, "Paradise", 16);
        assertEquals(5.5d, us.getAverageTime("Leyton", "Paradise")); // return 5.50000
        us.checkIn(2, "Leyton", 21);
        us.checkOut(2, "Paradise", 30);
        assertEquals(6.66667d, us.getAverageTime("Leyton", "Paradise"), 1e-5); // return 6.66667
    }
}
