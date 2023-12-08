package fr.polytech.backend.controller;

import fr.polytech.backend.dto.request.AddRestoDto;
import fr.polytech.backend.dto.response.RestoDto;
import fr.polytech.backend.dto.response.UrlDto;
import fr.polytech.backend.service.RestoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class RestoController {

    private final RestoService restoService;

    @GetMapping("/restaurants")
    public List<RestoDto> getRestos(@RequestParam(value = "id", required = false) ArrayList<Integer> idsToFetch) {
        if (idsToFetch == null || idsToFetch.isEmpty()) {
            return this.restoService.getRestos().stream().map(RestoDto::buildFromEntity).toList();
        } else {
            return this.restoService.getRestos(idsToFetch).stream().map(RestoDto::buildFromEntity).toList();
        }
    }

    @GetMapping("/restaurants/{id}")
    public RestoDto getRestoById(@PathVariable Integer id) {
        return RestoDto.buildFromEntity(this.restoService.getRestoById(id));
    }

    @GetMapping("/restaurants/{id}/photo")
    public UrlDto getRestoPhotoById(@PathVariable Integer id) {
        return UrlDto.builder().url(this.restoService.getPhotoDownloadUrl(id)).build();
    }

    @PutMapping("/restaurants/{id}/photo")
    public UrlDto putRestoPhotoById(@PathVariable Integer id) {
        return UrlDto.builder().url(this.restoService.putPhotoDownloadUrl(id)).build();
    }

    @PostMapping("/restaurant")
    public RestoDto addResto(@Valid @RequestBody AddRestoDto restoDto) {
        return RestoDto.buildFromEntity(this.restoService.addResto(restoDto));
    }

    @PutMapping("/restaurants/{id}")
    public RestoDto editResto(@PathVariable Integer id, @Valid @RequestBody AddRestoDto restoDto) throws Exception {
        return RestoDto.buildFromEntity(this.restoService.editResto(id, restoDto));
    }

    @DeleteMapping("/restaurants/{id}")
    public void deleteResto(@PathVariable Integer id) {
        this.restoService.deleteResto(id);
    }

}
