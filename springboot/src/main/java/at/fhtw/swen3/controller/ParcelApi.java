/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.1.1-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package at.fhtw.swen3.controller;

import at.fhtw.swen3.services.dto.Error;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-12-11T21:56:32.948147Z[Etc/UTC]")
@Validated
@Tag(name = "parcel", description = "Operations for the logistics staff.")
@RequestMapping("${openapi.parcelLogisticsService.base-path:}")
public interface ParcelApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /parcel/{trackingId}/reportDelivery/ : Report that a Parcel has been delivered at it&#39;s final destination address. 
     *
     * @param trackingId The tracking ID of the parcel. E.g. PYJRB4HZ6  (required)
     * @return Successfully reported hop. (status code 200)
     *         or The operation failed due to an error. (status code 400)
     *         or Parcel does not exist with this tracking ID.  (status code 404)
     */
    @Operation(
        operationId = "reportParcelDelivery",
        summary = "Report that a Parcel has been delivered at it's final destination address. ",
        tags = { "staff" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully reported hop."),
            @ApiResponse(responseCode = "400", description = "The operation failed due to an error.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "404", description = "Parcel does not exist with this tracking ID. ")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/parcel/{trackingId}/reportDelivery/",
        produces = { "application/json" }
    )
    default ResponseEntity<Void> reportParcelDelivery(
        @Pattern(regexp = "^[A-Z0-9]{9}$") @Parameter(name = "trackingId", description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required = true) @PathVariable("trackingId") String trackingId
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /parcel/{trackingId}/reportHop/{code} : Report that a Parcel has arrived at a certain hop either Warehouse or Truck. 
     *
     * @param trackingId The tracking ID of the parcel. E.g. PYJRB4HZ6  (required)
     * @param code The Code of the hop (Warehouse or Truck). (required)
     * @return Successfully reported hop. (status code 200)
     *         or Parcel does not exist with this tracking ID or hop with code not found.  (status code 404)
     *         or The operation failed due to an error. (status code 400)
     */
    @Operation(
        operationId = "reportParcelHop",
        summary = "Report that a Parcel has arrived at a certain hop either Warehouse or Truck. ",
        tags = { "staff" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully reported hop."),
            @ApiResponse(responseCode = "404", description = "Parcel does not exist with this tracking ID or hop with code not found. "),
            @ApiResponse(responseCode = "400", description = "The operation failed due to an error.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/parcel/{trackingId}/reportHop/{code}",
        produces = { "application/json" }
    )
    default ResponseEntity<Void> reportParcelHop(
        @Pattern(regexp = "^[A-Z0-9]{9}$") @Parameter(name = "trackingId", description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required = true) @PathVariable("trackingId") String trackingId,
        @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$") @Parameter(name = "code", description = "The Code of the hop (Warehouse or Truck).", required = true) @PathVariable("code") String code
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /parcel : Submit a new parcel to the logistics service. 
     *
     * @param parcel  (required)
     * @return Successfully submitted the new parcel (status code 201)
     *         or The operation failed due to an error. (status code 400)
     *         or The address of sender or receiver was not found. (status code 404)
     */
    @Operation(
        operationId = "submitParcel",
        summary = "Submit a new parcel to the logistics service. ",
        tags = { "sender" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Successfully submitted the new parcel", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = NewParcelInfo.class))
            }),
            @ApiResponse(responseCode = "400", description = "The operation failed due to an error.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "404", description = "The address of sender or receiver was not found.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/parcel",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<NewParcelInfo> submitParcel(
        @Parameter(name = "Parcel", description = "", required = true) @Valid @RequestBody Parcel parcel
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"trackingId\" : \"PYJRB4HZ6\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /parcel/{trackingId} : Find the latest state of a parcel by its tracking ID. 
     *
     * @param trackingId The tracking ID of the parcel. E.g. PYJRB4HZ6  (required)
     * @return Parcel exists, here&#39;s the tracking information. (status code 200)
     *         or The operation failed due to an error. (status code 400)
     *         or Parcel does not exist with this tracking ID. (status code 404)
     */
    @Operation(
        operationId = "trackParcel",
        summary = "Find the latest state of a parcel by its tracking ID. ",
        tags = { "recipient" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Parcel exists, here's the tracking information.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = TrackingInformation.class))
            }),
            @ApiResponse(responseCode = "400", description = "The operation failed due to an error.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "404", description = "Parcel does not exist with this tracking ID.")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/parcel/{trackingId}",
        produces = { "application/json" }
    )
    default ResponseEntity<TrackingInformation> trackParcel(
        @Pattern(regexp = "^[A-Z0-9]{9}$") @Parameter(name = "trackingId", description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required = true) @PathVariable("trackingId") String trackingId
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"visitedHops\" : [ { \"dateTime\" : \"2000-01-23T04:56:07.000+00:00\", \"code\" : \"code\", \"description\" : \"description\" }, { \"dateTime\" : \"2000-01-23T04:56:07.000+00:00\", \"code\" : \"code\", \"description\" : \"description\" } ], \"futureHops\" : [ { \"dateTime\" : \"2000-01-23T04:56:07.000+00:00\", \"code\" : \"code\", \"description\" : \"description\" }, { \"dateTime\" : \"2000-01-23T04:56:07.000+00:00\", \"code\" : \"code\", \"description\" : \"description\" } ], \"state\" : \"Pickup\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /parcel/{trackingId} : Transfer an existing parcel into the system from the service of a logistics partner. 
     *
     * @param trackingId The tracking ID of the parcel. E.g. PYJRB4HZ6  (required)
     * @param parcel  (required)
     * @return Successfully transitioned the parcel (status code 200)
     *         or The operation failed due to an error. (status code 400)
     *         or A parcel with the specified trackingID is already in the system. (status code 409)
     */
    @Operation(
        operationId = "transitionParcel",
        summary = "Transfer an existing parcel into the system from the service of a logistics partner. ",
        tags = { "logisticsPartner" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully transitioned the parcel", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = NewParcelInfo.class))
            }),
            @ApiResponse(responseCode = "400", description = "The operation failed due to an error.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "409", description = "A parcel with the specified trackingID is already in the system.")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/parcel/{trackingId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<NewParcelInfo> transitionParcel(
        @Pattern(regexp = "^[A-Z0-9]{9}$") @Parameter(name = "trackingId", description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required = true) @PathVariable("trackingId") String trackingId,
        @Parameter(name = "Parcel", description = "", required = true) @Valid @RequestBody Parcel parcel
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"trackingId\" : \"PYJRB4HZ6\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
