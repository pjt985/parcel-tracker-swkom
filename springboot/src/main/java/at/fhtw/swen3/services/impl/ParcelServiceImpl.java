package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import at.fhtw.swen3.services.mapper.ParcelMapperImpl;
import at.fhtw.swen3.services.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class ParcelServiceImpl implements ParcelService {

    private final RecipientRepository recipientRepository;
    private final ParcelRepository parcelRepository;
    private final Validator validator;

    private ParcelMapperImpl mapper;

    public ParcelServiceImpl(RecipientRepository recipientRepository, ParcelRepository parcelRepository, Validator validator) {
        this.recipientRepository = recipientRepository;
        this.parcelRepository = parcelRepository;
        this.validator = validator;
    }

    @Override
    public void submit(ParcelEntity parcelEntity) {
        this.validator.validate(parcelEntity);
        this.recipientRepository.save(parcelEntity.getSender());
        this.recipientRepository.save(parcelEntity.getRecipient());
        this.parcelRepository.save(parcelEntity);
    }

    @Override
    public void update(String id, ParcelEntity parcelEntity) {
        this.parcelRepository.save(parcelEntity);
    }

    @Override
    public void delete(String id) {
        this.parcelRepository.deleteById(Long.parseLong(id));
    }

    @Override
    public List<Parcel> getAllParcels() {
        List<Parcel> dtos = new ArrayList<>();
        this.parcelRepository.findAll().forEach( entity -> dtos.add(ParcelMapper.INSTANCE.entityToDto(entity)));
        return dtos;
    }
}
