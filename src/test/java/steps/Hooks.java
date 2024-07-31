package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class Hooks {
    private static WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-fullscreen");
        System.setProperty("webdriver.chrome.driver", "D:\\Aplikasi Donwload\\chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (driver != null) {
            File directory = new File("evidence");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

                String scenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9_]", "_");

//                int count = getCountOfFiles(directory, scenarioName);
//                File destFile = new File(directory, scenarioName + "_" + (count + 1) + ".png");
                File destFile = new File(directory, scenarioName + ".png");
                FileUtils.copyFile(srcFile, destFile);
                System.out.println("Screenshot taken and saved to " + destFile.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            driver.quit();
        }
    }

//    getCountOfFiles

//    private int getCountOfFiles(File directory, String scenarioName) {
//        int count = 0;
//        File[] files = directory.listFiles();
//        if (files != null) {
//            for (File file : files) {
//                if (file.getName().startsWith(scenarioName) && file.getName().endsWith(".png")) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    public static WebDriver getDriver() {
        return driver;
    }


}
