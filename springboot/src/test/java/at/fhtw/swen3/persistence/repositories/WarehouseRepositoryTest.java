package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WarehouseRepositoryTest {

    @Autowired
    WarehouseRepository warehouseRepository;


    @Test
    void saveWarehouseTest() {
        WarehouseEntity warehouseEntity = new WarehouseEntity();

        warehouseEntity.setLevel(1);
        warehouseEntity.setNextHops(new ArrayList<>());

        warehouseRepository.save(warehouseEntity);
        assertEquals(1, warehouseRepository.count());
    }
}
