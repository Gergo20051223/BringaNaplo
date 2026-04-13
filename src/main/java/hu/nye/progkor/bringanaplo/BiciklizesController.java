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

    // Kilistázza a bringázásokat a localhost:8080/bringak címen
    @GetMapping("/bringak")
    public String listaz(Model model) {
        model.addAttribute("biciklizesek", biciklizesService.osszesBiciklizes());
        return "lista";
    }

    // Kezeli az űrlapról érkező mentést
    @PostMapping("/mentes")
    public String mentes(@ModelAttribute Biciklizes ujBiciklizes) {
        biciklizesService.mentese(ujBiciklizes);
        return "redirect:/bringak";
    }

    // Kezeli a törlés gombra kattintást
    @GetMapping("/torles/{id}")
    public String torles(@PathVariable Long id) {
        biciklizesService.torles(id);
        return "redirect:/bringak";
    }
}