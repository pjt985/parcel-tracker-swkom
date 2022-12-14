package at.fhtw.swen3.gps.service;

import at.fhtw.swen3.services.dto.GeoCoordinate;

import java.io.IOException;

public interface GeoEncodingService {
    GeoCoordinate encodeAddress(String a) throws IOException, InterruptedException;
}
