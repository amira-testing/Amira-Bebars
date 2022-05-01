package Tests;

import Base.BaseTest;
import POJO.Store;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class StoresTests extends BaseTest {

    String idStore = "8925";
    Store store = new Store();

    @Test(priority = 0)
    public void test_Get_GetAllStoresData() {
        given()
                .spec(requestSpecification).
                when()
                .get(System.getProperty("endPoint.stores")).
                then()
                .spec(responseSpecification);
    }

    @Test(priority = 1)
    public void test_Post_PostNewStoreDara() {
        Response response =
                given()
                        .spec(requestSpecification).body(store).log().all().
                        when()
                        .post(System.getProperty("endPoint.stores"));
        response.then()
                .spec(responseSpecificationCreated)
                .assertThat().body("name", equalTo("Breadfast"));

        idStore = response.then().extract().body().jsonPath().get("id").toString();
    }

    @Test(priority = 2)
    public void test_Get_GetStoreDataByID() {
        given()
                .spec(requestSpecification).
                when()
                .get(System.getProperty("endPoint.stores") + idStore).
                then()
                .spec(responseSpecification)
                .assertThat().body("id", equalTo(Integer.parseInt(idStore)));
    }

    @Test(priority = 3)
    public void test_Patch_PatchStoreData() {
        store.setName("Breadfasting");
        given()
                .spec(requestSpecification).body(store).
                when()
                .patch(System.getProperty("endPoint.stores") + idStore).
                then()
                .spec(responseSpecification)
                .assertThat().body("name", equalTo("Breadfasting"));
    }


    @Test(priority = 4)
    public void test_Delete_deleteStoreDataByID() {
        given()
                .spec(requestSpecification).
                when()
                .delete(System.getProperty("endPoint.stores") + idStore).
                then()
                .spec(responseSpecification)
                .assertThat().body("id", equalTo(Integer.parseInt(idStore)));
    }
}
