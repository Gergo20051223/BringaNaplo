package hu.nye.progkor.bringanaplo;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class BiciklizesTest {

    @Test
    void testBiciklizesGettersAndSetters() {
        Biciklizes bringa = new Biciklizes();
        bringa.setId(1L);
        bringa.setDatum(LocalDate.of(2026, 5, 20));
        bringa.setTavolsagKm(15.5);
        bringa.setIdotartamPerc(45);
        bringa.setMegjegyzes("Teszt tekerés");

        assertEquals(1L, bringa.getId());
        assertEquals(LocalDate.of(2026, 5, 20), bringa.getDatum());
        assertEquals(15.5, bringa.getTavolsagKm());
        assertEquals(45, bringa.getIdotartamPerc());
        assertEquals("Teszt tekerés", bringa.getMegjegyzes());
    }

    @Test
    void testBiciklizesLombokMethods() {
        Biciklizes bringa1 = new Biciklizes(1L, LocalDate.of(2026, 5, 20), 15.5, 45, "Teszt", null);
        Biciklizes bringa2 = new Biciklizes(1L, LocalDate.of(2026, 5, 20), 15.5, 45, "Teszt", null);

        assertEquals(bringa1, bringa2);
        assertEquals(bringa1.hashCode(), bringa2.hashCode());

        assertNotNull(bringa1.toString());
    }
}