package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;

import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ParcelService {

    public Optional<NewParcelInfo> submit(Parcel parcel) throws ConstraintViolationException, IOException, InterruptedException;

    public Optional<Parcel> update(String trackingId, TrackingInformation.StateEnum state);

    public void reportParcelHop();

    public void transitionParcel(String trackingId, Parcel parcel) throws InterruptedException, IOException;

    public Optional<TrackingInformation> getTrackingInformation(String trackingId);
}
