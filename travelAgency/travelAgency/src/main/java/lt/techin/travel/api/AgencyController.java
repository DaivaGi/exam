package lt.techin.travel.api;
import lt.techin.travel.api.dto.AgencyDto;
import lt.techin.travel.api.dto.AgencyEntityDto;
import lt.techin.travel.api.dto.mapper.AgencyMapper;
import lt.techin.travel.service.AgencyService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static lt.techin.travel.api.dto.mapper.AgencyMapper.*;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/api/v1/agencys")
@Validated
public class AgencyController {

    private final AgencyService agencyService;

    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @GetMapping
    @ResponseBody
    public List<AgencyEntityDto> getAgencys() {
        return agencyService.getAll().stream()
                .map(AgencyMapper::toAgencyEntityDto)
                .collect(toList());
        //return ResponseEntity.ok(holidayRepository.getAll());
    }

    @GetMapping("/{agencyId}")
    public ResponseEntity<AgencyEntityDto> getAgency(@PathVariable Long agencyId) {
        var agencyOptional = agencyService.getById(agencyId);

        var responseEntity = agencyOptional
                .map(agency -> ok(toAgencyEntityDto(agency)))
                .orElseGet(() -> ResponseEntity.notFound().build());

// vienas is budu kaip mappinti response:
//        responseEntity = new ResponseEntity<>(toAgencyDto(agencyOptional.get()), HttpStatus.OK);

        return responseEntity;
    }

    @DeleteMapping("/{agencyId}")
    public ResponseEntity<Void> deleteAgency(@PathVariable Long agencyId) {
        var agencyDeleted = agencyService.deleteById(agencyId);

        if (agencyDeleted) {
            return ResponseEntity.noContent().build();
//            new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AgencyDto> createAgency(@Valid @RequestBody AgencyDto agencyDto) {
        var createdAgency = agencyService.create(toAgency(agencyDto));

        return ok(toAgencyDto(createdAgency));
    }

    @PutMapping("/{holidayId}")
    public ResponseEntity<AgencyDto> updateAgency(@PathVariable Long holidayId, @RequestBody AgencyDto agencyDto) {
        var updatedAgency = agencyService.update(holidayId, toAgency(agencyDto));

        return ok(toAgencyDto(updatedAgency));
    }

}
