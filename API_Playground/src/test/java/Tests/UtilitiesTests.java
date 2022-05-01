package Tests;

import Base.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UtilitiesTests extends BaseTest {

    @Test
    public void test_Get_GetUtilitiesVersion(){
        given()
                .spec(requestSpecification).
        when()
                .get(System.getProperty("endPoint.utilities.version")).
        then()
                .spec(responseSpecification)
                .assertThat().body("version",equalTo("1.1.0"));

        extent.attachReporter(spark);
        extent.createTest("test_Get_GetUtilitiesVersion")
                .log(Status.PASS, "it passed!");
        extent.flush();

    }

    @Test
    public void test_Get_GetUtilitiesHealthCheck(){
        given()
                .spec(requestSpecification).
        when()
                .get(System.getProperty("endPoint.utilities.healthcheck")).
        then()
                .spec(responseSpecification);

        extent.attachReporter(spark);
        extent.createTest("test_Get_GetUtilitiesHealthCheck")
                .log(Status.PASS, "it passed!");
        extent.flush();

    }
}
