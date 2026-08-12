package utils;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.testng.*;

import java.awt.GraphicsEnvironment;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProgressBar implements ITestListener, ISuiteListener {

	private static final String RESET = "\u001B[0m";
	private static final String BOLD = "\u001B[1m";
	private static final String GREEN = "\033[38;5;46m"; // Neon Green
	private static final String RED = "\033[38;5;197m"; // Neon Pink
	private static final String YELLOW = "\033[38;5;226m"; // Neon Yellow
	private static final String CYAN = "\033[38;5;51m"; // Electric Cyan

	private static final int BAR_WIDTH = 60;

	private int totalTests;
	private int completedTests;

	private int passed;
	private int failed;
	private int skipped;

	private long startTime;

	private String currentTest = "Waiting...";
	private String currentStatus = "READY";

	private final List<String> recentFailures = new ArrayList<>();

	private static final AtomicBoolean FX_STARTED = new AtomicBoolean(false);

	private static boolean popupEnabled;

	private static Stage stage;

	private static javafx.scene.control.ProgressBar fxBar;

	private static Label lblPercent;
	private static Label lblCurrent;
	private static Label lblStats;
	private static Label lblSuccessRate;
	private static Label lblDuration;
	private static Label lblEta;
	private static Label lblFailures;

	@Override
	public void onStart(ISuite suite) {

		totalTests = suite.getAllMethods().size();
		completedTests = 0;

		startTime = System.currentTimeMillis();

		if (!GraphicsEnvironment.isHeadless()) {
			popupEnabled = true;
			initializeJavaFX();
		}

		System.out.println(
				CYAN +
						"╔════════════════════════════════════════════════════════════╗");

		System.out.println(
				"║        SELENIUM EXECUTION DASHBOARD              ║");

		System.out.println(
				"╚════════════════════════════════════════════════════════════╝"
						+ RESET);

		System.out.println(
				CYAN + "Suite : "
						+ suite.getName()
						+ RESET);

		System.out.println(
				CYAN + "Total Tests : "
						+ totalTests
						+ RESET);

		System.out.println();
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		passed++;

		update(
				result.getMethod().getMethodName(),
				"PASS",
				GREEN);
	}

	@Override
	public void onTestFailure(ITestResult result) {

		failed++;

		recentFailures.add(
				result.getMethod().getMethodName());

		if (recentFailures.size() > 5) {
			recentFailures.remove(0);
		}

		update(
				result.getMethod().getMethodName(),
				"FAIL",
				RED);
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		skipped++;

		update(
				result.getMethod().getMethodName(),
				"SKIP",
				YELLOW);
	}

	private void update(
			String testName,
			String status,
			String color) {

		completedTests++;

		currentTest = testName;
		currentStatus = status;

		drawConsole(false);

		if (popupEnabled) {
			updatePopup(color);
		}
	}

	private void drawConsole(boolean finalRender) {

		int percentage = totalTests == 0
				? 0
				: (completedTests * 100)
						/ totalTests;

		int filled = (percentage * BAR_WIDTH) / 100;

		StringBuilder bar = new StringBuilder();

		for (int i = 0; i < BAR_WIDTH; i++) {
			bar.append(i < filled ? "▓" : "░");
		}

		long elapsed = System.currentTimeMillis()
				- startTime;

		String color;

		switch (currentStatus) {

			case "PASS":
				color = GREEN;
				break;

			case "FAIL":
				color = RED;
				break;

			case "SKIP":
				color = YELLOW;
				break;

			default:
				color = CYAN;
		}

		System.out.print("\r");

		System.out.print(
				color + "[" + bar + "]" + RESET);

		System.out.print(
				String.format(
						" %3d%% (%d/%d)",
						percentage,
						completedTests,
						totalTests));

		System.out.print(
				" | P:" + GREEN + passed + RESET);

		System.out.print(
				" F:" + RED + failed + RESET);

		System.out.print(
				" S:" + YELLOW + skipped + RESET);

		System.out.print(
				" | Time:"
						+ formatDuration(elapsed));

		if (!finalRender) {

			System.out.print(
					" | " + color
							+ currentStatus
							+ RESET);

			System.out.print(
					" | " + currentTest
							+ "     ");
		}
	}

	private void initializeJavaFX() {

		if (FX_STARTED.compareAndSet(false, true)) {
			new JFXPanel();
		}

		Platform.runLater(() -> {

			fxBar = new javafx.scene.control.ProgressBar(0);
			fxBar.setStyle(
					"-fx-accent:#00FFFF;");

			fxBar.setPrefWidth(650);

			Label lblTitle = new Label("SELENIUM EXECUTION DASHBOARD");

			lblTitle.setStyle(
					"-fx-text-fill:#00FFFF;"
							+ "-fx-font-size:24px;"
							+ "-fx-font-weight:bold;");

			lblPercent = new Label("0%");
			lblPercent.setStyle(
					"-fx-text-fill:#00FFFF;"
							+ "-fx-font-size:20px;"
							+ "-fx-font-weight:bold;");

			lblCurrent = new Label("Waiting...");
			lblCurrent.setStyle(
					"-fx-text-fill:#39FF14;"
							+ "-fx-font-size:16px;"
							+ "-fx-font-weight:bold;");

			lblStats = new Label("PASS:0 FAIL:0 SKIP:0");
			lblStats.setStyle(
					"-fx-text-fill:#FFFFFF;");

			lblSuccessRate = new Label("Success Rate: 0%");
			lblSuccessRate.setStyle(
					"-fx-text-fill:#00FFFF;");

			lblDuration = new Label("Duration: 00:00:00");
			lblDuration.setStyle(
					"-fx-text-fill:#B8B8B8;");

			lblEta = new Label("ETA: Calculating...");
			lblEta.setStyle(
					"-fx-text-fill:#FFD60A;");

			lblFailures = new Label("Recent Failures: None");
			lblFailures.setStyle(
					"-fx-text-fill:#FF5C8A;");

			VBox root = new VBox(15);

			root.setPadding(new Insets(20));

			root.setStyle(
					"-fx-background-color:#0D1117;"
							+ "-fx-font-family:'Segoe UI';"
							+ "-fx-font-size:14px;");

			root.getChildren().addAll(
					lblTitle,
					lblPercent,
					fxBar,
					lblCurrent,
					lblStats,
					lblSuccessRate,
					lblDuration,
					lblEta,
					lblFailures);

			stage = new Stage();

			stage.setAlwaysOnTop(true);

			stage.setTitle(
					"Selenium Execution Dashboard");

			stage.setScene(
					new Scene(root, 850, 370));

			stage.show();
		});
	}

	private void updatePopup(String color) {

		Platform.runLater(() -> {

			double progress = (double) completedTests
					/ totalTests;

			fxBar.setProgress(progress);

			if ("PASS".equals(currentStatus)) {

				fxBar.setStyle(
						"-fx-accent:#00FFAA;");

			} else if ("FAIL".equals(currentStatus)) {

				fxBar.setStyle(
						"-fx-accent:#FF006E;");

			} else {

				fxBar.setStyle(
						"-fx-accent:#FFD60A;");
			}

			long elapsed = System.currentTimeMillis()
					- startTime;

			long eta = calculateETA(elapsed);

			lblPercent.setText(
					String.format(
							"%d%% (%d/%d)",
							(int) (progress * 100),
							completedTests,
							totalTests));

			lblCurrent.setText(
					currentStatus + " -> "
							+ currentTest);

			lblCurrent.setStyle(
					"-fx-font-size:16px;"
							+ "-fx-font-weight:bold;"
							+ "-fx-text-fill:"
							+ toHexColor(color));

			lblStats.setText(
					String.format(
							"PASS:%d FAIL:%d SKIP:%d",
							passed,
							failed,
							skipped));

			lblDuration.setText(
					"Duration: "
							+ formatDuration(elapsed));

			lblEta.setText(
					"ETA: "
							+ formatDuration(eta));

			String failures = recentFailures.isEmpty()
					? "None"
					: String.join(
							" | ",
							recentFailures);

			lblFailures.setText(
					"Recent Failures: "
							+ failures);
		});
	}

	// =====================================================
	// Helper Methods
	// =====================================================

	private long calculateETA(long elapsedMillis) {

		if (completedTests == 0) {
			return 0;
		}

		double averageTimePerTest = (double) elapsedMillis / completedTests;

		return (long) (averageTimePerTest
				* (totalTests - completedTests));
	}

	private String formatDuration(long millis) {

		Duration duration = Duration.ofMillis(millis);

		long hours = duration.toHours();

		long minutes = duration.toMinutes() % 60;

		long seconds = duration.getSeconds() % 60;

		return String.format(
				"%02d:%02d:%02d",
				hours,
				minutes,
				seconds);
	}

	private String toHexColor(String ansiColor) {

		if (GREEN.equals(ansiColor))
			return "#00FFAA";

		if (RED.equals(ansiColor))
			return "#FF006E";

		if (YELLOW.equals(ansiColor))
			return "#FFD60A";

		return "#00FFFF";
	}

	// =====================================================
	// Suite Finish
	// =====================================================

	@Override
	public void onFinish(ISuite suite) {

		drawConsole(true);

		long executionTime = System.currentTimeMillis() - startTime;

		double successRate = totalTests == 0
				? 0
				: ((double) passed / totalTests) * 100;

		System.out.println();
		System.out.println();

		System.out.println(BOLD +
				"====================================================");
		System.out.println("EXECUTION COMPLETED");
		System.out.println(
				"====================================================");

		System.out.println(
				GREEN + "Passed : "
						+ passed
						+ RESET);

		System.out.println(
				RED + "Failed : "
						+ failed
						+ RESET);

		System.out.println(
				YELLOW + "Skipped : "
						+ skipped
						+ RESET);

		System.out.println(
				CYAN
						+ String.format(
								"Success Rate : %.2f%%",
								successRate)
						+ RESET);

		System.out.println(
				"Duration : "
						+ formatDuration(executionTime));

		System.out.println(
				"====================================================");

		if (popupEnabled) {

			Platform.runLater(() -> {

				lblCurrent.setText(
						"✅ Execution Completed");

				lblSuccessRate.setText(
						String.format(
								"Final Success Rate : %.2f%%",
								successRate));

				lblEta.setText("ETA : 00:00:00");
			});

			new Thread(() -> {

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}

				Platform.runLater(() -> {

					if (stage != null) {
						stage.close();
					}
				});

			}).start();
		}
	}

	// =====================================================
	// Unused TestNG Methods
	// =====================================================

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}

	@Override
	public void onTestStart(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(
			ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(
			ITestResult result) {

		onTestFailure(result);
	}
}
