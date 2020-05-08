package HelperClasses;

import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.*;
import java.io.*;

public class ConfigHelper
{
    Properties configFile;

    //Constructor - not reaquired, use default

    public String getProperty(String key)  {
        try
        {
            Path target = Paths.get("src/test/resource");
            String abspath = target.toAbsolutePath().toString();
            String fileName = abspath+"/config.properties";

            FileReader reader = new FileReader(fileName);
            Properties prop=new Properties();
            prop.load(reader);

            return prop.getProperty(key);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "Exception encountered";

    }
}


