package tests.api;

import baseEntities.BaseApiGsonTest;
import models.Milestone;
import org.testng.annotations.Test;

public class MilestoneTests extends BaseApiGsonTest {
    private Milestone testMilestone;

    @Test(groups = "MileStone")
    public void addMilestone() {
        Milestone expectedMilestone = Milestone.builder()
                .name("newName")
                .description("description")
                .projectID(3)
                .build();

        testMilestone = milestoneAdapter.add(expectedMilestone);

    }

    @Test(dependsOnMethods = "addMilestone",
            groups = "MileStone")
    public void getMilestone() {
        milestoneAdapter.get(testMilestone);
    }

    @Test(dependsOnMethods = "addMilestone",
            groups = "MileStone")
    public void getMilestones() {
        milestoneAdapter.getMilestones(3);
    }

    @Test(dependsOnMethods = "addMilestone",
            groups = "MileStone")
    public void updateMilestone() {
        testMilestone.setName("name1");
        milestoneAdapter.update(testMilestone.getId(), testMilestone);
    }

    @Test(dependsOnMethods = "addMilestone",
            groups = "MileStone")
    public void deleteMilestone() {
        milestoneAdapter.delete(testMilestone.getId(), testMilestone);
    }
}
