package org.commons.oca;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.logging.Logger;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


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

    public void localTimeDetails() {
        _LOG.info("[ENTERING void localTimeDetails()]");

        final LocalTime time = LocalTime.of(16, 20, 12, 98547);

        System.out.println("Hour" + time.getHour());
        System.out.println("Minute: " + time.getMinute());
        System.out.println("Second: " + time.getSecond());
        System.out.println("Nano: " + time.getNano());
        
        _LOG.info("[ENDING void localTimeDetails()]");
    }

    public void afterAndBefore() {
        _LOG.info("[ENTERING void afterAndBefore()]");
        
        final LocalTime shreyaFinishTime = LocalTime.parse("17:09:12");
        final LocalTime paulFinishTime = LocalTime.parse("17:09:05");
        
        if (shreyaFinishTime.isBefore(paulFinishTime))
            System.out.println("Shreya Wins");
        else if(shreyaFinishTime.isAfter(paulFinishTime))  
            System.out.println("Paul Wins");

        _LOG.info("[ENDING void afterAndBefore()]");
    }

    public void manipulatingLocalTime() {
        _LOG.info("[ENTERING void manipulatingLocalTime()]");
        
        final LocalTime movieStartTime = LocalTime.parse("21:00:00");
        final int commuteMin = 35;
        final LocalTime shreyaStartTime = movieStartTime.minusMinutes(commuteMin);;
        System.out.println("Start by: " + shreyaStartTime + " from office");
        
        _LOG.info("[ENDING void manipulatingLocalTime()]");
    }

    public void usingLocalTimeConstants() {
        _LOG.info("[ENTERING void usingLocalTimeConstants()]");
        
        final LocalTime MIN = LocalTime.MIN;
        final LocalTime MAX = LocalTime.MAX;
        final LocalTime MIDNIGHT = LocalTime.MIDNIGHT;
        final LocalTime NOON = LocalTime.NOON;

        System.out.println("Min Value Supported: " + MIN);
        System.out.println("MAX Value Supported: " + MAX);
        System.out.println("MIDNIGHT Value Supported: " + MIDNIGHT);
        System.out.println("NOON Value Supported: " + NOON);


        System.out.println(LocalTime.MIN. equals(LocalTime.MIDNIGHT));

        _LOG.info("[ENDING void usingLocalTimeConstants()]");
    }

    public void queryingTime() {
        _LOG.info("[ENTERING void queryingTime()]");

        final LocalTime time = LocalTime.now();
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());
        System.out.println(time.getNano());

        _LOG.info("[ENDING void queryingTime()]");
    }

    public void manageLocalTime() {
        _LOG.info("[ENTERING void manageLocalTime()]");

        final int worldRecord = 10;
        final LocalTime raceStartTime = LocalTime.of(8, 10, 55);
        final LocalTime raceEndTime = LocalTime.of(8, 11, 11);
        
        if (raceStartTime.plusSeconds(worldRecord).isAfter(raceEndTime))
            System.out.println("New World record");
        else
            System.out.println("Try Harder");
        
        _LOG.info("[ENDING void manageLocalTime()]");
    }

    public void performComparisons() {
        _LOG.info("[ENTERING void performComparisons]");
        
        final int worldRecord = 10; 
        final LocalTime raceStartTime = LocalTime.of(8, 10, 55);
        final LocalTime raceEndTime = LocalTime.of(8, 10, 30);
        
        if (raceStartTime.plusSeconds(worldRecord).isAfter(raceEndTime))
            System.out.println("New World Record");
        else 
            System.out.println("Try harder");

        _LOG.info("[ENDING void performComparisons()]");
    }

    public void withXXXs() {
        _LOG.info("[ENTERING void withXXXs()]");
        
        LocalTime startTime = LocalTime.of(5, 7, 9);
        
        if (startTime.getMinute() < 30)
            startTime = startTime.withMinute(0);
        System.out.println(startTime);
        
        _LOG.info("[ENDING void withXXXs()]");
    }

    public void compoundDateAndTime() {
        _LOG.info("[ENTERING void compoundDate()]");

        final LocalTime time = LocalTime.of(14, 10, 0);
        final LocalDate date = LocalDate.of(2016, 02, 28);
        final LocalDateTime dateTime = time.atDate(date);
        final LocalDateTime dateTime2 = date.atTime(time);
        System.out.println(dateTime);
        System.out.println(dateTime2);
        _LOG.info("[ENDING void compoundDate()]");
    }
 
    public void localDateTime() {
        _LOG.info("[ENTERING void localDateTime()]");

        final LocalDateTime prizeCeremony = LocalDateTime.parse("2050-06-05T14:00:00");
        LocalDateTime now = LocalDateTime.now();
        final int JUNE = 6;
        
        if (prizeCeremony.getMonthValue() == JUNE) 
            System.out.println("Cant ivite president");
        else 
            System.out.println("President Invited");
        

        final LocalDateTime chiefGuestDeparture = LocalDateTime.parse("2050-06-05T14:30:00");
        if (prizeCeremony.plusHours(2).isAfter(chiefGuestDeparture))
            System.out.println("Chief Guest Will leave brefore ceremony");

        final LocalDateTime eventMgrArrival = LocalDateTime.of(2050, 6, 5, 14, 30, 0);
        if (eventMgrArrival.isAfter(prizeCeremony.minusHours(3)))
            System.out.println("Manger is supposed to arrive 3 hrs earlier");

        _LOG.info("[ENDING void localDateTime()]");
    }

    public void periodCalculation() {
        _LOG.info("[ENTERING void periodCalculations()]");

        final Period period = Period.of(1, 2, 7);
        final Period periodYears = Period.ofYears(2);
        final Period monthsPeriod = Period.ofMonths(5);
        final Period weeksPeriod = Period.ofWeeks(10);
        final Period daysPeriod = Period.ofDays(15);

        System.out.println(period.toString());
        System.out.println(periodYears);
        System.out.println(monthsPeriod);
        System.out.println(weeksPeriod);
        System.out.println(daysPeriod);

        _LOG.info("[ENDING void periodCalculations()]");
    }

    public void periodCalculationII() {
        _LOG.info("[ENTERING void periodCalculationII]");
        
        final Period p5Yrs1 = Period.parse("P5Y");
        final Period p5Yrs2 = Period.parse("p5Y");
        System.out.println(p5Yrs1 + ":" + p5Yrs2);

        _LOG.info("[ENDING void periodCalculation()II]");
    }
    
    public void periodFromLocalDate() {
        _LOG.info("[ENTERING void periodFromLocalDate()]");
        
        final LocalDate carnivalStart = LocalDate.of(2050, 12, 31);
        final LocalDate carnivalEnd = LocalDate.of(2051, 1, 2);
        
        final Period periodBetween = Period.between(carnivalStart, carnivalEnd);
        System.out.println(periodBetween);
        _LOG.info("[ENDING void periodFromLocalDate()]");
    }

    public void usingPeriodsOnLocals() {
        _LOG.info("[ENTERING void usingPeriodsOnLocals()]");
        
        final LocalDate date = LocalDate.of(2052, 01, 31);
        System.out.println(date.plus(Period.ofDays(1)));

        _LOG.info("[ENDING void usingPeriodsOnLocals()]");
    }

    public void periodLocalDateTime() {
        _LOG.info("[ENTERING void periodLocalDateTime()]");
        
        final LocalDateTime dateTime = LocalDateTime.parse("2020-01-31T14:18:36");
        System.out.println(dateTime.minus(Period.ofYears(2)));
        
        final LocalDate date = LocalDate.of(2052, 01, 31);
        System.out.println(date.minus(Period.ofWeeks(4)));

        _LOG.info("[ENDING void periodLocalDateTime()]");
    }

    public void queryingPeriodInstances() {
        _LOG.info("[ENTERING void queryingPeriodInstances()]");
        
        final Period period = Period.of(2, 4, 40);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());

        _LOG.info("[ENDING void queryingPeriodInstances()]");
    }

    public void periodNullOrZero() {
        _LOG.info("[ENTERING void periodNullOrZero()]");
        
        final Period days5 = Period.of(0, 0, 0);
        System.out.println(days5.isZero());

        final Period daysMinus5 = Period.of(0, 0, 5);
        System.out.println(daysMinus5.isNegative());

        _LOG.info("[ENDING void periodNUllOrZero()]");
    }

    public void manipulaTingPeriod() {
        _LOG.info("[ENTERING void manipulatingPeriod()]");
        
        final Period period10Days = Period.of(0, 0, 10);
        final Period period1Month = Period.of(0, 1, 0);
        
        System.out.println(period10Days.minus(period1Month));
        System.out.println(period1Month.minusDays(5));
        System.out.println(period10Days.minusMonths(5));
        System.out.println(period10Days.minusYears(5));

        _LOG.info("[ENDING void manipulatingPeriod()]");
    }

    public void addingPeriods() {
        _LOG.info("[ENTERING void addingPeriods()]");

        final Period period5Month = Period.of(0, 5, 0);
        final Period period10Months = Period.of(0, 10, 0);
        final Period period10Days = Period.of(0, 0, 10);

        System.out.println(period5Month.plus(period10Months));
        System.out.println(period10Days.plusDays(35));
        System.out.println(period10Days.plusMonths(5));
        System.out.println(period10Days.plusYears(5));
        
        _LOG.info("[ENDING void addingPeriods()]");
    }

    public void convertingPeriods() {
        _LOG.info("[ENTERING void convertingPeriods()]");
        
        System.out.println(Period.of(10, 5, 40).toTotalMonths());

        _LOG.info("[ENDING void convertingPeriods()]");
    }

    public void createDTFormatter() {
        _LOG.info("[ENTERING void createDTFormatter()]");

        final DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        final DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL);
        final DateTimeFormatter formatter3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        final DateTimeFormatter formatter4 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.SHORT);
        
        System.out.println(formatter1);
        System.out.println(formatter2);
        System.out.println(formatter3);
        System.out.println(formatter4);
        
        _LOG.info("[ENDING void createDTFormatter()]");
    }

    public void accessConstants() {
        _LOG.info("[ENTERING void accessConstants()]");
        
        final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        System.out.println(formatter);

        final DateTimeFormatter formatterII = DateTimeFormatter.ISO_TIME;

        final LocalTime time = LocalTime.now();
        System.out.println(time);
        System.out.println(formatterII);
        _LOG.info("[ENDING void accessConstants()]");
    }

    
}