package lt.techin.travel.api.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Objects;

public class AgencyEntityDto extends AgencyDto {

    private Long id;

    //    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedDate;


    public AgencyEntityDto() {
    }

    public AgencyEntityDto(Long id, String name, String city) {
        super(name, city);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AgencyEntityDto that = (AgencyEntityDto) o;
        return Objects.equals(id, that.id) && Objects.equals(modifiedDate, that.modifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, modifiedDate);
    }

    @Override
    public String toString() {
        return "AgencyEntityDto{" +
                "id=" + id +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
