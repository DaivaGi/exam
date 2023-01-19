package lt.techin.travel.api.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Objects;
public class AgencyDto {

    private String name;

    private String city;

    public AgencyDto() {
    }

    public AgencyDto(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgencyDto agencyDto = (AgencyDto) o;
        return Objects.equals(name, agencyDto.name) && Objects.equals(city, agencyDto.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city);
    }

    @Override
    public String toString() {
        return "AgencyDto{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
