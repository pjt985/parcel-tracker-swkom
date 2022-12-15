package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.gps.OpenStreetMapsProxy;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.*;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import at.fhtw.swen3.services.validation.Validator;
import com.mifmif.common.regex.Generex;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateError;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ParcelServiceImpl implements ParcelService {

    private final RecipientRepository recipientRepository;
    private final ParcelRepository parcelRepository;
    private final Validator validator;


    @Override
    public Optional<NewParcelInfo> submit(Parcel parcel) throws ConstraintViolationException, IOException, InterruptedException {
        Generex trackingRegex = new Generex("[A-Z0-9]{9}");
        Random r = new Random();

        //ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(parcel);
        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToParcelEntity(parcel);
        RecipientEntity recipient = parcelEntity.getRecipient();
        RecipientEntity sender = parcelEntity.getSender();
        parcelEntity.setVisitedHops(new ArrayList<>());
        parcelEntity.setFutureHops(new ArrayList<>());
        parcelEntity.setState(TrackingInformation.StateEnum.PICKUP);

        String trackingId = trackingRegex.getMatchedString(r.nextInt(Integer.MAX_VALUE));
        parcelEntity.setTrackingId(trackingId);

        String recipientAddr = recipient.getStreet() + "," + recipient.getPostalCode() + " " + recipient.getCity() + "," + recipient.getCountry();
        String senderAddr = sender.getStreet() + "," + sender.getPostalCode() + " " + sender.getCity() + "," + sender.getCountry();

        OpenStreetMapsProxy osmp = new OpenStreetMapsProxy();
        GeoCoordinate geoRecipient = osmp.encodeAddress(recipientAddr);
        GeoCoordinate geoSender = osmp.encodeAddress(senderAddr);

        try {
            validator.validate(parcelEntity.getSender());
            validator.validate(parcelEntity.getRecipient());
            validator.validate(parcelEntity);
        } catch (HibernateError e) {
            log.warn("Parcel could not be submitted");
            return Optional.empty();
        }

        parcelRepository.save(parcelEntity);
        log.info("Parcel successfully submitted");

        NewParcelInfo newParcelInfo = ParcelMapper.INSTANCE.entityToNewParcelInfoDto(parcelEntity);

        return Optional.of(newParcelInfo);
    }


    @Override
    public Optional<Parcel> update(String trackingId, TrackingInformation.StateEnum state) {
        ParcelEntity parcelEntity = parcelRepository.getByTrackingId(trackingId);

        if(parcelEntity == null) {
            log.info("No parcel found with tracking ID " + trackingId);
            return Optional.empty();
        }

        parcelEntity.setState(state);
        parcelRepository.save(parcelEntity);
        log.info("Parcel with tracking ID " + trackingId + " was successfully updated");

        return Optional.of(ParcelMapper.INSTANCE.entityToDto(parcelEntity));
    }


    @Override
    public void reportParcelHop() {}


    @Override
    public void transitionParcel(String trackingId, Parcel parcel) throws InterruptedException, IOException {
        //ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(parcel);
        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToParcelEntity(parcel);
        parcelEntity.setTrackingId(trackingId);
        RecipientEntity recipient = parcelEntity.getRecipient();
        RecipientEntity sender = parcelEntity.getSender();
        parcelEntity.setVisitedHops(new ArrayList<>());
        parcelEntity.setFutureHops(new ArrayList<>());
        parcelEntity.setState(TrackingInformation.StateEnum.PICKUP);

        String recipientAddr = recipient.getStreet() + "," + recipient.getPostalCode() + " " + recipient.getCity() + "," + recipient.getCountry();
        String senderAddr = sender.getStreet() + "," + sender.getPostalCode() + " " + sender.getCity() + "," + sender.getCountry();

        OpenStreetMapsProxy osmp = new OpenStreetMapsProxy();
        GeoCoordinate geoRecipient = osmp.encodeAddress(recipientAddr);
        GeoCoordinate geoSender = osmp.encodeAddress(senderAddr);

        try {
            validator.validate(parcelEntity.getSender());
            validator.validate(parcelEntity.getRecipient());
            validator.validate(parcelEntity);
        } catch (HibernateError e) {
            log.warn("Parcel could not be transitioned");
        }

        parcelRepository.save(parcelEntity);
        log.info("Parcel transitioned");
    }


    @Override
    public Optional<TrackingInformation> getTrackingInformation(String trackingId) {
        ParcelEntity parcelEntity = parcelRepository.getByTrackingId(trackingId);

        if(parcelEntity == null) {
            log.info("No parcel with tracking ID " + trackingId + " found");
            return Optional.empty();
        }

        log.info("Parcel found");
        TrackingInformation trackingInformation = ParcelMapper.INSTANCE.entityToTrackingInformationDto(parcelEntity);
        return Optional.of(trackingInformation);
    }
}
