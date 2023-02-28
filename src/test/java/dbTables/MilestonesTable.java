package dbTables;

import models.Case;
import models.Milestone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.DataBaseService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MilestonesTable {
    Logger logger = LogManager.getLogger(ProjectTable.class);
    private DataBaseService dbService;

    public MilestonesTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void createTable() {
        String createTableSQL = "" +
                "create table public.milestones" +
                "(id SERIAL PRIMARY KEY," +
                "    name CHARACTER VARYING(30)," +
                "    description CHARACTER VARYING(30)," +
                "    project_id INTEGER," +
                "    milestone_id INTEGER" +
                ");";

        dbService.executeSQL(createTableSQL);
    }

    public void addMilestone(Milestone milestone) {
        logger.info("Customer creating method " + milestone.getName());

        String insertTableSQL = "INSERT INTO public.milestones(" +
                "name, description, project_id, milestone_id)" +
                "VALUES ('" + milestone.getName() + "', '" + milestone.getDescription() +
                "', '" + milestone.getProjectID() + "', '" + milestone.getId() + "'" + ");";

        dbService.executeSQL(insertTableSQL);
    }

    public void getMilestoneById(int milestone_id) {
        String sql = "SELECT * FROM public.milestones WHERE milestone_id = " + milestone_id + ";";

        ResultSet rs = dbService.executeQuery(sql);

        try {
            rs.next();
            Integer dbCaseId = rs.getInt("id");
            String name = rs.getString("name");
            String description = rs.getString("description");
            Integer projectID = rs.getInt("project_id");
            Integer milestoneID = rs.getInt("milestone_id");

            logger.info("DBid: " + dbCaseId);
            logger.info("name: " + name);
            logger.info("description: " + description);
            logger.info("project_id: " + projectID);
            logger.info("milestone_id: " + milestoneID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void getMilestones() {
        String sql = "SELECT * FROM public.milestones";

        ResultSet rs = dbService.executeQuery(sql);

        try {
            while (rs.next()) {
                Integer dbCaseId = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Integer projectID = rs.getInt("project_id");
                Integer milestoneID = rs.getInt("milestone_id");

                logger.info("DBid: " + dbCaseId);
                logger.info("name: " + name);
                logger.info("description: " + description);
                logger.info("project_id: " + projectID);
                logger.info("milestone_id: " + milestoneID);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateName(Milestone milestone) {
        String updateTableSQL = "UPDATE public.milestones " +
                "SET " + "name = '" + milestone.getName() + "' " +
                "WHERE " + "milestone_id = '" + milestone.getId() + "';";

        dbService.executeSQL(updateTableSQL);
    }

    public void delete(Milestone milestone) {
        String updateTableSQL = "DELETE FROM public.milestones " +
                "WHERE " + "milestone_id = '" + milestone.getId() + "';";

        dbService.executeSQL(updateTableSQL);
    }

    public void dropTable() {
        String dropTableSQL = "DROP TABLE public.milestones";

        dbService.executeSQL(dropTableSQL);
    }
}
