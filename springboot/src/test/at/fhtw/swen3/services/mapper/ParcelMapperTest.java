package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParcelMapperTest {

    @Test
    void dtoToEntityTest() {
        Parcel parcel = new Parcel();

        Recipient recipient = new Recipient();
        recipient.setName("Max Mustermann");
        recipient.setStreet("Landstraße 2a");
        recipient.setPostalCode("A-1220");
        recipient.setCity("Wien");
        recipient.setCountry("Österreich");

        Recipient sender = new Recipient();
        sender.setName("Martina Musterfrau");
        sender.setStreet("Mariahilfer Straße 120");
        sender.setPostalCode("A-1070");
        sender.setCity("Wien");
        sender.setCountry("Österreich");

        parcel.setRecipient(recipient);
        parcel.setSender(sender);
        parcel.setWeight(12.0f);

        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(parcel);

        assertEquals(parcel.getRecipient().getName(), parcelEntity.getRecipient().getName());
        assertEquals(parcel.getRecipient().getStreet(), parcelEntity.getRecipient().getStreet());
        assertEquals(parcel.getRecipient().getPostalCode(), parcelEntity.getRecipient().getPostalCode());
        assertEquals(parcel.getRecipient().getCity(), parcelEntity.getRecipient().getCity());
        assertEquals(parcel.getRecipient().getCountry(), parcelEntity.getRecipient().getCountry());
        assertEquals(parcel.getSender().getCountry(), parcelEntity.getSender().getCountry());
        assertEquals(parcel.getSender().getStreet(), parcelEntity.getSender().getStreet());
        assertEquals(parcel.getSender().getPostalCode(), parcelEntity.getSender().getPostalCode());
        assertEquals(parcel.getSender().getCity(), parcelEntity.getSender().getCity());
        assertEquals(parcel.getSender().getCountry(), parcelEntity.getSender().getCountry());
        assertEquals(parcel.getWeight(), parcelEntity.getWeight());
    }


    @Test
    void entityToDtoTest() {
        ParcelEntity parcelEntity = new ParcelEntity();

        RecipientEntity recipientEntity = new RecipientEntity();
        recipientEntity.setName("Max Mustermann");
        recipientEntity.setStreet("Landstraße 2a");
        recipientEntity.setPostalCode("A-1220");
        recipientEntity.setCity("Wien");
        recipientEntity.setCountry("Österreich");

        RecipientEntity senderEntity = new RecipientEntity();
        senderEntity.setName("Martina Musterfrau");
        senderEntity.setStreet("Mariahilfer Straße 120");
        senderEntity.setPostalCode("A-1070");
        senderEntity.setCity("Wien");
        senderEntity.setCountry("Österreich");

        parcelEntity.setRecipient(recipientEntity);
        parcelEntity.setSender(senderEntity);
        parcelEntity.setWeight(12.0f);
        parcelEntity.setFutureHops(new ArrayList<>());
        parcelEntity.setVisitedHops(new ArrayList<>());
        parcelEntity.setTrackingId("PYJRB4HZ6");

        Parcel parcel = ParcelMapper.INSTANCE.entityToDto(parcelEntity);

        assertEquals(parcel.getRecipient().getName(), parcelEntity.getRecipient().getName());
        assertEquals(parcel.getRecipient().getStreet(), parcelEntity.getRecipient().getStreet());
        assertEquals(parcel.getRecipient().getPostalCode(), parcelEntity.getRecipient().getPostalCode());
        assertEquals(parcel.getRecipient().getCity(), parcelEntity.getRecipient().getCity());
        assertEquals(parcel.getRecipient().getCountry(), parcelEntity.getRecipient().getCountry());
        assertEquals(parcel.getSender().getCountry(), parcelEntity.getSender().getCountry());
        assertEquals(parcel.getSender().getStreet(), parcelEntity.getSender().getStreet());
        assertEquals(parcel.getSender().getPostalCode(), parcelEntity.getSender().getPostalCode());
        assertEquals(parcel.getSender().getCity(), parcelEntity.getSender().getCity());
        assertEquals(parcel.getSender().getCountry(), parcelEntity.getSender().getCountry());
        assertEquals(parcel.getWeight(), parcelEntity.getWeight());
    }
}
