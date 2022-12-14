package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.mapper.WarehouseMapper;
import at.fhtw.swen3.services.validation.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final Validator validator;

    private WarehouseMapper mapper;

    public WarehouseServiceImpl(WarehouseRepository warehouseRepository, Validator validator) {
        this.warehouseRepository = warehouseRepository;
        this.validator = validator;
    }

    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
        this.validator = new Validator();
    }

    @Override
    public Optional<List<Warehouse>> getAllWarehouses() {
        List<Warehouse> dtos = new ArrayList<>();
        this.warehouseRepository.findAll().forEach(entity -> dtos.add(WarehouseMapper.INSTANCE.entityToDto(entity)));
        return Optional.of(dtos);
    }

    @Override
    public Optional<Warehouse> getWarehouse(String code) {
        return Optional.of(mapper.INSTANCE.entityToDto(warehouseRepository.getByCode(code).get(0)));
    }

    @Override
    public void submit(Warehouse warehouse) {
        warehouseRepository.save(mapper.INSTANCE.dtoToEntity(warehouse));
    }
}
