package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporter extends Base {

    private static ExtentReports extentReport;

    public static ExtentReports generateExtentReport(String reportName) {

        if (extentReport == null) {
            extentReport = createExtentReport(reportName);
        }

        return extentReport;
    }

    private static ExtentReports createExtentReport(String reportName) {

        ExtentReports extentReport = new ExtentReports();

        loadConfig();

        String timestamp = getTimestamp();

        File reportDirectory = new File(reportsDirectoryPath);

        if (!reportDirectory.exists()) {
            reportDirectory.mkdirs();
        }

        String reportFilePath = reportsDirectoryPath + File.separator + reportName + "_" + timestamp + ".html";

        File extentReportFile = new File(reportFilePath);

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);

sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName(reportName);
        sparkReporter.config().setDocumentTitle(reportName + " - Test Automation Report");
        sparkReporter.config().setTimeStampFormat("yyyy.MM.dd.HH.mm.ss");

        extentReport.attachReporter(sparkReporter);

        extentReport.setSystemInfo(
                "Application URL",
                configProperties.getProperty("url"));

        extentReport.setSystemInfo(
                "Browser Name",
                configProperties.getProperty("browser"));

        extentReport.setSystemInfo(
                "Operating System",
                System.getProperty("os.name"));

        extentReport.setSystemInfo(
                "Username",
                System.getProperty("user.name"));

        extentReport.setSystemInfo(
                "Java Version",
                System.getProperty("java.version"));

        return extentReport;
    }

    private static String getTimestamp() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));

        return dateFormat.format(new Date());
    }

    public static void attachScreenshotToReport(
            String filename,
            ExtentTest extentTest,
            String description) {

        try {

            extentTest.log(
                    Status.INFO,
                    description,
                    MediaEntityBuilder
                            .createScreenCaptureFromPath(
                                    Screenshot.captureScreenshot(webDriver, filename))
                            .build());

        } catch (Exception exception) {

            extentTest.log(
                    Status.WARNING,
                    "Failed to attach screenshot: "
                            + exception.getMessage());
        }
    }
}
