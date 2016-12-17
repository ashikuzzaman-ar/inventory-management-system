package model;

import java.util.Objects;


/**
 * Represent a book title
 *
 * @author
 */
public class Title {

    private String ISBN;
    private String title;
    private int editionNumber;
    private String copyRight;
    private int totalNumber ;

    /**
     * Initialize title
     *
     * @param ISBN String
     * @param title String
     * @param editionNumber int
     * @param copyRight String
     */
    public Title(String ISBN, String title, int editionNumber, String copyRight) {
        this.ISBN = ISBN;
        this.title = title;
        this.editionNumber = editionNumber;
        this.copyRight = copyRight;
    }
    
    public Title(String ISBN, String title, int editionNumber, String copyRight, int totalNumber) {
        this.ISBN = ISBN;
        this.title = title;
        this.editionNumber = editionNumber;
        this.copyRight = copyRight;
        this.totalNumber = totalNumber;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    /**
     * Get ISBN
     *
     * @return String
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Change ISBN
     *
     * @param ISBN String
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Get title
     *
     * @return String
     */
    public String getTitle() {
        return title;
    }

    /**
     * Change title
     *
     * @param title String
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    /**
     * Get book edition
     *
     * @return int
     */
    public int getEditionNumber() {
        return editionNumber;
    }

    /**
     * Change book eidtion
     *
     * @param editionNumber int
     */
    public void setEditionNumber(int editionNumber) {
        this.editionNumber = editionNumber;
    }

    /**
     * Get copyright
     *
     * @return String
     */
    public String getCopyRight() {
        return copyRight;
    }

    /**
     * Change copyright
     *
     * @param copyRight void
     */
    public void setCopyRight(String copyRight) {
        this.copyRight = copyRight;
    }

    /**
     * Title's primary key is ISBN, must be unique
     *
     * @param obj Object
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        return ((Title) obj).ISBN.equals(ISBN);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.ISBN);
        return hash;
    }

    /**
     * Return string representing title
     *
     * @return String
     */
    @Override
    public String toString() {
        return String.format("%-60s%-10s%-15s", title, copyRight, ISBN);
    }

}
