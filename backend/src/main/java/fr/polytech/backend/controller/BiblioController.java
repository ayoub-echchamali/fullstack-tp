package fr.polytech.backend.controller;

import fr.polytech.backend.dto.request.AddBiblioDto;
import fr.polytech.backend.dto.response.BiblioDto;
import fr.polytech.backend.service.BiblioService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class BiblioController {

    private final BiblioService biblioService;

    public BiblioController(BiblioService biblioService) {
        this.biblioService = biblioService;
    }

    @GetMapping("/biblios")
    public List<BiblioDto> getBiblios() {
        return this.biblioService.getAllBiblios();
    }

    @PostMapping("/biblios")
    public BiblioDto addBibliotheque(@Valid @RequestBody AddBiblioDto biblioToCreate) {
        return this.biblioService.addBiblio(biblioToCreate);
    }

}
