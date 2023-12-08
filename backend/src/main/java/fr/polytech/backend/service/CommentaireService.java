package fr.polytech.backend.service;

import fr.polytech.backend.dto.request.AddCommentaireDto;
import fr.polytech.backend.entity.CommentaireEntity;
import fr.polytech.backend.entity.LivreEntity;
import fr.polytech.backend.repository.CommentaireRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentaireService {

    private final CommentaireRepository commentaireRepository;
    private final LivreService livreService;

    public CommentaireEntity addCommentaireToLivre(final Integer livreId, final AddCommentaireDto dto) {
        final LivreEntity livre = this.livreService.getLivreById(livreId);

        final CommentaireEntity commentaire = CommentaireEntity.builder().texte(dto.getTexte()).livre(livre).build();

        return this.commentaireRepository.save(commentaire);
    }

}
