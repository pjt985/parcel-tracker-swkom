package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.Recipient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class RecipientMapperTest {

    @Test
    void dtoToEntityTest() {
        Recipient recipient = new Recipient();
        recipient.setName("Max Mustermann");
        recipient.setStreet("Landstraße 2a");
        recipient.setPostalCode("A-1220");
        recipient.setCity("Wien");
        recipient.setCountry("Österreich");

        RecipientEntity recipientEntity = RecipientMapper.INSTANCE.dtoToEntity(recipient);

        assertEquals(recipient.getName(), recipientEntity.getName());
        assertEquals(recipient.getStreet(), recipientEntity.getStreet());
        assertEquals(recipient.getPostalCode(), recipientEntity.getPostalCode());
        assertEquals(recipient.getCity(), recipientEntity.getCity());
        assertEquals(recipient.getCountry(), recipientEntity.getCountry());
    }


    @Test
    void entityToDtoTest() {
        RecipientEntity recipientEntity = new RecipientEntity();
        recipientEntity.setName("Max Mustermann");
        recipientEntity.setStreet("Landstraße 2a");
        recipientEntity.setPostalCode("A-1220");
        recipientEntity.setCity("Wien");
        recipientEntity.setCountry("Österreich");

        Recipient recipient = RecipientMapper.INSTANCE.entityToDto(recipientEntity);

        assertEquals(recipient.getName(), recipientEntity.getName());
        assertEquals(recipient.getStreet(), recipientEntity.getStreet());
        assertEquals(recipient.getPostalCode(), recipientEntity.getPostalCode());
        assertEquals(recipient.getCity(), recipientEntity.getCity());
        assertEquals(recipient.getCountry(), recipientEntity.getCountry());
    }
}
