package readwrite;
import java.io.*;
import java.util.Properties;

public class ReadPropFile {
    public static String configRead() {
        String baseUri = null;
        String propFileName = "src/test/resources/config.properties";
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream(propFileName)) {
            prop.load(input);
            baseUri = prop.getProperty("baseUri");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baseUri;
    }
}