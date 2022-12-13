package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WarehouseNextHopsMapperTest {

    @Test
    void dtoToEntityTest() {
        WarehouseNextHops warehouseNextHops = new WarehouseNextHops();

        warehouseNextHops.setHop(new Hop());
        warehouseNextHops.setTraveltimeMins(30);

        WarehouseNextHopsEntity warehouseNextHopsEntity = WarehouseNextHopsMapper.INSTANCE.dtoToEntity(warehouseNextHops);

        //assertNotNull(warehouseNextHopsEntity.getHopEntity());
        assertEquals(warehouseNextHops.getTraveltimeMins(), warehouseNextHopsEntity.getTraveltimeMins());
    }


    @Test
    void entityToDtoTest() {
        WarehouseNextHopsEntity warehouseNextHopsEntity = new WarehouseNextHopsEntity();

        warehouseNextHopsEntity.setHopEntity(new HopEntity());
        warehouseNextHopsEntity.setTraveltimeMins(30);

        WarehouseNextHops warehouseNextHops = WarehouseNextHopsMapper.INSTANCE.entityToDto(warehouseNextHopsEntity);

        //assertNotNull(warehouseNextHops.getHop());
        assertEquals(warehouseNextHops.getTraveltimeMins(), warehouseNextHopsEntity.getTraveltimeMins());
    }
}
