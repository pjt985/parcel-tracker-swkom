package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.Warehouse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarehouseMapperTest {

    @Test
    void dtoToEntityTest() {
        Warehouse warehouse = new Warehouse();

        warehouse.setLevel(1);
        warehouse.setNextHops(new ArrayList<>());

        WarehouseEntity warehouseEntity = WarehouseMapper.INSTANCE.dtoToEntity(warehouse);

        assertEquals(warehouse.getLevel(), warehouseEntity.getLevel());
        assertEquals(warehouse.getNextHops(), warehouseEntity.getNextHops());
    }


    @Test
    void entityToDtoTest() {
        WarehouseEntity warehouseEntity = new WarehouseEntity();

        warehouseEntity.setLevel(1);
        warehouseEntity.setNextHops(new ArrayList<>());

        Warehouse warehouse = WarehouseMapper.INSTANCE.entityToDto(warehouseEntity);

        assertEquals(warehouse.getLevel(), warehouseEntity.getLevel());
        assertEquals(warehouse.getNextHops(), warehouseEntity.getNextHops());
    }
}
