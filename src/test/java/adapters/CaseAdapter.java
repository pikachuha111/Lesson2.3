package adapters;

import models.Case;
import org.apache.http.HttpStatus;
import utils.EndPoints;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;


public class CaseAdapter {
    private Case caseResponse;

    public Case get(int caseID) {
        return given()
                .pathParams("case_id", caseID)
                .when()
                .get(EndPoints.GET_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .as(Case.class, ObjectMapperType.GSON);

    }

    public void update(Case caseObject) {
        given()
                .pathParams("case_id", caseObject.getId())
                .body(caseObject, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.UPDATE_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    public void moveCases(int sectionID, int suiteID, List<Case> cases) {
        List<Integer> casesIDs = new ArrayList<>();
        Map<String, Object> moveCasesTo = new HashMap<>();
        moveCasesTo.put("suite_id", suiteID);

        for (Case caseOne : cases) {
            casesIDs.add(caseOne.getId());
        }

        moveCasesTo.put("case_ids", casesIDs);

        given()
                .pathParams("section_id", sectionID)
                .body(moveCasesTo)
                .when()
                .post(EndPoints.MOVE_CASES)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    public void delete(Case caseObject) {
        given()
                .pathParams("case_id", caseObject.getId())
                .body(caseObject, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.DELETE_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);

    }

}