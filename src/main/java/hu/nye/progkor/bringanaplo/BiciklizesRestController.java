package hu.nye.progkor.bringanaplo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bringak")
public class BiciklizesRestController {

    private final BiciklizesService service;

    public BiciklizesRestController(BiciklizesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Biciklizes> getAll() {
        return service.osszesBiciklizes();
    }

    @PostMapping
    public Biciklizes create(@RequestBody Biciklizes biciklizes) {
        service.mentese(biciklizes);
        return biciklizes;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.torles(id);
    }
}