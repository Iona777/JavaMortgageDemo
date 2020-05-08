package HelperClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver
{
    //In Java you need to wrap a static class with a non-static one
    public static class MyDriver
    {
        public static WebDriver driver = null;

        public static void getDriver(String selectedBrowser)
        {
            switch (selectedBrowser.toLowerCase())
            {
                case "chrome":
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
                case "ie":
                    driver = new InternetExplorerDriver();
                    driver.manage().window().maximize();
                    break;
                    default:
                        System.out.println("Invalid browser selected");
            }
        }

        public static void navigateTo(String targetURL)
        {
            driver.navigate().to(targetURL);
        }

        //Only used for debugging and to slow down execution for demo purposes
        public static void pause(int milliseconds)
        {
            try
            {
                Thread.sleep(milliseconds);
            }
            catch (Exception e)
            {
                //do nothing
            }

        }

    }

}
