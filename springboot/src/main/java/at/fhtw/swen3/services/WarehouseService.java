package at.fhtw.swen3.services;

import at.fhtw.swen3.services.dto.Warehouse;

import java.util.List;
import java.util.Optional;

public interface WarehouseService {
    public Optional<List<Warehouse>> getAllWarehouses();
    public Optional<Warehouse> getWarehouse(String code);

    public void submit(Warehouse warehouse);
}
