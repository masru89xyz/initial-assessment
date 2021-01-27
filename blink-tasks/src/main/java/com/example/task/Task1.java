/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.task;

import com.example.simplerestapis.models.Patterns;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 *
 * @author mafuj.jia
 */
public class Task1 {

    public static void main(String[] args) {
        DateTimeFormatter simpleDateFormat = DateTimeFormatter.ofPattern(Patterns.DATE_PATTERN);
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        String inputDates[] = new String[numberOfTestCases * 2];
        int i = 0;
        ZonedDateTime t1;
        ZonedDateTime t2;
        while (true && numberOfTestCases > 0 && inputDates.length != i) {
            Scanner input = new Scanner(System.in);
            inputDates[i] = input.nextLine();
            i++;
        }
        for (int j = 0; j < inputDates.length; j++) {
            try {
                t1 = ZonedDateTime.parse(inputDates[j], simpleDateFormat);
                t2 = ZonedDateTime.parse(inputDates[j + 1], simpleDateFormat);
                long sec = ChronoUnit.SECONDS.between(t1, t2);
                System.out.println("result:" + sec);
                j++;
            } catch (Exception ex) {
                System.out.println("Invalid Date !!! " + ex.getMessage());
            }
        }
    }
}
