package adapters;

import io.restassured.mapper.ObjectMapperType;
import models.Project;
import models.Section;
import org.apache.http.HttpStatus;
import utils.EndPoints;

import static io.restassured.RestAssured.*;

public class SectionAdapter {
    protected Section actualSection;

    public Section add(Project actualProject) {

        actualSection = Section.builder()
                .name("New_Section")
                .build();

        return given()
                .pathParams("project_id", actualProject.getId())
                .body(actualSection, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.ADD_SECTION)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Section.class, ObjectMapperType.GSON);
    }
}
