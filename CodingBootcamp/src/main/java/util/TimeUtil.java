package util;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class TimeUtil {
    private TimeUtil() {}

    public static List<LocalDate> setMondayFridayLocalDate(LocalDate searchingDate) {
        int minusDaysToMonday;
        int plusDaysToFriday;
        switch(searchingDate.getDayOfWeek()) {
            case MONDAY: {
                minusDaysToMonday = 0;
                plusDaysToFriday = 4;
                break;
            }
            case TUESDAY: {
                minusDaysToMonday = 1;
                plusDaysToFriday = 3;
                break;
            }
            case WEDNESDAY: {
                minusDaysToMonday = 2;
                plusDaysToFriday = 2;
                break;
            }
            case THURSDAY: {
                minusDaysToMonday = 3;
                plusDaysToFriday = 1;
                break;
            }
            case FRIDAY: {
                minusDaysToMonday = 4;
                plusDaysToFriday = 0;
                break;
            }
            case SATURDAY: {
                minusDaysToMonday = 5;
                plusDaysToFriday = -1;
                break;
            }
            default: {
                minusDaysToMonday = 6;
                plusDaysToFriday = -2;
                break;
            }
        }

       return Arrays.asList(searchingDate.minusDays(minusDaysToMonday), searchingDate.plusDays(plusDaysToFriday));
    }
}
