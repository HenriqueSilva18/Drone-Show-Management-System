package lapr4.showProposalManagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    private static final double TEST_LATITUDE = 41.14961;
    private static final double TEST_LONGITUDE = -8.61099;

    @Test
    void ensureCanCreateValidCoordinates() {
        new Coordinates(TEST_LATITUDE, TEST_LONGITUDE);
        assertTrue(true);
    }

    @Test
    void ensureLatitudeCannotBeLessThanMinus90() {
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(-90.1, 0));
    }

    @Test
    void ensureLatitudeCannotBeGreaterThan90() {
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(90.1, 0));
    }

    @Test
    void ensureLongitudeCannotBeLessThanMinus180() {
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(0, -180.1));
    }

    @Test
    void ensureLongitudeCannotBeGreaterThan180() {
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(0, 180.1));
    }

    @Test
    void latitude() {
        Coordinates coords = new Coordinates(TEST_LATITUDE, TEST_LONGITUDE);
        assertEquals(TEST_LATITUDE, coords.latitude());
    }

    @Test
    void longitude() {
        Coordinates coords = new Coordinates(TEST_LATITUDE, TEST_LONGITUDE);
        assertEquals(TEST_LONGITUDE, coords.longitude());
    }

    @Test
    void testEquals() {
        Coordinates coords1 = new Coordinates(TEST_LATITUDE, TEST_LONGITUDE);
        Coordinates coords2 = new Coordinates(TEST_LATITUDE, TEST_LONGITUDE);
        Coordinates coords3 = new Coordinates(40.7128, -74.0060); // New York
        Coordinates coords4 = new Coordinates(TEST_LATITUDE, -74.0060);

        assertEquals(coords1, coords1);             // Test for reflexivity
        assertEquals(coords1, coords2);             // Test for symmetry
        assertEquals(coords2, coords1);             // Test for symmetry
        assertNotEquals(coords1, coords3);          // Test for non-equality
        assertNotEquals(coords1, coords4);          // Test for non-equality
        assertNotEquals(null, coords1);   // Test with null
        assertNotEquals(new Object(), coords1);      // Test with different object type
    }

    @Test
    void testHashCode() {
        Coordinates coords1 = new Coordinates(TEST_LATITUDE, TEST_LONGITUDE);
        Coordinates coords2 = new Coordinates(TEST_LATITUDE, TEST_LONGITUDE);

        assertEquals(coords1.hashCode(), coords2.hashCode());

        Coordinates coords3 = new Coordinates(40.7128, -74.0060);
        assertNotEquals(coords1.hashCode(), coords3.hashCode());
    }
}