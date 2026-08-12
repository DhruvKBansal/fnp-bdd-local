package utils;

import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.EncodingKey;
import static org.monte.media.VideoFormatKeys.FrameRateKey;
import static org.monte.media.VideoFormatKeys.KeyFrameIntervalKey;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.Arrays;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class VideoRecorder implements ITestListener {

    private static ScreenRecorder screenRecorder;
    private static File recordedAviFile;

    private boolean shouldRecord(String testName) {

        boolean recordingEnabled = Boolean.parseBoolean(
                Base.configProperties.getProperty("videoRecording", "false"));

        if (!recordingEnabled) {
            return false;
        }

        String configuredTests = Base.configProperties
                .getProperty("recordTests", "");

        return Arrays.stream(configuredTests.split(","))
                .map(String::trim)
                .filter(test -> !test.isEmpty())
                .anyMatch(testName::equalsIgnoreCase);
    }

    private void startRecording(String testName) {

        try {

            String videoPath = System.getProperty("user.dir")
                    + File.separator
                    + Base.configProperties.getProperty(
                            "videoRecordingPath",
                            "videos");

            File folder = new File(videoPath);

            if (!folder.exists()) {
                folder.mkdirs();
            }

            GraphicsConfiguration gc =
                    GraphicsEnvironment.getLocalGraphicsEnvironment()
                            .getDefaultScreenDevice()
                            .getDefaultConfiguration();

            screenRecorder = new ScreenRecorder(
                    gc,
                    gc.getBounds(),
                    new Format(
                            MediaTypeKey,
                            MediaType.FILE,
                            MimeTypeKey,
                            MIME_AVI),
                    new Format(
                            MediaTypeKey,
                            MediaType.VIDEO,
                            EncodingKey,
                            ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            CompressorNameKey,
                            ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            DepthKey,
                            24,
                            FrameRateKey,
                            Rational.valueOf(15),
                            QualityKey,
                            1.0f,
                            KeyFrameIntervalKey,
                            15 * 60),
                    null,
                    null,
                    folder) {

                @Override
                protected File createMovieFile(Format fileFormat) {

                    recordedAviFile = new File(
                            folder,
                            testName + "_"
                                    + System.currentTimeMillis()
                                    + ".avi");

                    return recordedAviFile;
                }
            };

            screenRecorder.start();

            System.out.println(
                    "[VIDEO] Recording started for: " + testName);

        } catch (Exception e) {

            System.err.println(
                    "[VIDEO] Failed to start recording.");

            e.printStackTrace();
        }
    }

    private void stopRecording() {

        try {

            if (screenRecorder != null) {

                screenRecorder.stop();
                screenRecorder = null;

                System.out.println(
                        "[VIDEO] Recording stopped.");

                convertToMp4();
            }

        } catch (Exception e) {

            System.err.println(
                    "[VIDEO] Failed to stop recording.");

            e.printStackTrace();
        }
    }

    private void convertToMp4() {

        try {

            if (recordedAviFile == null
                    || !recordedAviFile.exists()) {

                System.out.println(
                        "[VIDEO] AVI file not found for conversion.");

                return;
            }

            String mp4FilePath = recordedAviFile
                    .getAbsolutePath()
                    .replace(".avi", ".mp4");

            Process process = new ProcessBuilder(
                    "ffmpeg",
                    "-y",
                    "-i",
                    recordedAviFile.getAbsolutePath(),
                    "-c:v",
                    "libx264",
                    "-preset",
                    "fast",
                    "-crf",
                    "23",
                    mp4FilePath)
                    .inheritIO()
                    .start();

            int exitCode = process.waitFor();

            if (exitCode == 0) {

                System.out.println(
                        "[VIDEO] MP4 created successfully: "
                                + mp4FilePath);

                if (recordedAviFile.delete()) {

                    System.out.println(
                            "[VIDEO] Deleted AVI: "
                                    + recordedAviFile.getName());
                }

            } else {

                System.err.println(
                        "[VIDEO] FFmpeg conversion failed.");
            }

        } catch (Exception e) {

            System.err.println(
                    "[VIDEO] Error while converting AVI to MP4.");

            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {

        String testName =
                result.getMethod().getMethodName();

        if (shouldRecord(testName)) {
            startRecording(testName);
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        stopRecording();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        stopRecording();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        stopRecording();
    }
}
