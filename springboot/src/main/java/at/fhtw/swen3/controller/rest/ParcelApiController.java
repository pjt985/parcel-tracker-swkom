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

import java.io.IOException;
import java.util.Optional;
import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-11T21:56:32.948147Z[Etc/UTC]")
@Controller
@Slf4j
public class ParcelApiController implements ParcelApi {

    @Autowired
    private final NativeWebRequest nativeWebRequest;
    @Autowired
    private final ParcelService parcelService;


    @Autowired
    public ParcelApiController(NativeWebRequest nativeWebRequest, ParcelService parcelService) {
        this.nativeWebRequest = nativeWebRequest;
        this.parcelService = parcelService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(nativeWebRequest);
    }


    @Override
    public ResponseEntity<NewParcelInfo> submitParcel(Parcel parcel) {
        try {
            Optional<NewParcelInfo> res = parcelService.submit(parcel);

            if(res.isPresent()) {
                log.info("submitParcel successful");
                return new ResponseEntity<>(res.get(), HttpStatus.CREATED);
            }
            else {
                log.info("submitParcel failed");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (ConstraintViolationException | IOException | InterruptedException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public ResponseEntity<Void> reportParcelDelivery(String trackingId) {
        if(parcelService.update(trackingId, TrackingInformation.StateEnum.DELIVERED).isPresent()) {
            log.info("reportParcelDelivery successful");
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            log.info("reportParcelDelivery failed");
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


    @Override
    public ResponseEntity<TrackingInformation> trackParcel(String trackingId) {
        Optional<TrackingInformation> res = parcelService.getTrackingInformation(trackingId);

        if(parcelService.getTrackingInformation(trackingId).isPresent()) {
            log.info("trackParcel successful");
            return new ResponseEntity<>(res.get(), HttpStatus.OK);
        }
        else {
            log.info("trackParcel failed");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public ResponseEntity<Void> reportParcelHop(String trackingId, String code) {
        parcelService.reportParcelHop();
        log.info("reportParcelHop called");
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Override
    public ResponseEntity<NewParcelInfo> transitionParcel(String trackingId, Parcel parcel) {
        try {
            parcelService.transitionParcel(trackingId, parcel);
        } catch (InterruptedException | IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        log.info("transitionParcel successful");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
