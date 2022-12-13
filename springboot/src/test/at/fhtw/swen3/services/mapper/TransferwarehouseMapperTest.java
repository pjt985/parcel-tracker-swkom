package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferwarehouseMapperTest {

    @Test
    void dtoToEntityTest() {
        Transferwarehouse transferwarehouse = new Transferwarehouse();

        transferwarehouse.setLogisticsPartner("LogisticsPartner");
        transferwarehouse.setRegionGeoJson("RegionGeoJson");
        transferwarehouse.setLogisticsPartnerUrl("LogisticsPartnerUrl");

        TransferwarehouseEntity transferwarehouseEntity = TransferwarehouseMapper.INSTANCE.dtoToEntity(transferwarehouse);

        assertEquals(transferwarehouse.getLogisticsPartner(), transferwarehouseEntity.getLogisticsPartner());
        assertEquals(transferwarehouse.getRegionGeoJson(), transferwarehouseEntity.getRegionGeoJson());
        assertEquals(transferwarehouse.getLogisticsPartnerUrl(), transferwarehouseEntity.getLogisticsPartnerUrl());
    }


    @Test
    void entityToDtoTest() {
        TransferwarehouseEntity transferwarehouseEntity = new TransferwarehouseEntity();

        transferwarehouseEntity.setLogisticsPartner("LogisticsPartner");
        transferwarehouseEntity.setRegionGeoJson("RegionGeoJson");
        transferwarehouseEntity.setLogisticsPartnerUrl("LogisticsPartnerUrl");

        Transferwarehouse transferwarehouse = TransferwarehouseMapper.INSTANCE.entityToDto(transferwarehouseEntity);

        assertEquals(transferwarehouse.getLogisticsPartner(), transferwarehouseEntity.getLogisticsPartner());
        assertEquals(transferwarehouse.getRegionGeoJson(), transferwarehouseEntity.getRegionGeoJson());
        assertEquals(transferwarehouse.getLogisticsPartnerUrl(), transferwarehouseEntity.getLogisticsPartnerUrl());
    }
}
