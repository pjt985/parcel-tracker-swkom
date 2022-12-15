package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoCoordinateMapperTest {

    @Test
    void dtoToEntiyTest() {
        GeoCoordinate geoCoordinate = new GeoCoordinate();

        geoCoordinate.setLat(10.0);
        geoCoordinate.setLon(25.0);

        GeoCoordinateEntity geoCoordinateEntity = GeoCoordinateMapper.INSTANCE.dtoToEntity(geoCoordinate);

        assertEquals(geoCoordinate.getLat(), geoCoordinateEntity.getLat());
        assertEquals(geoCoordinate.getLon(), geoCoordinateEntity.getLon());
    }


    @Test
    void entityToDtoTest() {
        GeoCoordinateEntity geoCoordinateEntity = new GeoCoordinateEntity();

        geoCoordinateEntity.setLat(10.0);
        geoCoordinateEntity.setLon(25.0);

        GeoCoordinate geoCoordinate = GeoCoordinateMapper.INSTANCE.entityToDto(geoCoordinateEntity);

        assertEquals(geoCoordinate.getLat(), geoCoordinateEntity.getLat());
        assertEquals(geoCoordinate.getLon(), geoCoordinateEntity.getLon());
    }
}
