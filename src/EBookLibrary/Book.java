package EBookLibrary;

import java.util.HashMap;

/**
 * Represents a single Book, with at least a title, and an author name.
 */
public class Book implements EBook{

    private String aTitle;
    private String aAuthor;


    /**
     * Create a Song object; can only be called by the SongFactory
     * @param pTitle
     *              Title of the new Song
     * @param pAuthor
     *              Artist of the new Song
     */
     private Book(String pTitle, String pAuthor){
        assert (pTitle != null && pAuthor != null);
        this.aTitle = pTitle;
        this.aAuthor = pAuthor;
    }

    /**
     * Get a new Song object from the Flyweight SongFactory
     * @param pTitle
     *              Title of the new Song
     * @param pAuthor
     *              Artist of the new Song
     */

    public static Book createSong(String pTitle, String pAuthor){
        assert (pTitle != null && pAuthor != null);
        BookFactory.createBook(pTitle, pAuthor);
        return BookFactory.getBook(pTitle, pAuthor);
    }

    public void read() {
        // Stub; actual functionality not implemented
        System.out.println("Reading " + aTitle + "by" + aAuthor);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Book){
            Book s1 = (Book) o;
            return ((this.aTitle.equalsIgnoreCase(s1.aTitle)) && (this.aAuthor.equalsIgnoreCase(s1.aAuthor)));
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        return (aAuthor + aTitle).hashCode();
    }

    public class BookFactory{
         protected static HashMap<String, Book> BookMap = new HashMap<>();

        /**
         * Create a new Song object in the Flyweight SongFactory
         * @param pTitle
         *              Title of the new Song
         * @param pAuthor
         *              Artist of the new Song
         */

         public static void createBook(String pTitle, String pAuthor){
             if (BookMap.get((pTitle + "|" + pAuthor).toLowerCase()) == null) {
                 BookMap.put((pTitle + "|" + pAuthor).toLowerCase(), new Book(pTitle, pAuthor));
             }
             else{
                 System.out.println("Error: book \"" +  pTitle + " \\ " + pAuthor + "\" already exists. ");
             }
         }

        /**
         * Get a specified Song object in the Flyweight SongFactory; create new one if none exists
         * @param pTitle
         *              Title of the Song
         * @param pAuthor
         *              Artist of the Song
         */

         public static Book getBook(String pTitle, String pAuthor){
             assert (pTitle != null && pAuthor != null);
             if (BookMap.get((pTitle + "|" + pAuthor).toLowerCase()) == null) {
                 createSong(pTitle, pAuthor);
                 return BookMap.get((pTitle + "|" + pAuthor).toLowerCase());
             }
             else{
                 return BookMap.get((pTitle + "|" + pAuthor).toLowerCase());
             }
         }

    }

}