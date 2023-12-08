package fr.polytech.backend.service;

import fr.polytech.backend.dto.request.AddRestoDto;
import fr.polytech.backend.entity.RestoEntity;
import fr.polytech.backend.entity.enums.Tag;
import fr.polytech.backend.exception.InvalidValueException;
import fr.polytech.backend.exception.ResourceNotFoundException;
import fr.polytech.backend.repository.RestoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RestoService {

    private final RestoRepository restoRepository;

    private final S3Service s3Service;

    public List<RestoEntity> getRestos() {
        return this.restoRepository.findAll();
    }

    public List<RestoEntity> getRestos(final List<Integer> idsToFetch) {
        return this.restoRepository.findAllById(idsToFetch);
    }

    public RestoEntity getRestoById(final Integer id) {
        return this.restoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resto with ID " + id + " doesn't exist"));
    }

    public RestoEntity addResto(final AddRestoDto restoDto) {
        final RestoEntity restoToInsert = RestoEntity.builder().name(restoDto.getName()).address(restoDto.getAddress()).build();
        return this.restoRepository.save(restoToInsert);
    }

    public void deleteResto(final Integer id) {
        this.restoRepository.deleteById(id);
    }

    public RestoEntity editResto(int id, AddRestoDto restoDto) throws Exception {
        if (restoDto.getName() == null) {
            throw new InvalidValueException("New name cannot be null.");
        }
        final RestoEntity restoToUpdate = this.restoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resto with ID " + id + " doesn't exist"));
        restoToUpdate.setName(restoDto.getName());
        restoToUpdate.setAddress(restoDto.getAddress());
        if (Tag.codeExists(restoDto.getTag())){
            restoToUpdate.setTag(Tag.findByCode(restoDto.getTag()));
        }
        restoRepository.save(restoToUpdate);
        return restoToUpdate;
    }

    public String getPhotoDownloadUrl(final Integer restoId) {
        return this.s3Service.getDownloadUrlResto("resto_ayoub_" + restoId);
    }

    public String putPhotoDownloadUrl(final Integer restoId) {
        return this.s3Service.putDownloadUrlResto("resto_ayoub_" + restoId);
    }

}
