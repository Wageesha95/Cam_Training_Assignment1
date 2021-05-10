import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestCommonToolkit {

    private CommonToolkit commonToolkit;

    @Test
    public void testConvertToEnglishFormat() {
        commonToolkit = new CommonToolkit();
        String number = commonToolkit.convertToEnglishFormat("2,5 ml");
        Assertions.assertEquals("2.5 ml",number);
    }
    @Test
    public void testGetNextDoesTimeWithMarchBeforeDSTChange() throws Exception{

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date previousDoesTime = format.parse ( "2017-03-25 19:00:00" );
        String duration = "6";

        commonToolkit = new CommonToolkit();
        String nextDoseTime=commonToolkit.getNextDoesTime(previousDoesTime, duration);

        Assertions.assertEquals("01:00 AM",nextDoseTime);
    }
    @Test
    public void testGetNextDoesTimeWithMarchCrossingDSTChange() throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date previousDoesTime = format.parse ( "2017-03-26 01:00:00" );
        String duration = "6";

        commonToolkit = new CommonToolkit();
        String nextDoseTime=commonToolkit.getNextDoesTime(previousDoesTime, duration);

        Assertions.assertEquals("08:00 AM",nextDoseTime);
    }
    @Test
    public void testGetNextDoesTimeWithMarchAfterDSTChange() throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date previousDoesTime = format.parse ( "2017-03-26 08:00:00" );
        String duration = "6";

        commonToolkit = new CommonToolkit();
        String nextDoseTime=commonToolkit.getNextDoesTime(previousDoesTime, duration);

        Assertions.assertEquals("02:00 PM",nextDoseTime);
    }

    @Test
    public void testGetNextDoesTimeWithOctoberBeforeDSTChange() throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date previousDoesTime = format.parse ( "2017-10-28 19:00:00" );
        String duration = "6";

        commonToolkit = new CommonToolkit();
        String nextDoseTime=commonToolkit.getNextDoesTime(previousDoesTime, duration);

        Assertions.assertEquals("01:00 AM",nextDoseTime);
    }
    @Test
    public void testGetNextDoesTimeWithOctoberCrossingDSTChange() throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date previousDoesTime = format.parse ( "2017-10-29 1:00:00" );
        String duration = "6";

        commonToolkit = new CommonToolkit();
        String nextDoseTime=commonToolkit.getNextDoesTime(previousDoesTime, duration);

        Assertions.assertEquals("06:00 AM",nextDoseTime);
    }
    @Test
    public void testGetNextDoesTimeWithOctoberAfterDSTChange() throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date previousDoesTime = format.parse ( "2017-10-29 8:00:00" );
        String duration = "6";

        commonToolkit = new CommonToolkit();
        String nextDoseTime=commonToolkit.getNextDoesTime(previousDoesTime, duration);

        Assertions.assertEquals("02:00 PM",nextDoseTime);
    }
    @Test
    public void testGetSwedidhText() {
        commonToolkit = new CommonToolkit();
        String textWithUnicode = "\u00E5sk\u00E5da";
        String testString = commonToolkit.getSwedishText(textWithUnicode);
        Assertions.assertEquals("åskåda", testString);
    }

}
