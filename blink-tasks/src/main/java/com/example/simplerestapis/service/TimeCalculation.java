/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.simplerestapis.service;

import com.example.simplerestapis.models.Patterns;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author mafuj.jia
 */
@Component
public class TimeCalculation {

    public List<Long> timeCalculationService(String inputPayload) {
        DateTimeFormatter simpleDateFormat = DateTimeFormatter.ofPattern(Patterns.DATE_PATTERN);
        String textLines[] = inputPayload.split(Patterns.NL_PATTERN);
        String inputDates[] = new String[Integer.parseInt(textLines[0]) * 2];
        List<Long> output = new ArrayList<>();
        ZonedDateTime t1;
        ZonedDateTime t2;
        for (int i = 1, j = 0; i < textLines.length && j < textLines.length - 1; i++, j++) {
            inputDates[j] = textLines[i];
        }
        for (int j = 0; j < inputDates.length; j++) {
            try {
                t1 = ZonedDateTime.parse(inputDates[j], simpleDateFormat);
                t2 = ZonedDateTime.parse(inputDates[j + 1], simpleDateFormat);
                long sec = ChronoUnit.SECONDS.between(t1, t2);
                output.add(sec);
                j++;
            } catch (Exception ex) {
                System.out.println("Invalid Date !!! " + ex.getMessage());
            }
        }
        return output;
    }
}
