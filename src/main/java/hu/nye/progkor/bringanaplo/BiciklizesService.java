package hu.nye.progkor.bringanaplo;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BiciklizesService {

    private final BiciklizesRepository repository;

    public BiciklizesService(BiciklizesRepository repository) {
        this.repository = repository;
    }

    public List<Biciklizes> osszesBiciklizes() {
        return repository.findAll();
    }

    public void mentese(Biciklizes biciklizes) {
        repository.save(biciklizes);
    }

    public Biciklizes getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Biciklizes frissites(Long id, Biciklizes ujAdatok) {
        Biciklizes regi = repository.findById(id).orElseThrow();
        regi.setDatum(ujAdatok.getDatum());
        regi.setTavolsagKm(ujAdatok.getTavolsagKm());
        regi.setIdotartamPerc(ujAdatok.getIdotartamPerc());
        regi.setMegjegyzes(ujAdatok.getMegjegyzes());
        return repository.save(regi);
    }

    public void torles(Long id) {
        repository.deleteById(id);
    }
}