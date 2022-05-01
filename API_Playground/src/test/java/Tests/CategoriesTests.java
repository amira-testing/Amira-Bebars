package Tests;

import Base.BaseTest;
import POJO.Category;
import POJO.Store;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CategoriesTests extends BaseTest {

    Category category = new Category();

    @Test(priority = 0)
    public void test_Get_GetAllCategoriesData(){
        given()
                .spec(requestSpecification).
                when()
                .get(System.getProperty("endPoint.categories")).
                then()
                .spec(responseSpecification);
    }

    @Test(priority = 1)
    public void test_Post_PostNewStoreDara(){
        Response response =
                given()
                        .spec(requestSpecification).body(category).
                        when()
                        .post(System.getProperty("endPoint.categories"));
        response.then()
                .spec(responseSpecificationCreated)
                .assertThat().body("name",equalTo(category.getName()));

    }

    @Test(priority = 2)
    public void test_Get_GetStoreDataByID(){
        given()
                .spec(requestSpecification).
                when()
                .get(System.getProperty("endPoint.categories")+category.getId()).
                then()
                .spec(responseSpecification)
                .assertThat().body("id",equalTo(category.getId()));
    }

    @Test(priority = 3)
    public void test_Patch_PatchStoreData(){
        category.setName("Kitchen");
        given()
                .spec(requestSpecification).body(category).
                when()
                .patch(System.getProperty("endPoint.categories")+category.getId()).
                then()
                .spec(responseSpecification)
                .assertThat().body("name",equalTo("Kitchen"));
    }



    @Test(priority = 4)
    public void test_Delete_deleteStoreDataByID(){
        given()
                .spec(requestSpecification).
        when()
                .delete(System.getProperty("endPoint.categories")+category.getId()).
        then()
                .spec(responseSpecification)
                .assertThat().body("id",equalTo(category.getId()));
    }
}
