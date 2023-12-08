package fr.polytech.backend.service;

import fr.polytech.backend.dto.request.AddBiblioDto;
import fr.polytech.backend.dto.response.BiblioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BiblioService {

    private final List<BiblioDto> biblios = new ArrayList<>();

    public List<BiblioDto> getAllBiblios() {
        return this.biblios;
    }

    public BiblioDto addBiblio(AddBiblioDto addBiblioDto) {
        final BiblioDto result = BiblioDto.builder().id(addBiblioDto.getId()).nom(addBiblioDto.getNom()).livres(new ArrayList<>()).build();
        this.biblios.add(result);

        return result;
    }

    public void removeDeChaqueBiblio(final Integer id) {
        this.biblios.forEach(biblioDto ->
                biblioDto.setLivres(
                        biblioDto.getLivres()
                                .stream()
                                .filter(livreDto -> !livreDto.getId().equals(id))
                                .toList())
        );

    }

}
