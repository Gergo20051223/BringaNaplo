package hu.nye.progkor.bringanaplo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class BiciklizesServiceTest {

    private BiciklizesService underTest;

    @BeforeEach
    void setUp() {
        underTest = new BiciklizesService();
    }

    @Test
    void testOsszesBiciklizesShouldReturnInitialList() {
        assertEquals(1, underTest.osszesBiciklizes().size());
    }

    @Test
    void testMenteseShouldAddNote() {
        Biciklizes uj = new Biciklizes(null, LocalDate.now(), 10.0, 30, "Teszt");
        underTest.mentese(uj);
        assertEquals(2, underTest.osszesBiciklizes().size());
    }

    @Test
    void testTorlesShouldRemoveItem() {
        Long id = underTest.osszesBiciklizes().get(0).getId();
        underTest.torles(id);
        assertTrue(underTest.osszesBiciklizes().isEmpty());
    }

    @Test
    void testGetByIdShouldReturnCorrectItem() {
        Long id = underTest.osszesBiciklizes().get(0).getId();
        Biciklizes found = underTest.getById(id);
        assertNotNull(found);
        assertEquals(id, found.getId());
    }

    @Test
    void testFrissitesShouldModifyItem() {
        Biciklizes bringa = underTest.osszesBiciklizes().get(0);
        bringa.setMegjegyzes("Modositva");
        underTest.frissites(bringa);
        assertEquals("Modositva", underTest.getById(bringa.getId()).getMegjegyzes());
    }
}