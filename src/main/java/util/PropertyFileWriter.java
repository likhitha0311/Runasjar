package util;

import testData.ExistingData;

import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertyFileWriter {
    static Properties properties= new Properties();;
    public static void writeFile(String filename,String  propertyName, String value)
        {
           //properties= new Properties();
            try (OutputStream outputStream = new FileOutputStream(filename)) {
                // Set properties
               properties.setProperty(propertyName, value);

                // Save properties to file
                properties.store(outputStream,"Properties file");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static String readFile(String filename,String propertyName)
        {
           // properties = new Properties();
            try (FileInputStream inputStream = new FileInputStream(filename))
            {
                properties.load(inputStream);
                String propertyValue = properties.getProperty(propertyName);
                return propertyValue;
            } catch (IOException e)
            {
                e.printStackTrace();
                return null;
            }
        }
    }