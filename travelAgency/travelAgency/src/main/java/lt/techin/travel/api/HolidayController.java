package lt.techin.travel.api;

import lt.techin.travel.api.dto.HolidayDto;
import lt.techin.travel.api.dto.HolidayEntityDto;
import lt.techin.travel.api.dto.mapper.HolidayMapper;
import lt.techin.travel.Model.Holiday;
import lt.techin.travel.service.HolidayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lt.techin.travel.api.dto.mapper.HolidayMapper.toHoliday;
import static lt.techin.travel.api.dto.mapper.HolidayMapper.toHolidayDto;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/api/v1/holidays")
public class HolidayController {

    public static Logger logger = LoggerFactory.getLogger(HolidayController.class);

    private final HolidayService holidayService;

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public List<HolidayEntityDto> getHolidays() {
        return holidayService.getAll().stream()
                .map(HolidayMapper::toHolidayEntityDto)
                .collect(toList());
    }

//    @GetMapping("/marked")
//    @ResponseBody
//    public List<HolidayEntityDto> findMarkedHolidays() {
//        return holidayService.findMarkedHolidays().stream()
//                .map(HolidayMapper::toHolidayEntityDto)
//                .collect(toList());
//    }

    @GetMapping(value = "/{holidayId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public ResponseEntity<HolidayEntityDto> getHoliday(@PathVariable Long holidayId) {
//        var holidayOptional = holidayService.getById(holidayId);
//
//        var responseEntity = holidayOptional
//                .map(holiday -> ok(toHolidayEntityDto(holiday)))
//                .orElseGet(() -> ResponseEntity.notFound().build());
//
//        return responseEntity;
//    }
    public ResponseEntity<Holiday> getHoliday(@PathVariable Long holidayId) {
        var holidayOptional = holidayService.getById(holidayId);

        var responseEntity = holidayOptional
                .map(holiday -> ok(holiday))
                .orElseGet(() -> ResponseEntity.notFound().build());

        return responseEntity;
    }

    @DeleteMapping("/{holidayId}")
    public ResponseEntity<Void> deleteHoliday(@PathVariable Long holidayId) {
        logger.info("Attempt to delete Holiday by id: {}", holidayId);

        boolean deleted = holidayService.deleteById(holidayId);
        if (deleted) {
            return ResponseEntity.noContent().build();

            //galima konstruoti ir taip, visi variantai teisingi
            //return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<HolidayDto> createHoliday(@RequestBody HolidayDto holidayDto) {
        var createdHoliday = holidayService.create(toHoliday(holidayDto));

        return ok(toHolidayDto(createdHoliday));
    }

    @PutMapping("/{holidayId}")
    public ResponseEntity<HolidayDto> replaceHoliday(@PathVariable Long holidayId, @RequestBody HolidayDto holidayDto) {
        var updatedHoliday = holidayService.replace(holidayId, toHoliday(holidayDto));

        return ok(toHolidayDto(updatedHoliday));
    }

    @PatchMapping("/{holidayId}")
    public ResponseEntity<HolidayDto> updateHoliday(@PathVariable Long holidayId, @RequestBody HolidayDto holidayDto) {
        var updatedHoliday = holidayService.update(holidayId, toHoliday(holidayDto));

        return ok(toHolidayDto(updatedHoliday));
    }

    @PostMapping("/{holidayId}/addagency")
    @ResponseBody
    public Holiday addAgencyToHoliday(@PathVariable Long holidayId, @RequestParam Long agencyId) {
        return holidayService.addAgencyToHoliday(holidayId, agencyId);
    }
}
