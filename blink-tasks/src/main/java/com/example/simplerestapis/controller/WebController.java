package com.example.simplerestapis.controller;

import com.example.simplerestapis.models.Patterns;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.simplerestapis.models.PostResponse;
import com.example.simplerestapis.service.TimeCalculation;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author mafuj.jia
 */
@RestController
public class WebController {

    final TimeCalculation timeCalculation;

    @Value("${application.nodeid}")
    String nodeId;

    @Autowired
    public WebController(TimeCalculation timeCalculation) {
        this.timeCalculation = timeCalculation;
    }

    @RequestMapping(value = "/task23", method = RequestMethod.POST)
    public PostResponse task2Implementation(@RequestBody String inputPayload) {
        PostResponse response = new PostResponse();
        response.setId(nodeId);
        String textLines[] = inputPayload.split(Patterns.NL_PATTERN);
        DateTimeFormatter simpleDateFormat = DateTimeFormatter.ofPattern(Patterns.DATE_PATTERN);
        try {
            int numberOfTestCases = Integer.parseInt(textLines[0]);
            if (numberOfTestCases * 2 == textLines.length - 1) {
                for (int i = 1; i < textLines.length; i++) {
                    try {
                        ZonedDateTime.parse(textLines[i], simpleDateFormat);
                    } catch (Exception ex) {
                        response.setMessage("Invalid date found !!! Please enter valid date time with timezone !!!");
                        return response;
                    }
                }
                response.setResult(timeCalculation.timeCalculationService(inputPayload));
                response.setMessage("Time calculation service has been executed successfully.");
            } else {
                response.setMessage("Invalid input !!! Testcases must be equal to given input at line number 1 !!!");
            }
        } catch (NumberFormatException ex) {
            response.setMessage("Invalid number format !!!");

        }
        return response;
    }
}
