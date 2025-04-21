package edu.wgu.d387_sample_code.controller;

import edu.wgu.d387_sample_code.service.TimeConversionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TimeController {

    private final TimeConversionService timeConversionService;

    public TimeController(TimeConversionService timeConversionService) {
        this.timeConversionService = timeConversionService;
    }

    @GetMapping("/presentation-time")
    public List<String>getPresentationTimes() {
        return timeConversionService.getPresentationTimes();
    }
}
