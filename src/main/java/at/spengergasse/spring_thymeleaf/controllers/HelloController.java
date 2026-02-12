package at.spengergasse.spring_thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class HelloController {

    @GetMapping("")
    public  String index(Model model) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        model.addAttribute("today", LocalDate.now().format(dtf));
        return "index";
    }
    // GetMapping("") -> wenn die Startseite aufgerufen wird, soll die Methode index() ausgeführt werden
        // Model -> damit können wir Daten an die View übergeben, damit sie dort angezeigt werden können
        // LocalDate.now() -> aktuelles Datum holen, formatieren und an das Model übergeben, damit es in der View angezeigt werden kann
        // index -> Name der View, die angezeigt werden soll (index.html)
}
