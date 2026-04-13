package hu.nye.progkor.bringanaplo;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BiciklizesService {

    private final List<Biciklizes> lista = new ArrayList<>();

    public BiciklizesService() {
        // Teszt adat
        lista.add(new Biciklizes(1L, java.time.LocalDate.now(), 15.5, 45, "Szuper idő volt!"));
    }

    public List<Biciklizes> osszesBiciklizes() {
        return lista;
    }

    public void mentese(Biciklizes biciklizes) {
        lista.add(biciklizes);
    }
}