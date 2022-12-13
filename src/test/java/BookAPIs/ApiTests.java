package BookAPIs;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class ApiTests {







    public class apiTests {




        @Test
        public void getallbooks()
        {
            String endpoint = "https://demoqa.com/BookStore/v1/Books";



           var response =  given().when().get(endpoint).then(). body("records.size()", greaterThan(0)).
                   body("records.isbn", notNullValue()).
                   body("records.title", notNullValue()).
                   body("records.subTitle", notNullValue()).
                   body("records.author", notNullValue()).
                   body("records.publish_date", notNullValue()).
                   body("records.publisher", notNullValue()).
                   body("records.pages", notNullValue()).
                   body("records.description", notNullValue()).
                   body("records.website", notNullValue());






        }

        @Test
        public void postnewbook()
        {
            String endpoint = "https://demoqa.com/BookStore/v1/Books";

            String Body = "   {\n" +
                    "            \"userId\":\"e301e9f8-6c3d-4df5-b241-0a9b3d066951\",\n" +
                    "            \"collectionOfIsbns\":\"[\",\n" +
                    "            \"{\":,\n" +
                    "            \"isbn\":\"9781449331818\",\n" +
                    "            \"}\":\n" +
                    "             \"]\":,\n" +
                    "        }";
















            given().body(Body).when().post(endpoint).then().log().headers().assertThat().statusCode(201).
                    header("Content-Type", equalTo("application/json")).body("isbn",equalTo("9781449331818"));






        }


    }


}
