package org.example.util;

import org.example.services.DatabasePopulateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SqlFileLoader {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabasePopulateService.class);

    public static String loadSqlFromFile(String filename) throws IOException {
        try (InputStream is = SqlFileLoader.class.getClassLoader().getResourceAsStream("sql/" + filename)) {
            if (is == null) {
                throw new IOException("File not found: " + filename);
            }
            try (Scanner scanner = new Scanner(is, StandardCharsets.UTF_8)) {
                return scanner.useDelimiter("\\A").next();
            }
        } catch (IOException e) {
            LOGGER.error("Error loading SQL file: " + filename, e);
            throw e;
        }
    }
}
