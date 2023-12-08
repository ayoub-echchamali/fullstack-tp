package fr.polytech.backend.service;

import fr.polytech.backend.entity.RestoEntity;
import fr.polytech.backend.exception.InvalidValueException;
import fr.polytech.backend.exception.ResourceNotFoundException;
import fr.polytech.backend.repository.RestoRepository;
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
public class RestoServiceTest {

    @Mock
    private RestoRepository livreRepository;

    @InjectMocks
    private RestoService livreService;

    @Test
    public void update_livre_with_null_name() {
        assertThrows(InvalidValueException.class, () -> this.livreService.updateResto(0, null));
    }

    @Test
    public void update_livre_with_non_existing_livre() {
        assertThrows(ResourceNotFoundException.class, () -> this.livreService.updateResto(0, "toto"));
    }

    @Test
    public void update_livre_ok() {
        when(this.livreRepository.findById(anyInt())).thenReturn(Optional.of(RestoEntity.builder().build()));
        final RestoEntity result = this.livreService.updateResto(123, "toto");

        assertEquals("toto", result.getName());
    }

}
