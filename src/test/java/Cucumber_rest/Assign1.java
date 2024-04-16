package Cucumber_rest;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.config.XmlPathConfig;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static io.restassured.path.xml.config.XmlPathConfig.xmlPathConfig;

public class Assign1 {

    public String cles;

    public String request_body;

    Response response;

    public XmlPath xml_path;

    @Given("user enter the Celsius value {string}")
    public void user_enter_the_celsius_value(String Celsius) {

        cles=Celsius;


    }
    @Then("user create the conversion request body")
    public void user_create_the_conversion_request_body() {
     request_body="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
             "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
             "    <soap12:Body>\n" +
             "        <CelsiusToFahrenheit xmlns=\"https://www.w3schools.com/xml/\">\n" +
             "            <Celsius>"+cles+"</Celsius>\n" +
             "        </CelsiusToFahrenheit>\n" +
             "    </soap12:Body>\n" +
             "</soap12:Envelope>";
    }
    @When("user hit a post call {string}")
    public void user_hit_a_post_call(String url) {
        response=given().contentType(ContentType.XML).header("Content-Type","text/xml; charset=utf-8").
                body(request_body).when().post(url);
        System.out.println("Response: "+response.getBody().asString());

    }
    @When("user see the status code as {string}")
    public void user_see_the_status_code_as(String Expected_value) {
        int status_Code=response.statusCode();
        Assert.assertEquals(String.valueOf(status_Code),Expected_value);


    }
    @When("user see the CelsiusToFahrenheitResult value {string}")
    public void user_see_the_celsius_to_fahrenheit_result_value(String Celsius_value) {
        xml_path=new XmlPath(response.getBody().asString()).using(xmlPathConfig().namespaceAware(false));
        String data=xml_path.getString("soap:Envelope.soap:Body.CelsiusToFahrenheitResponse.CelsiusToFahrenheitResult").trim();;
        System.out.println(data);
        Assert.assertEquals(String.valueOf(Celsius_value),data);

    }
}


