package tests.db;

import baseEntities.BaseApiTest;
import dbServices.CustomerService;
import dbTables.CustomersTable;
import models.Customer;
import models.CustomerBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SimpleDBTest extends BaseApiTest {
    Logger logger = LogManager.getLogger(SimpleDBTest.class);


    @Test
    public void simpleDBTest() {
        String sql = "SELECT * FROM public.customers;";

        ResultSet rs = dbService.executeQuery(sql); //вычитываем все данные, которые будут соответствовать SQL запросу

        try {
            while (rs.next()) { // перебирает каждую строку
                Integer userID = rs.getInt("id");
                String lastname = rs.getString("lastname");
                String firstname = rs.getString("firstname");
                String email = rs.getString("email");
                Integer age = rs.getInt(5); // берем не по названию а по индексу колонки, нумерация идет с 1 а не с 0

                logger.info("ID:" + userID);
                logger.info("firstname:" + firstname);
                logger.info("lastname:" + lastname);
                logger.info("email:" + email);
                logger.info("age:" + age);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void advancedDBTest() throws SQLException {
        CustomersTable customersTable = new CustomersTable(dbService);

        customersTable.dropTable();
        customersTable.createTable();

        customersTable.addCustomer(CustomerBuilder.builder()
                .firstname("Alex")
                .lastname("lastname")
                .email("test1234@gmail.com")
                .age(33)
                .build());

        customersTable.addCustomer(CustomerBuilder.builder()
                .firstname("Leha")
                .lastname("lastname123")
                .email("test1233434344@gmail.com")
                .age(64)
                .build());

        customersTable.addCustomer(CustomerBuilder.builder()
                .firstname("Anna")
                .lastname("lastnuuume")
                .email("tesasdfasdt1234@gmail.com")
                .age(54)
                .build());

        ResultSet rs = customersTable.getCustomers();

        try {
            while (rs.next()) { // перебирает каждую строку
                Integer userID = rs.getInt("id");
                String lastname = rs.getString("lastname");
                String firstname = rs.getString("firstname");
                String email = rs.getString("email");
                Integer age = rs.getInt(5); // берем не по названию а по индексу колонки, нумерация идет с 1 а не с 0

                logger.info("ID:" + userID);
                logger.info("firstname:" + firstname);
                logger.info("lastname:" + lastname);
                logger.info("email:" + email);
                logger.info("age:" + age);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        rs = customersTable.getCustomerById(2);
        rs.next();
        logger.info("ID:" + rs.getString("id"));
        logger.info("firstname:" + rs.getString("firstname"));
        logger.info("lastname:" + rs.getString("lastname"));
        logger.info("email:" + rs.getString("email"));
        logger.info("age:" + rs.getString("age"));

    }

    @Test
    public void hibernateTest() {
        CustomerService customerService = new CustomerService();
        Customer customer = new Customer("Ivan", "Grigoriev", "grtest@test.com", 30);

        customerService.saveUser(customer);

        List<Customer> customerList = customerService.findAllUsers();
        for (Customer user : customerList) {
            System.out.println(user.toString());
        }
    }
}

