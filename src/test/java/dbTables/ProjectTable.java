package dbTables;

import models.Project;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.DataBaseService;

import java.sql.ResultSet;

public class ProjectTable {
    Logger logger = LogManager.getLogger(ProjectTable.class);
    private DataBaseService dbService;

    public ProjectTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void createTable() {
        String createTableSQL = "" +
                "create table public.projects" +
                "(id SERIAL PRIMARY KEY," +
                "    project_name CHARACTER VARYING(30)," +
                "    announcement CHARACTER VARYING(30)," +
                "    suite_mode INTEGER," +
                "    project_id INTEGER" +
                ");";

        dbService.executeSQL(createTableSQL);
    }

    public ResultSet getProjectById(int project_id) {
        String sql = "SELECT * FROM public.projects WHERE project_id = " + project_id + ";";

        return dbService.executeQuery(sql);
    }

    public void addProject(Project project) {

        String insertTableSQL = "INSERT INTO public.projects(" +
                "project_name, announcement, suite_mode, project_id)" +
                "VALUES ('" + project.getName() + "', '" + project.getAnnouncement() +
                "', '" + project.getSuiteMode() + "', " + project.getId() + ");";

        dbService.executeSQL(insertTableSQL);
    }

    public void dropTable() {
        logger.info("Project has been deleted from database ... ");

        String dropTableSQL = "DROP TABLE public.projects";

        dbService.executeSQL(dropTableSQL);
    }
}
