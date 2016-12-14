package service;

import java.io.Closeable;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Admin;

public class Database implements Serializable, Closeable {

    /**
     * Main database constants for connection - for ease of access and change
     */
    private static final String USER_NAME = "root";//change username to your username
    private static final String PASSWORD = "studevsdb";//change password to your password
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "BOOKS";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private Statement statement;
    private Connection connection = null;
    private ResultSet resultSet = null;
    private String sql;

    public Database() {

        try {

            //load mysql driver
            Class.forName(DRIVER);
            //connect to mysql database with username and password
            this.connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            this.statement = this.connection.createStatement();
            createDataBase(); // create database
        } catch (ClassNotFoundException ex) {

            JOptionPane.showMessageDialog(null, ex); // show error if ar not added to project
            System.exit(0);
        } catch (SQLException ex) { // if database exist

            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /**
     * This method is executed when user run program for first time only to
     * create database and tables
     */
    private void createDataBase() {

        try {

            //if no database named inventor then create it
            this.statement.execute("CREATE DATABASE IF NOT EXISTS " + DB_NAME + " DEFAULT CHARACTER SET utf8");
            this.statement.execute("USE BOOKS");

            //create the tables if not exists (authors, authorISBN and Titles)
//            st.execute("CREATE TABLE IF NOT EXISTS BOOKS.Authors ("
//                    + "authorId INTEGER PRIMARY KEY NOT NULL,"
//                    + "firstName VARCHAR(50) NOT NULL,"
//                    + "lastName VARCHAR(50) NOT NULL)"
//            );
//
//            st.execute("CREATE TABLE IF NOT EXISTS BOOKS.Titles ("
//                    + "ISBN VARCHAR(50) PRIMARY KEY NOT NULL,"
//                    + "title VARCHAR(50) NOT NULL,"
//                    + "editionNumber INTEGER NOT NULL,"
//                    + "copyright VARCHAR(50) NOT NULL)"
//            );
//
//            st.execute("CREATE TABLE IF NOT EXISTS BOOKS.AuthorISBN ("
//                    + "authorId INTEGER, "
//                    + "ISBN VARCHAR(50), "
//                    + "FOREIGN KEY (authorId) REFERENCES BOOKS.Authors(authorId), "
//                    + "FOREIGN KEY (ISBN) REFERENCES BOOKS.Titles(ISBN))"
//            );
            this.statement.execute("CREATE TABLE `BOOKS`.`ADMIN` (\n"
                    + "  `ID` INT NOT NULL AUTO_INCREMENT,\n"
                    + "  `USERNAME` VARCHAR(20) NOT NULL,\n"
                    + "  `PASSWORD` VARCHAR(200) NOT NULL,\n"
                    + "  `EMAIL` VARCHAR(45) NOT NULL,\n"
                    + "  `ROLE` VARCHAR(10) NOT NULL,\n"
                    + "  PRIMARY KEY (`ID`),\n"
                    + "  UNIQUE INDEX `USERNAME_UNIQUE` (`USERNAME` ASC),\n"
                    + "  UNIQUE INDEX `EMAIL_UNIQUE` (`EMAIL` ASC))");

//            //insert authors
//            st.executeUpdate("INSERT INTO BOOKS.Authors VALUES(1,'Paul','Deitel')");
//            st.executeUpdate("INSERT INTO BOOKS.Authors VALUES(2,'Harvey','Deitel')");
//            st.executeUpdate("INSERT INTO BOOKS.Authors VALUES(3,'Abbey','Deitel')");
//            st.executeUpdate("INSERT INTO BOOKS.Authors VALUES(4,'Michael','Morgano')");
//            st.executeUpdate("INSERT INTO BOOKS.Authors VALUES(5,'Eric','Kern')");
//            //insert titles
//            st.executeUpdate("INSERT INTO BOOKS.Titles VALUES('0132152134','Visual Basic 2010 How to Program',5,'2011')");
//            st.executeUpdate("INSERT INTO BOOKS.Titles VALUES('0132151421','Visual C# 2010 How to Program',4,'2011')");
//            st.executeUpdate("INSERT INTO BOOKS.Titles VALUES('0132575663','Java How to Program',9,'2012')");
//            st.executeUpdate("INSERT INTO BOOKS.Titles VALUES('0132662361','C++ How to Program',8,'2012')");
//            st.executeUpdate("INSERT INTO BOOKS.Titles VALUES('0132404168','C How to Program',6,'2010')");
//            st.executeUpdate("INSERT INTO BOOKS.Titles VALUES('013705842X','iPhone for Programmers: An AppDriven Approach',1,'2010')");
//            st.executeUpdate("INSERT INTO BOOKS.Titles VALUES('0132121360','Android for Programmers: An AppDriven Approach',1,'2012')");
//            //insert authorISBN
//            st.executeUpdate("INSERT INTO BOOKS.AuthorISBN VALUES(1,'0132152134')");
//            st.executeUpdate("INSERT INTO BOOKS.AuthorISBN VALUES(2,'0132152134')");
//            st.executeUpdate("INSERT INTO BOOKS.AuthorISBN VALUES(1,'0132151421')");
//            st.executeUpdate("INSERT INTO BOOKS.AuthorISBN VALUES(2,'0132151421')");
//            st.executeUpdate("INSERT INTO BOOKS.AuthorISBN VALUES(1,'0132575663')");
//            st.executeUpdate("INSERT INTO BOOKS.AuthorISBN VALUES(2,'0132575663')");
//            st.executeUpdate("INSERT INTO BOOKS.AuthorISBN VALUES(1,'0132662361')");
//            st.executeUpdate("INSERT INTO BOOKS.AuthorISBN VALUES(2,'0132662361')");
//            st.executeUpdate("INSERT INTO BOOKS.AuthorISBN VALUES(1,'0132404168')");
//            st.executeUpdate("INSERT INTO BOOKS.AuthorISBN VALUES(2,'0132404168')");
//            st.executeUpdate("INSERT INTO BOOKS.AuthorISBN VALUES(1,'013705842X')");
//            st.executeUpdate("INSERT INTO BOOKS.AuthorISBN VALUES(2,'013705842X')");
//            st.executeUpdate("INSERT INTO BOOKS.AuthorISBN VALUES(3,'013705842X')");
//            st.executeUpdate("INSERT INTO BOOKS.AuthorISBN VALUES(4,'013705842X')");
//            st.executeUpdate("INSERT INTO BOOKS.AuthorISBN VALUES(5,'013705842X')");
//            st.executeUpdate("INSERT INTO BOOKS.AuthorISBN VALUES(1,'0132121360')");
//            st.executeUpdate("INSERT INTO BOOKS.AuthorISBN VALUES(2,'0132121360')");
//            st.executeUpdate("INSERT INTO BOOKS.AuthorISBN VALUES(3,'0132121360')");
//            st.executeUpdate("INSERT INTO BOOKS.AuthorISBN VALUES(4,'0132121360')");
            //Inserting Master Admin
            this.statement.execute("INSERT INTO `BOOKS`.`ADMIN` (`USERNAME`, `PASSWORD`, `EMAIL`, `ROLE`) VALUES ('arif', 'arif123', 'arifshuvo50@gmail.com', 'master')");
            this.statement.execute("INSERT INTO `BOOKS`.`ADMIN` (`USERNAME`, `PASSWORD`, `EMAIL`, `ROLE`) VALUES ('ashif', 'ashif123', 'ashif.rahaman@hotmail.com', 'master')");
        } catch (SQLException e) {
            //if insert cause an issue do nothing
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public Admin selectAdminFromUsername(String username) {

        Admin admin = null;

        try {

            this.sql = "SELECT * FROM BOOKS.ADMIN WHERE BOOKS.ADMIN.USERNAME = '" + username + "'";
            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery(this.sql);
            if (this.resultSet.next()) {

                admin = new Admin(this.resultSet.getInt(1), this.resultSet.getString(2), this.resultSet.getString(3), this.resultSet.getString(4), this.resultSet.getString(5));
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

        return admin;
    }

    /**
     * Select all authors from database
     *
     * @return ArrayList<Author>
     */
//    public List<Author> selectAllAuthors() {
//        try {
//            String query = "SELECT * FROM BOOKS.Authors";
//            List<Author> authors = new ArrayList<>();
//            st = conn.createStatement(); // create statement
//            rs = st.executeQuery(query); // execute query
//            //read authors
//            while (rs.next()) {
//                int authorID = rs.getInt(1);
//                String firstName = rs.getString(2);
//                String lastName = rs.getString(3);
//                Author author = new Author(authorID, firstName, lastName);
//                authors.add(author); // add to arralist
//            }
//            return authors;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
    /**
     * Select a specific author and list all books for that author. Include each
     * book’s title, year, and ISBN. Order the information chronologically.
     *
     * @param authorId Author
     * @return List<Title>
     */
//    public List<Title> selectTitlesForAuthor(int authorId) {
//        try {
//            String query = "SELECT * FROM BOOKS.Titles"
//                    + " INNER JOIN AuthorISBN"
//                    + " ON Titles.ISBN = AuthorISBN.ISBN"
//                    + " Where AuthorISBN.authorId = " + authorId
//                    + " Order By Titles.copyright;";
//            List<Title> titles = new ArrayList<>();
//            st = conn.createStatement(); // create statement
//            rs = st.executeQuery(query); // execute query
//            //read authors
//            while (rs.next()) {
//                String ISBN = rs.getString(1);
//                String title = rs.getString(2);
//                int edition = rs.getInt(3);
//                String copyright = rs.getString(4);
//                Title titleObj = new Title(ISBN, title, edition, copyright);
//                titles.add(titleObj); // add to arralist
//            }
//            return titles;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
    /**
     * Select a specific title and list all authors for that title. Order the
     * authors alphabetically by last name and then by first name
     *
     * @param title String
     * @return List<Author>
     */
//    public List<Author> selectAuthorsForTitle(String title) {
//        try {
//            String query = "SELECT DISTINCT Authors.authorId, Authors.firstName, Authors.lastName"
//                    + " FROM Authors, Titles, AuthorISBN"
//                    + " WHERE ("
//                    + " (Titles.ISBN = AuthorISBN.ISBN and AuthorISBN.authorId = Authors.authorId)"
//                    + " AND"
//                    + " Titles.title LIKE '%" + title + "%'"
//                    + ")"
//                    + " ORDER BY Authors.lastName, Authors.firstName" + ";";
//            List<Author> authors = new ArrayList<>();
//            st = conn.createStatement(); // create statement
//            rs = st.executeQuery(query); // execute query
//            //read authors
//            while (rs.next()) {
//                int authorID = rs.getInt(1);
//                String firstName = rs.getString(2);
//                String lastName = rs.getString(3);
//                Author author = new Author(authorID, firstName, lastName);
//                authors.add(author); // add to arralist
//            }
//            return authors;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
    /**
     * Select all Authors from database with respect of their published books
     * authors alphabetically by last name and then by first name
     *
     *
     * @return List<List<String>>
     */
//    public List<List<String>> selectAuthorsRanking() {
//        try {
//            List<List<String>> authorsRanking = new ArrayList<>();
//            String query = "SELECT Authors.authorId, Authors.firstName, Authors.lastName, COUNT(AuthorISBN.ISBN) "
//                    + " FROM Authors, AuthorISBN "
//                    + " WHERE Authors.authorId = AuthorISBN.authorId "
//                    + " GROUP BY Authors.authorId "
//                    + " ORDER BY Authors.authorId, Authors.lastName, Authors.firstName "
//                    + ";";
//            st = conn.createStatement(); // create statement
//            rs = st.executeQuery(query); // execute query
//            //read authors
//            while (rs.next()) {
//                List<String> authors = new ArrayList<>();
//                authors.add(rs.getString(1));
//                authors.add(rs.getString(2));
//                authors.add(rs.getString(3));
//                authors.add(rs.getString(4));
//                authorsRanking.add(authors); // add to arralist
//            }
//            return authorsRanking;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
    /**
     * Select all Authors from database with respect of their book popularity
     * authors alphabetically by last name and then by first name
     *
     * @param title String
     * @return ArrayList<ArrayList<String>>
     */
//    public List<List<String>> selectAuthorsRanking(String title) {
//        try {
//            List<List<String>> authorsRanking = new ArrayList<>();
//            String query = "SELECT Authors.authorId, Authors.firstName, Authors.lastName, Titles.title, Titles.editionNumber "
//                    + " FROM Authors, Titles , AuthorISBN "
//                    + " WHERE Authors.authorId = AuthorISBN.authorId AND AuthorISBN.ISBN = Titles.ISBN AND Titles.title LIKE '%" + title + "%' "
//                    + " ORDER BY Titles.title, Titles.editionNumber, Authors.lastName, Authors.firstName "
//                    + ";";
//            st = conn.createStatement(); // create statement
//            rs = st.executeQuery(query); // execute query
//            //read authors
//            while (rs.next()) {
//                List<String> authors = new ArrayList<>();
//                authors.add(rs.getString(1));
//                authors.add(rs.getString(2));
//                authors.add(rs.getString(3));
//                authors.add(rs.getString(4));
//                authors.add(rs.getString(5));
//                authorsRanking.add(authors); // add to arralist
//            }
//            return authorsRanking;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
    /**
     * Close all connection
     *
     *
     */
    @Override
    public void close() {

        try {

            this.connection.close();
        } catch (SQLException e) {

            throw new ExceptionInInitializerError(e);
        }
    }
}
