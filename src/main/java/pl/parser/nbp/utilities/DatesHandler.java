package pl.parser.nbp.utilities;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DatesHandler {

    public List<LocalDate> getAllDatesInRange(LocalDate startDate, LocalDate endDate) {
        return startDate.datesUntil(endDate.plusDays(1)).collect(Collectors.toList());
    }

    public List<String> createDateStrings(List<LocalDate> localDates) {
        return localDates.stream().map(localDate -> {
            StringBuilder stringBuilder = new StringBuilder();
            int year = localDate.getYear();
            String month = String.format("%02d", localDate.getMonth().getValue());
            String day = String.format("%02d", localDate.getDayOfMonth());
            stringBuilder.append(String.valueOf(year).substring(2));
            stringBuilder.append(month).append(day);
            return stringBuilder.toString();
        }).collect(Collectors.toList());
    }



}
