package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParcelMapper {
    ParcelMapper INSTANCE = Mappers.getMapper(ParcelMapper.class);

    /*@Mapping(source = "parcel.weight", target = "weight")
    @Mapping(source = "parcel.sender", target = "sender")
    @Mapping(source = "parcel.recipient", target = "recipient")
    ParcelEntity dtoToEntity(Parcel parcel);
    Parcel entityToDto(ParcelEntity parcelEntity);*/


    /*ParcelEntity dtoToEntity(Parcel parcel);
    //ParcelEntity dtoToParcelEntity(NewParcelInfo newParcelInfo, TrackingInformation trackingInformation, Parcel parcel);
    TrackingInformation entityToTrackingInformationDto(ParcelEntity parcel);
    NewParcelInfo entityToNewParcelInfoDto(ParcelEntity parcel);
    Parcel entityToDto(ParcelEntity parcel);*/

    ParcelEntity dtoToEntity(NewParcelInfo newParcelInfo, TrackingInformation trackingInformation, Parcel parcel);
    ParcelEntity dtoToParcelEntity(Parcel parcel);
    TrackingInformation entityToTrackingInformationDto(ParcelEntity parcel);
    NewParcelInfo entityToNewParcelInfoDto(ParcelEntity parcel);
    Parcel entityToDto(ParcelEntity parcel);
}
