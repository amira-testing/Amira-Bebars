package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest {

    protected String baseURL;
    protected RequestSpecification requestSpecification;
    protected ResponseSpecification responseSpecification;
    protected ResponseSpecification responseSpecificationCreated;
    protected ExtentSparkReporter spark;
    protected ExtentReports extent;


    @BeforeClass
    public void setUp() {
        Properties props = System.getProperties();
        try {
            props.load(new FileInputStream(new File(System.getProperty("user.dir") + "/src/files/config.properties")));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

        baseURL = System.getProperty("baseURL");

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseURL).setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON).build();

        responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .build();
        responseSpecificationCreated = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(201)
                .build();


        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/src/reports/Spark.html");
        extent = new ExtentReports();

    }
}
