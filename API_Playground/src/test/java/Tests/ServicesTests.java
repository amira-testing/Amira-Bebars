package Tests;

import Base.BaseTest;
import POJO.Services;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class ServicesTests extends BaseTest {

    Services service = new Services();
    String idService;

    @Test(priority = 0)
    public void test_Get_GetAllServices() {
        given()
                .spec(requestSpecification).
                when()
                .get(System.getProperty("endPoint.services")).
                then()
                .spec(responseSpecification);
    }

    @Test(priority = 1)
    public void test_Post_PostNewServiceData() {
        Response response =
                given()
                        .spec(requestSpecification).body(service).
                        when()
                        .post(System.getProperty("endPoint.services"));
        response.then()
                .spec(responseSpecificationCreated)
                .assertThat().body("name", equalTo("Sony Store"));

        idService = response.then().extract().body().jsonPath().get("id").toString();
    }

    @Test(priority = 2)
    public void test_Get_GetServiceDataByID() {
        given()
                .spec(requestSpecification).
                when()
                .get(System.getProperty("endPoint.services") + idService).
                then()
                .spec(responseSpecification)
                .assertThat().body("id", equalTo(Integer.parseInt(idService)));
    }

    @Test(priority = 3)
    public void test_Patch_PatchServiceData() {
        service.setName("XBOX Store");
        given()
                .spec(requestSpecification).body(service).
                when()
                .patch(System.getProperty("endPoint.services") + idService).
                then()
                .spec(responseSpecification)
                .assertThat().body("name", equalTo("XBOX Store"));
    }


    @Test(priority = 4)
    public void test_Delete_deleteServiceDataByID() {
        given()
                .spec(requestSpecification).
                when()
                .delete(System.getProperty("endPoint.services") + idService).
                then()
                .spec(responseSpecification)
                .assertThat().body("id", equalTo(Integer.parseInt(idService)));
    }


}
