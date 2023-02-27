package adapters;

import io.restassured.mapper.ObjectMapperType;
import models.Project;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.EndPoints;

import static io.restassured.RestAssured.*;

public class ProjectAdapter {
    protected Project expectedProject;
    protected Project actualProject;
    protected Logger logger = LogManager.getLogger(ProjectAdapter.class);

    public Project add(String name) {
        expectedProject = Project.builder()
                .name(name)
                .suiteMode(1)
                .build();

       return actualProject = given()
                .body(expectedProject, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Project.class, ObjectMapperType.GSON);
    }

    public void delete() {
        given()
                .pathParams("project_id", actualProject.getId())
                .body(actualProject, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.DELETE_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK);

        logger.info("Project has been deleted ... ");
    }
}
