package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.Parcel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

@SpringBootTest
public class ParcelRepositoryTest {

    @Autowired
    ParcelRepository parcelRepository;

    @Autowired
    RecipientRepository recipientRepository;


    @BeforeEach
    void init() {
        parcelRepository.deleteAll();
        recipientRepository.deleteAll();
    }


    @Test
    void saveParcelTest() {
        RecipientEntity recipientEntity = new RecipientEntity();
        recipientEntity.setName("Max Mustermann");
        recipientEntity.setStreet("Landstraße 2a");
        recipientEntity.setPostalCode("A-1220");
        recipientEntity.setCity("Wien");
        recipientEntity.setCountry("Österreich");

        ParcelEntity parcelEntity = new ParcelEntity();
        parcelEntity.setTrackingId("PYJRB4HZ6");
        parcelEntity.setWeight(12.0f);
        parcelEntity.setFutureHops(new ArrayList<>());
        parcelEntity.setVisitedHops(new ArrayList<>());
        parcelEntity.setRecipient(recipientEntity);
        parcelEntity.setSender(recipientEntity);

        parcelRepository.save(parcelEntity);

        assertEquals(1, parcelRepository.count());
    }
}
