package testframework;

import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class ExtentTestWatcher implements TestWatcher {

    @Override
    public void testSuccessful(ExtensionContext context) {
        String testName = context.getDisplayName();
        ExtentManager.getTest().log(Status.PASS, "Test passed: " + testName);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        ExtentManager.getTest().log(Status.FAIL, "Test failed: " + testName);
        ExtentManager.getTest().fail(cause);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        ExtentManager.getTest().log(Status.SKIP, "Test aborted: " + testName);
        if (cause != null) {
            ExtentManager.getTest().skip(cause);
        }
    }

    @Override
    public void testDisabled(ExtensionContext context, java.util.Optional<String> reason) {
        String testName = context.getDisplayName();
        ExtentManager.getTest().log(Status.SKIP, "Test disabled: " + testName + ". Reason: " + reason.orElse("No reason provided."));
    }
}
