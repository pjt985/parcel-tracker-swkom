package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WarehouseRepositoryTest {
//
//    @Autowired
//    WarehouseRepository repository;
//
//    @Test
//    void warehouseRepositoryTest(){
//        WarehouseEntity warehouseEntity = new WarehouseEntity( 200, new ArrayList<WarehouseNextHopsEntity>());
//
//        repository.save(warehouseEntity);
//        assertEquals(1, repository.count());
//
//        List<WarehouseEntity> results = repository.findByLevel(200);
//        assertEquals(1, results.size());
//    }


}