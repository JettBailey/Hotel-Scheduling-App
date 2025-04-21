package edu.wgu.d387_sample_code.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimeConversionService {

    public List<String> getPresentationTimes(){
        ZonedDateTime etTime = ZonedDateTime.of(
                LocalDate.now(),
                LocalTime.of(15,0),
                ZoneId.of("America/New_York")
        );

        ZonedDateTime mtTime = etTime.withZoneSameInstant(ZoneId.of("America/Denver"));
        ZonedDateTime utcTime = etTime.withZoneSameInstant(ZoneId.of("UTC"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        List<String> times = new ArrayList<>();
        times.add(formatter.format(etTime) + " ET");
        times.add(formatter.format(mtTime) + " MT");
        times.add(formatter.format(utcTime) + " UTC");

        return times;
    }
}
