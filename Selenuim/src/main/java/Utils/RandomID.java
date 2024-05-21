package Utils;

import java.util.Random;

public class RandomID {
    String baseName = "מסגרת אוטומציה";
    String randomID = generateRandomID();

    //String FrameNameWithRandomID = baseName + randomID;

    public static String generateRandomID() {
        Random random = new Random();
        int areaNumber = random.nextInt(900) + 100;
        int groupNumber = random.nextInt(100);
        int serialNumber = random.nextInt(10000);
        return String.format("%03d%02d%04d", areaNumber, groupNumber, serialNumber);
}
}
