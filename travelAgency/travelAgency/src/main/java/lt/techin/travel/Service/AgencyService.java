package lt.techin.travel.service;

import lt.techin.travel.api.dto.AgencyDto;
import lt.techin.travel.api.dto.mapper.AgencyMapper;
import lt.techin.travel.dao.AgencyRepository;
import lt.techin.travel.Model.Agency;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AgencyService {

    private final AgencyRepository agencyRepository;

    public AgencyService(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    public List<Agency> getAll() {
        return agencyRepository.findAll();
    }

    public Optional<Agency> getById(Long id) {
        return agencyRepository.findById(id);
    }


    public Agency create(Agency agency) {
        return agencyRepository.save(agency);
    }

    public Agency update(Long id, Agency agency) {
        agency.setId(id);//FIXME will improve later

        return agencyRepository.save(agency);
    }

    public boolean deleteById(Long id) {
        if (agencyRepository.existsById(id)) {
            agencyRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
