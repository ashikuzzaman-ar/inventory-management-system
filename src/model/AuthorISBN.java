/**
 * Mapping class for Author and Title
 */
package model;


public class AuthorISBN {

    private int authorId;
    private String ISBN;

    /**
     * Initialize AuthorISBN
     *
     * @param authorId int
     * @param ISBN String
     */
    public AuthorISBN(int authorId, String ISBN) {
        this.authorId = authorId;
        this.ISBN = ISBN;
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
     * Return String representing AuthorISBN
     *
     * @return String
     */
    @Override
    public String toString() {
        return String.format("%-12d%s", authorId, ISBN);
    }

}
