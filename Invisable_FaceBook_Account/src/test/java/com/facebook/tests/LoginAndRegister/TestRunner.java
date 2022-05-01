package com.facebook.tests.LoginAndRegister;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features ="src\\test\\java\\com\\facebook\\tests\\LoginAndRegister",
        glue = {"com.facebook.tests"},
        plugin = {"html:reports/FacebookReport.html"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
