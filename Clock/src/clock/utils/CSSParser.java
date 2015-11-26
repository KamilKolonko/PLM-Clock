package clock.utils;

import java.io.*;
import java.util.Properties;

public class CSSParser {
    private Properties properties;

    public CSSParser(String propertiesFileName) {
        initialize(propertiesFileName);
    }

    private void initialize(String propertiesFileName) {
        this.properties = new Properties();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);
        try {
            if (inputStream != null) {
                this.properties.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propertiesFileName + "' not found in the classpath");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getStyle() {
        return "#background {\n" +
                "    -fx-background-radius:" + properties.getProperty("-fx-background-radius") + ";\n" +
                "    -fx-background-color:" + properties.getProperty("-fx-background-color") + ";\n" +
                "    -fx-border-radius:" + properties.getProperty("-fx-border-radius") + ";\n" +
                "    -fx-border-width:" + properties.getProperty("-fx-border-width") + ";\n" +
                "    -fx-border-color:" + properties.getProperty("-fx-border-color") + ";\n" +
                "}\n" +
                "\n" +
                "#text {\n" +
                "    -fx-font-style:" + properties.getProperty("-fx-font-style") + ";\n" +
                "    -fx-font-size:" + properties.getProperty("-fx-font-size") + ";\n" +
                "    -fx-fill:" + properties.getProperty("-fx-fill") + ";\n" +
                "}";
    }

    public void updateStylesheet(){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("../../style.css", "UTF-8");
            writer.println(getStyle());
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
