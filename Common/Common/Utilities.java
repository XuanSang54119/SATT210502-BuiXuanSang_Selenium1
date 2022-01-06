package Common.Common;

public class Utilities {
    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }
    public static String getDataPath() {
        return Utilities.getProjectPath() + "\\Resources\\Dataset\\Data.json";
    }
}
