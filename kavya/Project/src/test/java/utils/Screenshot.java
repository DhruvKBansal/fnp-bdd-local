package utils;
 
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
 
public class Screenshot extends Base {
 
    public static String captureScreenshot(WebDriver webDriver, String screenshotFileName) {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String screenshotName = screenshotFileName + "_" + timestamp + ".png";
 
        TakesScreenshot screenshotDriver = (TakesScreenshot) webDriver;
 
        File sourceFile = screenshotDriver.getScreenshotAs(OutputType.FILE);
 
        File screenshotsDirectory = new File(screenshotsDirectoryPath);
        File targetFile = new File(screenshotsDirectory, screenshotName);
 
        if (!screenshotsDirectory.exists()) {
            screenshotsDirectory.mkdirs();
        }
 
        try {
            FileHandler.copy(sourceFile, targetFile);
            System.out.println("Screenshot saved: " + targetFile.getAbsolutePath());
        } catch (IOException exception) {
            System.err.println("Failed to save screenshot: " + exception.getMessage());
            exception.printStackTrace();
        }
 
        return targetFile.getAbsolutePath();
    }
}
