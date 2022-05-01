package Tests;

import Base.BaseTest;
import POJO.Product;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class ProductsTests extends BaseTest {

    String id = "43900";
    Product product;

    @Test(priority = 0)
    public void test_Get_GetAllProducts(){
        given()
                .spec(requestSpecification).
        when()
                .get(System.getProperty("endPoint.products")).
        then()
                .spec(responseSpecification);
    }

    @Test(priority = 1)
    public void test_Post_PostNewProduct(){
        product = new Product();
        product.setName("GOW");
        product.setDescription("Game");
        product.setImage(" ");
        product.setManufacturer("Sony");
        product.setPrice(50);
        product.setShipping(0);
        product.setUpc("123456789");
        product.setModel("sdfgjmk");
        product.setUrl("www.sony.com");
        product.setType("CD");

        Response response = given().body(product).contentType(ContentType.JSON)
                .when().post("http://localhost:3030/products/");
        response.then().spec(responseSpecificationCreated);
        id = response.then().extract().body().jsonPath().get("id").toString();
    }

    @Test(priority = 2)
    public void test_Get_GetProductByID(){
        given()
                .spec(requestSpecification).
        when()
                .get(System.getProperty("endPoint.products")+id).
        then()
                .spec(responseSpecification)
                .assertThat().body("id",equalTo(Integer.parseInt(id)));
    }


    @Test(priority = 3)
    public void test_Patch_UpdateProductById(){
        product.setImage("www.google.com");
        given()
                .spec(requestSpecification)
                .body(product).contentType(ContentType.JSON).
        when()
                .patch(System.getProperty("endPoint.products")+id).
        then()
                .spec(responseSpecification)
                .assertThat().body("image",equalTo("www.google.com"));
    }
    @Test(priority = 4)
    public void test_Delete_DeleteProductById(){

        given()
                .spec(requestSpecification).
        when()
                .delete(System.getProperty("endPoint.products")+id).
        then()
                .spec(responseSpecification);
    }
}
