package lt.techin.travel.api.dto.mapper;

import lt.techin.travel.api.dto.AgencyDto;
import lt.techin.travel.api.dto.AgencyEntityDto;
import lt.techin.travel.Model.Agency;

public class AgencyMapper {

    public static AgencyDto toAgencyDto(Agency agency) {
        var agencyDto = new AgencyDto();

        agencyDto.setName(agency.getName());
        agencyDto.setCity(agency.getCity());

        return agencyDto;
    }

    public static Agency toAgency(AgencyDto agencyDto) {
        var agency = new Agency();

        agency.setName(agencyDto.getName());
        agency.setCity(agencyDto.getCity());

        return agency;
    }


    public static AgencyEntityDto toAgencyEntityDto(Agency agency) {
        var agencyDto = new AgencyEntityDto();

        agencyDto.setId(agency.getId());
        agencyDto.setName(agency.getName());
        agencyDto.setCity(agency.getCity());

        return agencyDto;
    }

    public static Agency toAgency(AgencyEntityDto agencyEntityDto) {
        var agency = new Agency();

        agency.setId(agencyEntityDto.getId());
        agency.setName(agencyEntityDto.getName());
        agency.setCity(agencyEntityDto.getCity());

        return agency;
    }

}
