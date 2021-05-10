import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.function.IntConsumer;

public class CommonToolkit {


    public String convertToEnglishFormat(String number){
        number = number.replace(',','.');
        return number;
    }

    public String getNextDoesTime(Date previousDoesTime, String duration){

        final ZoneId swedenZoneId = ZoneId.of("Europe/Stockholm");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(previousDoesTime);
        ZonedDateTime zdtPreviousDoseTime = ZonedDateTime.of(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.DAY_OF_MONTH),calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),calendar.get(Calendar.SECOND),0, swedenZoneId);

        final long durationHours = Long.parseLong(duration);

        ZonedDateTime zdtNextDoseTime=zdtPreviousDoseTime.plusHours(durationHours);

        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        final String nextDoseTime = zdtNextDoseTime.format(formatter);

        return nextDoseTime;
    }

    public String getSwedishText(String textWithUnicode){

        final StringBuilder stringBuilder = new StringBuilder();
        textWithUnicode.chars().forEach(new IntConsumer() {
            public void accept(int a) {
                stringBuilder.append(String.valueOf((char) a));
            }
        });
        return stringBuilder.toString();
    }
}
