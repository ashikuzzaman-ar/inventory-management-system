/**
 * Author model class
 */
package model;


/**
 * Represent a book author
 *
 * @author Jkosgei
 */
public class Author {

    private int authorId;
    private String firstName;
    private String lastName;

    /**
     * Initialize author
     *
     * @param authorId int
     * @param firstName String
     * @param lastName String
     */
    public Author(int authorId, String firstName, String lastName) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Get author id
     *
     * @return int
     */
    public int getAuthorId() {
        return authorId;
    }

    /**
     * Change author id
     *
     * @param authorId int
     */
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    /**
     * Get first name
     *
     * @return String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Change first name
     *
     * @param firstName String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get last name
     *
     * @return String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * change last name
     *
     * @param lastName String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Author id must be unique for author
     *
     * @param obj Object
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        return ((Author) obj).authorId == authorId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.authorId;
        return hash;
    }

    /**
     * Return string representing author
     *
     * @return String
     */
    @Override
    public String toString() {
        return String.format("%-12d%-15s%s", authorId, firstName, lastName);
    }

}
