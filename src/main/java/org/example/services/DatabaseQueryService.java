package org.example.services;

import org.example.dto.*;
import org.example.util.Database;
import org.example.util.SqlFileLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DatabaseQueryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseQueryService.class);

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> result = new ArrayList<>();
        Database database = Database.getInstance();
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlFileLoader.loadSqlFromFile("find_max_projects_client.sql"))) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int projectCount = resultSet.getInt("project_count");
                    result.add(new MaxProjectCountClient(name, projectCount));
                }
            }
        } catch (IOException | SQLException e) {
            LOGGER.error("Error executing query findMaxProjectsClient", e);
        }
        return result;
    }

    public List<LongestProject> findLongestProject() {
        List<LongestProject> result = new ArrayList<>();
        Database database = Database.getInstance();
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlFileLoader.loadSqlFromFile("find_longest_project.sql"))) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String name = resultSet.getString("NAME");
                    int monthCount = resultSet.getInt("MONTH_COUNT");
                    result.add(new LongestProject(name, monthCount));
                }
            }
        } catch (IOException | SQLException e) {
            LOGGER.error("Error executing query findLongestProject", e);
        }
        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> result = new ArrayList<>();
        Database database = Database.getInstance();
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlFileLoader.loadSqlFromFile("find_max_salary_worker.sql"))) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String name = resultSet.getString("Name");
                    int salary = resultSet.getInt("Salary");
                    result.add(new MaxSalaryWorker(name, salary));
                }
            }
        } catch (IOException | SQLException e) {
            LOGGER.error("Error executing query findMaxSalaryWorker", e);
        }
        return result;
    }

    public List<WorkerAgeInfo> findYoungestEldestWorkers() {
        List<WorkerAgeInfo> result = new ArrayList<>();
        Database database = Database.getInstance();
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlFileLoader.loadSqlFromFile("find_youngest_eldest_workers.sql"))) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String type = resultSet.getString("TYPE");
                    String name = resultSet.getString("Name");
                    String birthday = resultSet.getString("Birthday");
                    result.add(new WorkerAgeInfo(type, name, birthday));
                }
            }
        } catch (IOException | SQLException e) {
            LOGGER.error("Error executing query findYoungestEldestWorkers", e);
        }
        return result;
    }

    public List<ProjectPrice> findProjectPrices() {
        List<ProjectPrice> result = new ArrayList<>();
        Database database = Database.getInstance();
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlFileLoader.loadSqlFromFile("print_project_prices.sql"))) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String name = resultSet.getString("NAME");
                    int price = resultSet.getInt("PRICE");
                    result.add(new ProjectPrice(name, price));
                }
            }
        } catch (IOException | SQLException e) {
            LOGGER.error("Error executing query findProjectPrices", e);
        }
        return result;
    }
}

