package tests.api;

import baseEntities.BaseApiTest;
import models.Case;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CaseTests extends BaseApiTest {
    protected Case expectedCase;
    protected Case actualCase;
    protected Case actualCaseTwo;

    @Test
    public void addCase() {
        expectedCase = Case.builder()
                .title("test_case")
                .sectionID(actualSectionOne.getSectionID())
                .build();

        actualCase = caseAdapter.add(expectedCase, actualSectionOne);
        actualCaseTwo = caseAdapter.add(Case.builder()
                .title("test_case2")
                .sectionID(actualSectionOne.getSectionID())
                .build(), actualSectionOne);

        casesTable.addCase(actualCase);
        casesTable.addCase(actualCaseTwo);
    }

    @Test(dependsOnMethods = "addCase", priority = 1)
    public void getCases() {

        actualCase = caseAdapter.get(actualCase.getId());
        casesTable.getCaseById(actualCase.getId());
        Assert.assertEquals(expectedCase, actualCase);

    }

    @Test(dependsOnMethods = "addCase", priority = 2)
    public void updateCases() {
        actualCase.setTitle("name1");
        caseAdapter.update(actualCase);
        casesTable.updateTitle(actualCase);

        Assert.assertNotEquals(expectedCase, actualCase);
    }

    @Test(dependsOnMethods = "addCase", priority = 3)
    public void moveCaseToSection() {
        int suiteID = 1;
        List<Case> cases = List.of(actualCase, actualCaseTwo);
        caseAdapter.moveCases(actualSectionToMove.getSectionID(), suiteID, cases);
        casesTable.moveToSectionID(cases, actualSectionToMove.getSectionID());
    }

    @Test(dependsOnMethods = "addCase", priority = 4)
    public void deleteCase() {
        caseAdapter.delete(actualCaseTwo);
        casesTable.delete(actualCaseTwo);
    }

}

