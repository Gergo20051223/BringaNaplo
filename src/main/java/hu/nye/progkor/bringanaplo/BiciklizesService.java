package hu.nye.progkor.bringanaplo;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BiciklizesService {

    private final List<Biciklizes> lista = new ArrayList<>();

    public BiciklizesService() {
        lista.add(new Biciklizes(1L, java.time.LocalDate.now(), 15.5, 45, "Szuper idő volt!"));
    }

    public List<Biciklizes> osszesBiciklizes() {
        return lista;
    }

    public void mentese(Biciklizes biciklizes) {
        if (biciklizes.getId() == null) {
            biciklizes.setId(System.currentTimeMillis());
        }
        lista.add(biciklizes);
    }

    // Megkeres egy konkrét bringázást az ID alapján (ez kell a szerkesztéshez)
    public Biciklizes getById(Long id) {
        return lista.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Frissíti a meglévő adatokat
    public void frissites(Biciklizes frissitett) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId().equals(frissitett.getId())) {
                lista.set(i, frissitett);
                break;
            }
        }
    }

    public void torles(Long id) {
        lista.removeIf(b -> b.getId().equals(id));
    }
}