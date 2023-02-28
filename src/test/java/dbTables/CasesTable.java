package dbTables;

import models.Case;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.DataBaseService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CasesTable {
    Logger logger = LogManager.getLogger(ProjectTable.class);
    private DataBaseService dbService;

    public CasesTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void createTable() {
        String createTableSQL = "" +
                "create table public.cases" +
                "(id SERIAL PRIMARY KEY," +
                "    title CHARACTER VARYING(30)," +
                "    section_id INTEGER," +
                "    case_id INTEGER" +
                ");";

        dbService.executeSQL(createTableSQL);
    }

    public void addCase(Case caseObject) {
        String insertTableSQL = "INSERT INTO public.cases(" +
                "title, section_id, case_id)" +
                "VALUES ('" + caseObject.getTitle() + "', '" + caseObject.getSectionID() +
                "', '" + caseObject.getId() + "');";

        dbService.executeSQL(insertTableSQL);
    }

    public void getCaseById(int case_id) {
        String sql = "SELECT * FROM public.cases WHERE case_id = " + case_id + ";";

        ResultSet rs = dbService.executeQuery(sql);

        try {
            rs.next();
            Integer dbCaseId = rs.getInt("id");
            String title = rs.getString("title");
            Integer sectionID = rs.getInt("section_id");
            Integer caseID = rs.getInt("case_id");

            logger.info("DBid: " + dbCaseId);
            logger.info("title: " + title);
            logger.info("section_id: " + sectionID);
            logger.info("case_id: " + caseID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateTitle(Case caseObject) {

        String updateTableSQL = "UPDATE public.cases " +
                "SET " + "title = '" + caseObject.getTitle() + "' " +
                "WHERE " + "case_id = '" + caseObject.getId() + "';";

        dbService.executeSQL(updateTableSQL);
    }

    public void moveToSectionID(List<Case> caseList, int sectionID) {
        for (Case caseObject : caseList) {

            String updateTableSQL = "UPDATE public.cases " +
                    "SET " + "section_id = '" + sectionID + "' " +
                    "WHERE " + "case_id = '" + caseObject.getId() + "';";

            dbService.executeSQL(updateTableSQL);
        }

    }

    public void delete(Case caseObject) {
        String updateTableSQL = "DELETE FROM public.cases " +
                "WHERE " + "case_id = '" + caseObject.getId() + "';";

        dbService.executeSQL(updateTableSQL);
    }

    public void dropTable() {
        String dropTableSQL = "DROP TABLE public.cases";

        dbService.executeSQL(dropTableSQL);
    }
}
