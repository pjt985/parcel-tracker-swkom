package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;

import java.util.List;

public interface ParcelService {
    public abstract void submit(ParcelEntity parcelEntity);
    public abstract void update(String id, ParcelEntity parcelEntity);
    public abstract void delete(String id);
    public abstract List<Parcel> getAllParcels();
}
