package adapters;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Milestone;
import models.Project;
import org.apache.http.HttpStatus;

import utils.EndPoints;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class MilestoneAdapter {
    protected Project actualProject;


    public Milestone add(Project actualProject, Milestone milestone) {
        this.actualProject = actualProject;

        return given()
                .pathParams("project_id", actualProject.getId())
                .body(milestone, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.ADD_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo(milestone.getName()))
                .body("description", equalTo(milestone.getDescription()))
                .extract()
                .as(Milestone.class, ObjectMapperType.GSON);

    }

    public void get(Milestone milestone) {
        given()
                .pathParams("milestone_id", milestone.getId())
                .when()
                .get(EndPoints.GET_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo(milestone.getName()))
                .body("description", equalTo(milestone.getDescription()));

    }

    public void getMilestones(int projectID) {
         given()
                .pathParams("project_id", projectID)
                .when()
                .get(EndPoints.GET_MILESTONES)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
    }

    public void update(int milestoneID, Milestone milestone) {
        given()
                .pathParams("milestone_id", milestoneID)
                .body(milestone, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.UPDATE_MILESTONE)
                .then()
                .body("name", equalTo(milestone.getName()))
                .body("description", equalTo(milestone.getDescription()))
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    public void delete(int milestoneID, Milestone milestone) {
        Response response =given()
                .pathParams("milestone_id", milestoneID)
                .body(milestone, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.DELETE_MILESTONE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        String statusLine = response.getStatusLine().toString();
        System.out.println(statusLine);
    }
}
