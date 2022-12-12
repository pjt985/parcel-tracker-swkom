package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.mapper.WarehouseMapper;
import at.fhtw.swen3.services.validation.Validator;

import java.util.ArrayList;
import java.util.List;

public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final Validator validator;

    public WarehouseServiceImpl(WarehouseRepository warehouseRepository, Validator validator) {
        this.warehouseRepository = warehouseRepository;
        this.validator = validator;
    }

    @Override
    public List<Warehouse> getAllWarehouse() {
        List<Warehouse> dtos = new ArrayList<>();
        this.warehouseRepository.findAll().forEach(entity -> dtos.add(WarehouseMapper.INSTANCE.entityToDto(entity)));
        return dtos;
    }
}
