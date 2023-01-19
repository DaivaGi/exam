package lt.techin.travel.service;

import lt.techin.travel.dao.HolidayRepository;
import lt.techin.travel.dao.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import lt.techin.travel.Model.Holiday;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static lt.techin.travel.Model.HolidayType.*;

@Service
public class HolidayService {

    private final HolidayRepository holidayRepository;
    private final AgencyRepository agencyRepository;

    @Autowired //jeigu nenurodytume Spring'as (nuo 4.3 versijos) pridetu vieninteliam managed Bean klases konstruktoriuj @Autowired automatiskai
    public HolidayService(HolidayRepository holidayRepository, AgencyRepository agencyRepository) {
        this.holidayRepository = holidayRepository;
        this.agencyRepository = agencyRepository;
    }

    public List<Holiday> getAll() {
        return holidayRepository.findAll();
    }

    public Optional<Holiday> getById(Long id) {
        return holidayRepository.findById(id);
    }


    public Holiday create(Holiday holiday) {
        return holidayRepository.save(holiday);
    }

    public Holiday update(Long id, Holiday holiday) {
        var existingHoliday = holidayRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Holiday does not exist "+ id.toString()));

        existingHoliday.setName(holiday.getName());
        existingHoliday.setType(holiday.getType());
        existingHoliday.setDestination(holiday.getDestination());

        return holidayRepository.save(existingHoliday);
    }

    public Holiday replace(Long id, Holiday holiday) {
        holiday.setId(id);

        return holidayRepository.save(holiday);
    }

    public boolean deleteById(Long id) {
        try {
            holidayRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException exception) {
            return false;
        }
    }

//    public List<Holiday> findMarkedHolidays() {
//        return holidayRepository.findAllMarkedHolidays();
//    }

    public Holiday addAgencyToHoliday(Long holidayId, Long agencyId) {
        // - find holiday
        var existingHoliday = holidayRepository.findById(holidayId)
                .orElseThrow(() -> new NullPointerException("Holiday not found " + holidayId.toString()));

        // - find agency
        var existingAgency = agencyRepository.findById(agencyId)
                .orElseThrow(() -> new NullPointerException("Agency not found " + agencyId.toString()));

        // - if OK - set
        existingHoliday.setAgency(existingAgency);

        // - save
        return holidayRepository.save(existingHoliday);
    }
}
