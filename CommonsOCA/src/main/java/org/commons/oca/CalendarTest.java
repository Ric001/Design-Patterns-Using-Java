package org.commons.oca;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.logging.Logger;

public class CalendarTest {
    
    private final static Logger _LOG = Logger.getLogger(CalendarTest.class.getName());
    
    public void localDateTest() {   
        _LOG.info("[ ENTERING void localDateTest() ]");
        
        final LocalDate date1 = LocalDate.of(2015,Month.SEPTEMBER, 21);
        final LocalDate darte2 = LocalDate.of(2015, Month.DECEMBER, 27);
        final LocalDate currentDateFromSys = LocalDate.now();
        final LocalDate parsedDate = LocalDate.parse("2015-08-09");
        final LocalDate parseDate2 = LocalDate.parse("2021-09-21");
        
        System.out.println(parseDate2);
        _LOG.info("[ ENDING void localDateTest() ]");
    }

    public void workingDetails() {
        _LOG.info("[ ENTERING void workingDetails() ]");
        
        final LocalDate date = LocalDate.parse("2020-08-30");
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getDayOfWeek());
        System.out.println(date.getDayOfYear());
        System.out.println(date.getMonth());
        System.out.println(date.getMonthValue());
        System.out.println(date.getYear());

        _LOG.info("[ ENDING void workingDetails() ]");
    }
    
    public void manipulatingDate() {
        _LOG.info("[ENTERING void manipulatingDate()]");
        
        final LocalDate bDay = LocalDate.of(2052, 03, 10);
        System.out.println(bDay.minusDays(10));
        System.out.println(bDay.minusMonths(2));
        System.out.println(bDay.minusWeeks(30));
        System.out.println(bDay.minusYears(1));

        final LocalDate launchCompany = LocalDate.of(2016, 02, 29);
        System.out.println(launchCompany.plusDays(1));
        System.out.println(launchCompany.plusMonths(1));
        System.out.println(launchCompany.plusWeeks(7));
        System.out.println(launchCompany.plusYears(1));

        _LOG.info("[ENDING void manipulatingDate()]");
    }

    public void toLocalDateTime() {
        _LOG.info("[ENTERING void toLocalDateTime()]");

        final LocalDate interviewDate = LocalDate.of(2016, 02, 28);
        System.out.println(interviewDate.atTime(16, 30));
        System.out.println(interviewDate.atTime(16, 30, 20));
        System.out.println(interviewDate.atTime(16, 30, 20, 300));
        System.out.println(interviewDate.atTime(LocalTime.of(16, 30)));
        
        _LOG.info("[ENDING void toLocalDateTime()]");
    }

    public void toEpochDay() {
        _LOG.info("[ENTERING void toEpochDay()]");
        
        final LocalDate launchBook = LocalDate.of(2016, 2, 8);
        final LocalDate aDate = LocalDate.of(1970, 1, 8);
        System.out.println(launchBook.toEpochDay());
        System.out.println(aDate.toEpochDay());

        _LOG.info("[ENDING void toEpochDay()]");
    }

    public void toLocalTime() {
        _LOG.info("[ENTERING void toLocalTime()]");

        final LocalTime timeHrsMin = LocalTime.of(12, 12);
        final LocalTime timeHrsMinSec = LocalTime.of(0, 12, 6);
        final LocalTime timeHrsMinSecNano = LocalTime.of(14, 7, 10, 998654578);
        final LocalTime date3 = LocalTime.now();
        final LocalTime time = LocalTime.parse("15:08:23");
        System.out.println(date3);
        System.out.println(time);
        _LOG.info("[ENDING void toLocalTime()]");
    }
}