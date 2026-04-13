package hu.nye.progkor.bringanaplo;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BiciklizesService {

    // Ebben a listában tároljuk az adatokat a gép memóriájában
    private final List<Biciklizes> lista = new ArrayList<>();

    public BiciklizesService() {
        // Alapértelmezett teszt adat, hogy ne legyen üres az oldal induláskor
        lista.add(new Biciklizes(1L, java.time.LocalDate.now(), 15.5, 45, "Szuper idő volt!"));
    }

    // Visszaadja az összes rögzített biciklizést
    public List<Biciklizes> osszesBiciklizes() {
        return lista;
    }

    // Új biciklizés elmentése a listához
    public void mentese(Biciklizes biciklizes) {
        // Generálunk neki egy egyszerű ID-t az idő alapján, hogy tudjuk törölni
        if (biciklizes.getId() == null) {
            biciklizes.setId(System.currentTimeMillis());
        }
        lista.add(biciklizes);
    }

    // Törlés azonosító (ID) alapján
    public void torles(Long id) {
        lista.removeIf(biciklizes -> biciklizes.getId().equals(id));
    }
}