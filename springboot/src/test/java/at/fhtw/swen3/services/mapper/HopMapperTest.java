package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.services.dto.Hop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HopMapperTest {

    @Test
    void dtoToEntityTest() {
        Hop hop = new Hop();

        hop.setCode("PYJRB4HZ6");
        hop.setHopType("HopType");
        hop.setDescription("Description");
        hop.setLocationName("Warehouse 12-27");
        hop.setProcessingDelayMins(30);

        HopEntity hopEntity = HopMapper.INSTANCE.dtoToEntity(hop);

        assertEquals(hop.getCode(), hopEntity.getCode());
        assertEquals(hop.getHopType(), hopEntity.getHopType());
        assertEquals(hop.getDescription(), hopEntity.getDescription());
        assertEquals(hop.getLocationName(), hopEntity.getLocationName());
        assertEquals(hop.getProcessingDelayMins(), hopEntity.getProcessingDelayMins());
    }


    @Test
    void entityToDtoTest() {
        HopEntity hopEntity = new HopEntity();

        hopEntity.setCode("PYJRB4HZ6");
        hopEntity.setHopType("HopType");
        hopEntity.setDescription("Description");
        hopEntity.setLocationName("Warehouse 12-27");
        hopEntity.setProcessingDelayMins(30);

        Hop hop = HopMapper.INSTANCE.entityToDto(hopEntity);

        assertEquals(hop.getCode(), hopEntity.getCode());
        assertEquals(hop.getHopType(), hopEntity.getHopType());
        assertEquals(hop.getDescription(), hopEntity.getDescription());
        assertEquals(hop.getLocationName(), hopEntity.getLocationName());
        assertEquals(hop.getProcessingDelayMins(), hopEntity.getProcessingDelayMins());
    }
}
