package lt.techin.travel.api.dto.mapper;

import lt.techin.travel.api.dto.HolidayDto;
import lt.techin.travel.Model.Holiday;
import lt.techin.travel.api.dto.HolidayEntityDto;

public class HolidayMapper {

    public static HolidayDto toHolidayDto(Holiday holiday) {
        var holidayDto = new HolidayDto();

        holidayDto.setName(holiday.getName());
        holidayDto.setType(holiday.getType());
        holidayDto.setDestination(holiday.getDestination());

        return holidayDto;
    }

    public static HolidayEntityDto toHolidayEntityDto(Holiday holiday) {
        var holidayDto = new HolidayEntityDto();

        holidayDto.setId(holiday.getId());
        holidayDto.setName(holiday.getName());
        holidayDto.setType(holiday.getType());
        holidayDto.setDestination(holiday.getDestination());


        return holidayDto;
    }

    public static Holiday toHoliday(HolidayDto holidayDto) {
        var holiday = new Holiday();

        holiday.setName(holidayDto.getName());
        holiday.setType(holidayDto.getType());
        holiday.setDestination(holidayDto.getDestination());

        return holiday;
    }

    public static Holiday toHolidayFromEntityDto(HolidayEntityDto holidayDto) {
        var holiday = new Holiday();

        holiday.setId(holidayDto.getId());
        holiday.setName(holidayDto.getName());
        holiday.setType(holidayDto.getType());
        holiday.setDestination(holidayDto.getDestination());

        return holiday;
    }

}
