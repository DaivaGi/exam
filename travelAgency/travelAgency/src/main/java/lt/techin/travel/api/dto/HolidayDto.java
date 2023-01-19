package lt.techin.travel.api.dto;

import lt.techin.travel.Model.HolidayType;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class HolidayDto {

    private String name;
    private HolidayType type;
    private String destination;

    public HolidayDto() {
    }

    public HolidayDto(String name, HolidayType type, String destination) {
        this.name = name;
        this.type = type;
        this.destination = destination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HolidayType getType() {
        return type;
    }

    public void setType(HolidayType type) {
        this.type = type;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HolidayDto that = (HolidayDto) o;
        return Objects.equals(name, that.name) && type == that.type && Objects.equals(destination, that.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, destination);
    }

    @Override
    public String toString() {
        return "HolidayDto{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", destination='" + destination + '\'' +
                '}';
    }
}
