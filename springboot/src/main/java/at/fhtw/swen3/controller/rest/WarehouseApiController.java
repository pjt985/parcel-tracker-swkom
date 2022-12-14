package at.fhtw.swen3.controller.rest;

import at.fhtw.swen3.controller.WarehouseApi;


import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Warehouse;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import javax.validation.Valid;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-11T21:56:32.948147Z[Etc/UTC]")
@Controller
@Slf4j
public class WarehouseApiController implements WarehouseApi {

    @Autowired
    private final NativeWebRequest request;

    @Autowired
    private final WarehouseService warehouseService;

    @Autowired
    public WarehouseApiController(NativeWebRequest request, WarehouseService warehouseService) {
        this.request = request;
        this.warehouseService = warehouseService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }


    @Override
    public ResponseEntity<Warehouse> getWarehouse(String code) {
        Optional<Warehouse> responseWarehouse = warehouseService.getWarehouse(code);
        if(!responseWarehouse.isPresent()) {
            log.info("getWarehouse() -> warehouse with code "+ code+" is NOT present");
            return new ResponseEntity<>(HttpStatus.OK);
        }
        log.info("getWarehouse() -> warehouse with code "+ code+" is present");
        return new ResponseEntity<>(responseWarehouse.get(), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Warehouse> exportWarehouses() {
        Optional<List<Warehouse>> responseWarehouses = warehouseService.getAllWarehouses();

        if(responseWarehouses.get().isEmpty()){
            log.info("exportWarehouses() -> there are no warehouses to responde with [empty]");
            return new ResponseEntity<>(HttpStatus.OK);
        }

        if(!responseWarehouses.isPresent()){
            log.info("exportWarehouses() -> there are not warehouses present [sad]");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        log.info("exportWarehouses() -> there are warehouses to responde with [not empty]");
        return new ResponseEntity<>(responseWarehouses.get().get(0), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Void> importWarehouses(Warehouse warehouse) {
        warehouseService.submit(warehouse);
        log.info("Warehouse was succesfully imported :)");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
