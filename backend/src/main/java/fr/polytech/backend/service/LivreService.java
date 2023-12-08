package fr.polytech.backend.service;

import fr.polytech.backend.dto.request.AddLivreDto;
import fr.polytech.backend.entity.LivreEntity;
import fr.polytech.backend.exception.InvalidValueException;
import fr.polytech.backend.exception.ResourceNotFoundException;
import fr.polytech.backend.repository.LivreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LivreService {

    private final LivreRepository livreRepository;

    private final S3Service s3Service;

    public List<LivreEntity> getLivres() {
        return this.livreRepository.findAll();
    }

    public List<LivreEntity> getLivres(final List<Integer> idsToFetch) {
        return this.livreRepository.findAllById(idsToFetch);
    }

    public LivreEntity getLivreById(final Integer id) {
        return this.livreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Livre with id " + id + " + not found"));
    }

    public LivreEntity addLivre(final AddLivreDto livreDto) {
        final LivreEntity livreToInsert = LivreEntity.builder().titre(livreDto.getTitre()).build();

        return this.livreRepository.save(livreToInsert);
    }

    public void deleteLivre(final Integer id) {
        this.livreRepository.deleteById(id);
    }

    public LivreEntity updateLivre(int id, String nouveauNom) {
        if (nouveauNom == null) {
            throw new InvalidValueException("le nouveau nom ne doit pas être null");
        }
        final LivreEntity livreToUpdate = this.livreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("le livre d'id " + id + " n'existe pas"));
        livreToUpdate.setTitre(nouveauNom);
        livreRepository.save(livreToUpdate);
        return livreToUpdate;
    }

    public String getCoverDownloadUrl(final Integer livreId) {
        this.getLivreById(livreId);

        return this.s3Service.getDownloadUrl("TOTO_" + livreId);
    }

    public String putCoverDownloadUrl(final Integer livreId) {
        this.getLivreById(livreId);

        return this.s3Service.putDownloadUrl("TOTO_" + livreId);
    }

}
