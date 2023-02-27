package baseEntities;

import adapters.CaseAdapter;
import adapters.MilestoneAdapter;
import adapters.ProjectAdapter;
import adapters.SectionAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Project;
import models.Section;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected Gson gson;
    protected MilestoneAdapter milestoneAdapter;
    protected CaseAdapter caseAdapter;
    protected ProjectAdapter projectAdapter;
    protected SectionAdapter sectionAdapter;
    protected Project actualProject;
    protected Section actualSectionOne;
    protected Section actualSectionToMove;


    @BeforeTest
    public void setupApi() {

        gson = new Gson();
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        RestAssured.baseURI = ReadProperties.getUrl();

        RestAssured.requestSpecification = given()
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);

        projectAdapter = new ProjectAdapter();
        actualProject = projectAdapter.add("test_Name");

        sectionAdapter = new SectionAdapter();
        actualSectionOne = sectionAdapter.add(actualProject);
        actualSectionToMove = sectionAdapter.add(actualProject);

        caseAdapter = new CaseAdapter();

        milestoneAdapter = new MilestoneAdapter();

    }


    @AfterTest
    public void tearDown() {
        projectAdapter.delete();
    }
}
