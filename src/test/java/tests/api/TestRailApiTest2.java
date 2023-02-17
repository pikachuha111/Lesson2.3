package tests.api;

import baseEntities.BaseApiGsonTest;
import baseEntities.BaseApiTest;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.User;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestRailApiTest2 extends BaseApiGsonTest {

    @Test
    public void getUser() {
        int userID = 1;

        String endpoint = "/index.php?/api/v2/get_user/{user_id}";

        User expectedUser = User.builder()
                .name("Aleksandr Trostyanko")
                .email("atrostyanko@gmail.com")
                .isActive(true)
                .isAdmin(true)
                .roleId(1)
                .role("Lead")
                .build();

        User actualUser = given()
                .pathParams("user_id", userID)
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(User.class, ObjectMapperType.GSON);

        System.out.println(actualUser.toString());

        Assert.assertEquals(actualUser, expectedUser);
    }

    @Test
    public void getUser1() {
        int userID = 1;

        String endpoint = "/index.php?/api/v2/get_user/{user_id}";

        User expectedUser = User.builder()
                .name("Aleksandr Trostyanko")
                .email("atrostyanko@gmail.com")
                .isActive(true)
                .isAdmin(true)
                .roleId(1)
                .role("Lead")
                .build();

        Response response = given()
                .pathParams("user_id", userID)
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        User actualUser = gson.fromJson(response.getBody().asPrettyString(),
                User.class);

        System.out.println(actualUser.toString());

        Assert.assertEquals(actualUser, expectedUser);
    }
}
