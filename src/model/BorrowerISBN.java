/**
 * Mapping class for Borrowers and Title model classes
 */
package model;

import java.util.Objects;

/**
 *
 * @author Jkosgei
 */
public class BorrowerISBN {

    private int borrowerId;
    private String ISBN;
    private String pursueDate;
    private String returnDate;

    public BorrowerISBN() {
    }

    public BorrowerISBN(int borrowerId, String ISBN) {
        this.borrowerId = borrowerId;
        this.ISBN = ISBN;
    }

    public BorrowerISBN(int borrowerId, String ISBN, String pursueDate, String returnDate) {
        this.borrowerId = borrowerId;
        this.ISBN = ISBN;
        this.pursueDate = pursueDate;
        this.returnDate = returnDate;
    }

    public int getBorrowerId() {
        return borrowerId;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getPursueDate() {
        return pursueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.borrowerId;
        hash = 29 * hash + Objects.hashCode(this.ISBN);
        hash = 29 * hash + Objects.hashCode(this.pursueDate);
        hash = 29 * hash + Objects.hashCode(this.returnDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BorrowerISBN other = (BorrowerISBN) obj;
        if (this.borrowerId != other.borrowerId) {
            return false;
        }
        return Objects.equals(this.ISBN, other.ISBN);
    }
}
