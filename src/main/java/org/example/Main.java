package org.example;

import org.example.dto.*;
import org.example.services.DatabaseInitService;
import org.example.services.DatabasePopulateService;
import org.example.services.DatabaseQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        DatabaseInitService.main(args);
        DatabasePopulateService.main(args);

        DatabaseQueryService queryService = new DatabaseQueryService();

        List<MaxProjectCountClient> clients = queryService.findMaxProjectsClient();
        clients.forEach(client -> LOGGER.info(client.toString()));


        List<LongestProject> longestProjects = queryService.findLongestProject();
        longestProjects.forEach(project -> LOGGER.info(project.toString()));


        List<MaxSalaryWorker> maxSalaryWorkers = queryService.findMaxSalaryWorker();
        maxSalaryWorkers.forEach(worker -> LOGGER.info(worker.toString()));


        List<WorkerAgeInfo> youngestEldestWorkers = queryService.findYoungestEldestWorkers();
        youngestEldestWorkers.forEach(worker -> LOGGER.info(worker.toString()));


        List<ProjectPrice> projectPrices = queryService.findProjectPrices();
        projectPrices.forEach(project -> LOGGER.info(project.toString()));
    }
}
