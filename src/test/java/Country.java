import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import readwrite.ReadExcelFile;
import readwrite.ReadPropFile;

import java.io.IOException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Country {
@BeforeClass
    public void setRequest() throws IOException {
       requestSpecification = RestAssured.given().
                baseUri(ReadPropFile.configRead()).
                pathParam("country", ReadExcelFile.excelRead()).
                pathParam("postal-code", 90210); }

    @Test
    public void checkIfStatusCodeEquals200() {
        RestAssured
                .given().spec(requestSpecification).when().get("{country}/{postal-code}").then().statusCode(200); }

    @Test
    public void checkIfContentTypeIsJSON() {
        RestAssured
                .given().spec(requestSpecification).when().get("{country}/{postal-code}").then().contentType(ContentType.JSON); }

    @Test
    public void checkIfResponseIsExpected() {
    String countryName = "United States";
        RestAssured
                .given().spec(requestSpecification).when().get("{country}/{postal-code}").then().
                body("country", equalTo(countryName)).
                and().body("places[0][\"place name\"]", equalTo("Beverly Hills")).
                and().body("places[0][\"longitude\"]", equalTo("-118.4065")).
                and().body("places[0][\"latitude\"]", equalTo("34.0901")); }
}