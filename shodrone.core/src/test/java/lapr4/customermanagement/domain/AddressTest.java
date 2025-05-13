package lapr4.customermanagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void testStreetCannotBeNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () ->
                new Address(null, "City", "1234-567", "Country"));
        assertThrows(IllegalArgumentException.class, () ->
                new Address("   ", "City", "1234-567", "Country"));
    }

    @Test
    void testStreetAcceptsValidCharacters() {
        assertDoesNotThrow(() -> new Address("Main St. 123", "City", "1234", "Country"));
        assertThrows(IllegalArgumentException.class, () ->
                new Address("Invalid$Street", "City", "1234", "Country"));
    }

    @Test
    void testCityCannotBeNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () ->
                new Address("Street", null, "1234", "Country"));
        assertThrows(IllegalArgumentException.class, () ->
                new Address("Street", "   ", "1234", "Country"));
    }

    @Test
    void testPostalCodeAcceptsLettersNumbersAndDashes() {
        assertDoesNotThrow(() -> new Address("Street", "City", "ABC-123", "Country"));
        assertThrows(IllegalArgumentException.class, () ->
                new Address("Street", "City", "123#456", "Country"));
    }

    @Test
    void testCountryCannotBeNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () ->
                new Address("Street", "City", "1234", null));
        assertThrows(IllegalArgumentException.class, () ->
                new Address("Street", "City", "1234", "   "));
    }


    @Test
    void valueOf_CreatesValidAddress() {
        Address address = Address.valueOf("Street", "City", "1234", "Country");
        assertNotNull(address);
        assertEquals("Street", address.toString().split(", ")[0]);
    }

    @Test
    void testEquals_ReturnsTrueForSameValues() {
        Address addr1 = new Address("Street", "City", "1234", "Country");
        Address addr2 = new Address("Street", "City", "1234", "Country");
        assertEquals(addr1, addr2);
    }

    @Test
    void testEquals_ReturnsFalseForDifferentValues() {
        Address addr1 = new Address("Street A", "City", "1234", "Country");
        Address addr2 = new Address("Street B", "City", "1234", "Country");
        assertNotEquals(addr1, addr2);
    }

    @Test
    void testHashCode_ConsistentWithEquals() {
        Address addr1 = new Address("Street", "City", "1234", "Country");
        Address addr2 = new Address("Street", "City", "1234", "Country");
        assertEquals(addr1.hashCode(), addr2.hashCode());
    }

    @Test
    void testToString_ReturnsCorrectFormat() {
        Address address = new Address("Main St", "Lisbon", "1000-001", "Portugal");
        assertEquals("Main St, Lisbon, 1000-001, Portugal", address.toString());
    }

    @Test
    void compareTo_OrdersByCountryCityPostalCodeStreet() {
        Address addr1 = new Address("A St", "Lisbon", "1000", "Portugal");
        Address addr2 = new Address("B St", "Porto", "2000", "Portugal");
        Address addr3 = new Address("C St", "Lisbon", "1000", "Spain");

        assertTrue(addr1.compareTo(addr2) < 0);
        assertTrue(addr1.compareTo(addr3) < 0);
    }

    @Test
    void testTrimSpacesInConstructor() {
        Address address = new Address("  Street  ", "  City  ", "  1234  ", "  Country  ");
        assertEquals("Street, City, 1234, Country", address.toString());
    }
}