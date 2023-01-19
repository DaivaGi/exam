package lt.techin.travel.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

import static javax.persistence.EnumType.STRING;

@Entity
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 30)
    private String name;

    @NotNull
    private HolidayType type;

    private String destination;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agency_id")
    //@JoinColumn(name = "agency_id", nullable = true)
    private Agency agency;
    public Holiday() {
    }

    public Holiday(Long id, String name, HolidayType type, String destination) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.destination = destination;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Holiday holiday = (Holiday) o;
        return Objects.equals(id, holiday.id) && Objects.equals(name, holiday.name) && type == holiday.type && Objects.equals(destination, holiday.destination) && Objects.equals(agency, holiday.agency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, destination, agency);
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", destination='" + destination + '\'' +
                ", agency=" + agency +
                '}';
    }
}
