package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.services.dto.Truck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TruckMapperTest {

    @Test
    void dtoToEntityTest() {
        Truck truck = new Truck();

        truck.setNumberPlate("W12345A");
        truck.setRegionGeoJson("RegionGeoJson");

        TruckEntity truckEntity = TruckMapper.INSTANCE.dtoToEntity(truck);

        assertEquals(truck.getNumberPlate(), truckEntity.getNumberPlate());
        assertEquals(truck.getRegionGeoJson(), truckEntity.getRegionGeoJson());
    }


    @Test
    void entityToDtoTest() {
        TruckEntity truckEntity = new TruckEntity();

        truckEntity.setNumberPlate("W12345A");
        truckEntity.setRegionGeoJson("RegionGeoJson");

        Truck truck = TruckMapper.INSTANCE.entityToDto(truckEntity);

        assertEquals(truck.getNumberPlate(), truckEntity.getNumberPlate());
        assertEquals(truck.getRegionGeoJson(), truckEntity.getRegionGeoJson());
    }
}
