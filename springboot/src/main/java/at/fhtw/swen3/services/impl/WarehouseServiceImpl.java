package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.mapper.WarehouseMapper;
import at.fhtw.swen3.services.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final Validator validator;
    private WarehouseMapper warehouseMapper;


    @Override
    public void submit(Warehouse warehouse) {
        WarehouseEntity warehouseEntity = WarehouseMapper.INSTANCE.dtoToEntity(warehouse);
        warehouseRepository.save(warehouseEntity);
    }


    @Override
    public Optional<List<Warehouse>> getAllWarehouses() {
        List<Warehouse> allWarehouses = new ArrayList<>();
        this.warehouseRepository.findAll().forEach(entity -> allWarehouses.add(WarehouseMapper.INSTANCE.entityToDto(entity)));
        return Optional.of(allWarehouses);
    }


    @Override
    public Optional<Warehouse> getWarehouse(String code) {
        List<WarehouseEntity> warehouseEntities = warehouseRepository.getByCode(code);

        if(warehouseEntities.isEmpty()) {
            log.info("No warehouse found with code " + code);
            return Optional.empty();
        }

        log.info("Warehouse with code " + code + " found");
        Warehouse warehouse = WarehouseMapper.INSTANCE.entityToDto(warehouseEntities.get(0));
        return Optional.of(warehouse);
    }
}
