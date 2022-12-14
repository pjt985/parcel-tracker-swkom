package at.fhtw.swen3.controller.rest;

import at.fhtw.swen3.controller.ParcelApi;


import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-11T21:56:32.948147Z[Etc/UTC]")
@Controller
@Slf4j
public class ParcelApiController implements ParcelApi {

    @Autowired
    private final NativeWebRequest request;
    @Autowired
    private final ParcelService service;

    @Autowired
    public ParcelApiController(NativeWebRequest request, ParcelService service) {
        this.request = request;
        this.service = service;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Void> reportParcelDelivery(String trackingId) {
        return ParcelApi.super.reportParcelDelivery(trackingId);
    }

    @Override
    public ResponseEntity<Void> reportParcelHop(String trackingId, String code) {
        return ParcelApi.super.reportParcelHop(trackingId, code);
    }

    @Override
    public ResponseEntity<NewParcelInfo> submitParcel(Parcel parcel) {
        return ParcelApi.super.submitParcel(parcel);
    }

    @Override
    public ResponseEntity<TrackingInformation> trackParcel(String trackingId) {
        return ParcelApi.super.trackParcel(trackingId);
    }

    @Override
    public ResponseEntity<NewParcelInfo> transitionParcel(String trackingId, Parcel parcel) {
        return ParcelApi.super.transitionParcel(trackingId, parcel);
    }
}
