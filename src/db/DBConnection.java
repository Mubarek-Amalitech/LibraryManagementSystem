package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {

    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection() {
        try {
            // Use the correct MySQL JDBC Driver
            Class.forName("com.mysql.jdbc.Connection");  // Update to correct driver class

            // Update connection string as needed
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?createDatabaseIfNotExist=true&allowMultiQueries=true",
                    "root", "Mubarak771998");

            // Check if tables already exist, if not create them
            PreparedStatement pstm = connection.prepareStatement("SHOW TABLES");
            ResultSet resultSet = pstm.executeQuery();

            // Check if the tables exist, if not, create them
            if (!resultSet.next()) {
                // Create bookdetail table
                String sql1 = "CREATE TABLE `bookdetail` (" +
                        "`id` VARCHAR(10) NOT NULL, " +
                        "`title` VARCHAR(15) DEFAULT NULL, " +
                        "`author` VARCHAR(20) DEFAULT NULL, " +
                        "`status` VARCHAR(20) DEFAULT NULL, " +
                        "PRIMARY KEY (`id`)" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
                pstm = connection.prepareStatement(sql1);
                pstm.execute();

                // Create memberdetail table
                String sql2 = "CREATE TABLE `memberdetail` (" +
                        "`id` INT(11) NOT NULL, " +
                        "`name` VARCHAR(50) DEFAULT NULL, " +
                        "`address` VARCHAR(100) DEFAULT NULL, " +
                        "`contact` VARCHAR(12) DEFAULT NULL, " +
                        "PRIMARY KEY (`id`)" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
                pstm = connection.prepareStatement(sql2);
                pstm.execute();

                // Create issuetb table
                String sql3 = "CREATE TABLE `issuetb` (" +
                        "`issueId` VARCHAR(10) NOT NULL, " +
                        "`date` DATE DEFAULT NULL, " +
                        "`memberId` INT(10) DEFAULT NULL, " +
                        "`bookid` INT(10) DEFAULT NULL, " +
                        "PRIMARY KEY (`issueId`), " +
                        "CONSTRAINT FOREIGN KEY (`memberId`) REFERENCES `memberdetail` (`id`), " +
                        "CONSTRAINT FOREIGN KEY (`bookid`) REFERENCES `bookdetail` (`id`)" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
                pstm = connection.prepareStatement(sql3);
                pstm.execute();

                // Create returndetail table
                String sql4 = "CREATE TABLE `returndetail` (" +
                        "`id` INT(11) NOT NULL, " +
                        "`issuedDate` DATE NOT NULL, " +
                        "`returnedDate` DATE DEFAULT NULL, " +
                        "`fine` INT(10) DEFAULT NULL, " +
                        "`issueid` INT(10) DEFAULT NULL, " +
                        "PRIMARY KEY (`id`), " +
                        "CONSTRAINT FOREIGN KEY (`issueid`) REFERENCES `issuetb` (`issueId`)" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
                pstm = connection.prepareStatement(sql4);
                pstm.execute();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error initializing DB connection", e);
        }
    }

    public static DBConnection getInstance() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}
