package hu.nye.progkor.bringanaplo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BiciklizesController {

    private final BiciklizesService biciklizesService;

    public BiciklizesController(BiciklizesService biciklizesService) {
        this.biciklizesService = biciklizesService;
    }

    @GetMapping("/bringak")
    public String listaz(Model model) {
        model.addAttribute("biciklizesek", biciklizesService.osszesBiciklizes());
        return "lista";
    }

    @PostMapping("/mentes")
    public String mentes(@ModelAttribute Biciklizes ujBiciklizes) {
        biciklizesService.mentese(ujBiciklizes);
        return "redirect:/bringak";
    }

    // Szerkesztő oldal megnyitása
    @GetMapping("/szerkesztes/{id}")
    public String szerkesztesForm(@PathVariable Long id, Model model) {
        model.addAttribute("biciklizes", biciklizesService.getById(id));
        return "szerkesztes";
    }

    // Módosított adatok mentése
    @PostMapping("/frissites")
    public String frissites(@ModelAttribute Biciklizes biciklizes) {
        biciklizesService.frissites(biciklizes);
        return "redirect:/bringak";
    }

    @GetMapping("/torles/{id}")
    public String torles(@PathVariable Long id) {
        biciklizesService.torles(id);
        return "redirect:/bringak";
    }
}