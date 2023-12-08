package fr.polytech.backend.service;

import fr.polytech.backend.entity.LivreEntity;
import fr.polytech.backend.exception.InvalidValueException;
import fr.polytech.backend.exception.ResourceNotFoundException;
import fr.polytech.backend.repository.LivreRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LivreServiceTest {

    @Mock
    private LivreRepository livreRepository;

    @InjectMocks
    private LivreService livreService;

    @Test
    public void update_livre_with_null_name() {
        assertThrows(InvalidValueException.class, () -> this.livreService.updateLivre(0, null));
    }

    @Test
    public void update_livre_with_non_existing_livre() {
        assertThrows(ResourceNotFoundException.class, () -> this.livreService.updateLivre(0, "toto"));
    }

    @Test
    public void update_livre_ok() {
        when(this.livreRepository.findById(anyInt())).thenReturn(Optional.of(LivreEntity.builder().build()));
        final LivreEntity result = this.livreService.updateLivre(123, "toto");

        assertEquals("toto", result.getTitre());
    }

}
