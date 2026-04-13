package hu.nye.progkor.bringanaplo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BiciklizesController {

    private final BiciklizesService biciklizesService;

    // Ez a rész köti össze a vezérlőt a szolgáltatással (Service)
    public BiciklizesController(BiciklizesService biciklizesService) {
        this.biciklizesService = biciklizesService;
    }

    // Ha beírod a böngészőbe: localhost:8080/bringak, ez fut le
    @GetMapping("/bringak")
    public String listaz(Model model) {
        // Átadjuk a listát a "biciklizesek" néven a HTML-nek
        model.addAttribute("biciklizesek", biciklizesService.osszesBiciklizes());
        // A templates/lista.html fájlt fogja megjeleníteni
        return "lista";
    }
}