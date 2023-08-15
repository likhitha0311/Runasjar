package util;

import org.testng.ITestListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class AllureReportCleaner implements ITestListener {


        @BeforeSuite
        public void deleteAllureReport() {
            File allureReportDir = new File("path/to/allure-report");
            if (allureReportDir.exists()) {
                // Delete the allure-report directory and its contents
                boolean deleted = allureReportDir.delete();
                if (deleted) {
                    System.out.println("Allure report directory deleted successfully.");
                } else {
                    System.out.println("Failed to delete Allure report directory.");
                }
            }
        }

}