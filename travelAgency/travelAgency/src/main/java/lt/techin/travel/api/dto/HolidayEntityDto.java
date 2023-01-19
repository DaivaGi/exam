package lt.techin.travel.api.dto;

import lt.techin.travel.Model.HolidayType;

import java.util.Objects;

//konfiguracija tiesiog DTO:
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class HolidayEntityDto extends HolidayDto {

    private Long id;

    public HolidayEntityDto() {
    }

    public HolidayEntityDto(Long id) {
        this.id = id;
    }

    public HolidayEntityDto(String name, HolidayType type, String destination, Long id) {
        super(name, type, destination);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HolidayEntityDto that = (HolidayEntityDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "HolidayEntityDto{" +
                "id=" + id +
                '}';
    }
}
