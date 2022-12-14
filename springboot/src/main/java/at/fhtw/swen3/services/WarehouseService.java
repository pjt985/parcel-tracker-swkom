package at.fhtw.swen3.services;

import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.validation.Validator;

import java.util.List;
import java.util.Optional;

public interface WarehouseService {

    public void submit(Warehouse warehouse);

    public Optional<List<Warehouse>> getAllWarehouses();

    public Optional<Warehouse> getWarehouse(String code);
}
