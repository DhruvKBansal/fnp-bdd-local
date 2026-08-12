package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Highlighter
 *
 * A utility that visually highlights the element currently being interacted
 * with during the test run. It uses JavaScript injected through the
 * WebDriver's JavascriptExecutor to draw a red outline and a translucent
 * background around the target element, then clears the style after a short
 * flash so the highlight does not pollute the actual page state.
 *
 * The highlight is safe: the original inline style is restored afterwards.
 */
public class Highlighter {

    private static final String BORDER_COLOR = "red";
    private static final String BACKGROUND_COLOR = "rgba(255, 0, 0, 0.2)";
    private static final int FLASH_MILLIS = 300;

    /**
     * Whether highlighting is enabled. Controlled by the "highlight" property in
     * config.properties (true/false). Defaults to true when the property is unset.
     */
    private static boolean enabled = true;

    // Load the enable/disable flag from config.properties once.
    static {
        try {
            Base.loadConfig();
            if (Base.configProperties != null) {
                String value = Base.configProperties.getProperty("highlight");
                if (value != null) {
                    enabled = Boolean.parseBoolean(value.trim());
                }
            }
        } catch (Exception exception) {
            // If config cannot be loaded, keep highlighting enabled by default.
        }
    }

    /**
     * Highlights the given element with a red outline and translucent background,
     * then clears the highlight after a short flash.
     *
     * @param webDriver the WebDriver instance
     * @param element   the WebElement to highlight
     */
    public static void highlight(WebDriver webDriver, WebElement element) {
        if (!enabled || webDriver == null || element == null) {
            return;
        }

        try {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;

            // Save the original inline style so it can be restored.
            String originalStyle = (String) jsExecutor.executeScript(
                    "return arguments[0].getAttribute('style')", element);

            // Apply the highlight.
            jsExecutor.executeScript(
                    "arguments[0].style.border='3px solid " + BORDER_COLOR + "';" +
                    "arguments[0].style.background='" + BACKGROUND_COLOR + "';" +
                    "arguments[0].style.boxShadow='0 0 10px " + BORDER_COLOR + "';",
                    element);

            // Wait for the flash duration, then restore the original style.
            Thread.sleep(FLASH_MILLIS);

            if (originalStyle == null) {
                jsExecutor.executeScript(
                        "arguments[0].removeAttribute('style');", element);
            } else {
                jsExecutor.executeScript(
                        "arguments[0].setAttribute('style', arguments[1]);",
                        element, originalStyle);
            }

        } catch (Exception exception) {
            // If the highlight fails (e.g. element detached), do not break the test.
            LoggerHandler.debug("Highlighter could not highlight element: " + exception.getMessage());
        }
    }

    /**
     * Enables or disables highlighting at runtime.
     *
     * @param flag true to enable, false to disable
     */
    public static void setEnabled(boolean flag) {
        enabled = flag;
    }

    /**
     * @return whether highlighting is currently enabled
     */
    public static boolean isEnabled() {
        return enabled;
    }
}
