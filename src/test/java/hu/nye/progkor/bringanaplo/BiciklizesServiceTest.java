package hu.nye.progkor.bringanaplo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class BiciklizesServiceTest {

    @Mock
    private BiciklizesRepository repository;

    private BiciklizesService underTest;

    @BeforeEach
    void setUp() {
        underTest = new BiciklizesService(repository);
    }

    @Test
    void testOsszesBiciklizesShouldReturnList() {
        // Given
        when(repository.findAll()).thenReturn(List.of(new Biciklizes(1L, LocalDate.now(), 10.0, 30, "Teszt", null)));
        // When
        List<Biciklizes> result = underTest.osszesBiciklizes();
        // Then
        assertEquals(1, result.size());
        verify(repository).findAll();
    }

    @Test
    void testMenteseShouldCallRepository() {
        // Given
        Biciklizes uj = new Biciklizes(null, LocalDate.now(), 10.0, 30, "Teszt", null);
        // When
        underTest.mentese(uj);
        // Then
        verify(repository).save(uj);
    }

    @Test
    void testTorlesShouldCallRepository() {
        // When
        underTest.torles(1L);
        // Then
        verify(repository).deleteById(1L);
    }

    @Test
    void testGetByIdShouldReturnCorrectItem() {
        // Given
        Biciklizes bringa = new Biciklizes(1L, LocalDate.now(), 10.0, 30, "Teszt", null);
        when(repository.findById(1L)).thenReturn(Optional.of(bringa));
        // When
        Biciklizes result = underTest.getById(1L);
        // Then
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void testFrissitesShouldCallRepository() {
        Biciklizes bringa = new Biciklizes(1L, LocalDate.now(), 10.0, 30, "Modositott", null);

        underTest.frissites(bringa);

        verify(repository).save(bringa);
    }
}