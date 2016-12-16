/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ashik
 */
public class BorrowerISBN {
    
    private int borrowerId ;
    private String ISBN ;
    private Date pursueDate ;
    private Date returnDate ;

    public BorrowerISBN() {
    }

    public BorrowerISBN(int borrowerId, String ISBN, Date pursueDate, Date returnDate) {
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

    public Date getPursueDate() {
        return pursueDate;
    }

    public Date getReturnDate() {
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
        if (!Objects.equals(this.ISBN, other.ISBN)) {
            return false;
        }
        if (!Objects.equals(this.pursueDate, other.pursueDate)) {
            return false;
        }
        return Objects.equals(this.returnDate, other.returnDate);
    }
}
