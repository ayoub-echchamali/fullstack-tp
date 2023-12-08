package fr.polytech.backend.controller;

import fr.polytech.backend.dto.request.AddLivreDto;
import fr.polytech.backend.dto.response.LivreDto;
import fr.polytech.backend.dto.response.UrlDto;
import fr.polytech.backend.service.LivreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class LivreController {

    private final LivreService livreService;

    @GetMapping("/livres")
    public List<LivreDto> getLivres(@RequestParam(value = "id", required = false) ArrayList<Integer> idsToFetch) {
        if (idsToFetch == null || idsToFetch.isEmpty()) {
            return this.livreService.getLivres().stream().map(LivreDto::buildFromEntity).toList();
        } else {
            return this.livreService.getLivres(idsToFetch).stream().map(LivreDto::buildFromEntity).toList();
        }
    }

    @GetMapping("/livres/{id}")
    public LivreDto getLivreById(@PathVariable Integer id) {
        return LivreDto.buildFromEntity(this.livreService.getLivreById(id));
    }

    @GetMapping("/livres/{id}/cover")
    public UrlDto getLivreCoverById(@PathVariable Integer id) {
        return UrlDto.builder().url(this.livreService.getCoverDownloadUrl(id)).build();
    }

    @PutMapping("/livres/{id}/cover")
    public UrlDto putLivreCoverById(@PathVariable Integer id) {
        return UrlDto.builder().url(this.livreService.putCoverDownloadUrl(id)).build();
    }

    @PostMapping("/livres")
    public LivreDto addLivre(@Valid @RequestBody AddLivreDto livreDto) {
        return LivreDto.buildFromEntity(this.livreService.addLivre(livreDto));
    }

    @DeleteMapping("/livres/{id}")
    public void deleteLivre(@PathVariable Integer id) {
        this.livreService.deleteLivre(id);
    }

}
