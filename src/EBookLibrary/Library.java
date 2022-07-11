package EBookLibrary;

import java.util.*;

/**
 * Represents an Audio library, with individual Song titles, Podcasts and playlists.
 */
public class Library {
    private Optional<String> aName;
    private Optional<String> aDescription;
    private final ArrayList<EBook> aEBooks = new ArrayList<>();
    private final ArrayList<Comic> aPodcasts = new ArrayList<>();
    private static Library currentLibrary = new Library();
    // Design of the Library object uses the Singleton design pattern.

    private Library(){}

    public static Library getLibrary(){
        return currentLibrary;
    }

    /**
     * Initialize the aName and aDescription of the Library object
     * @param pName
     *              New name of the Library
     * @param pDescription
     *              New Description of the Library
     */
    public void initialize(String pName, String pDescription){
        assert(pName != null && pDescription != null);
        this.aName = Optional.of(pName);
        this.aDescription = Optional.of(pDescription);
    }


    /**
     * Adds your design of fields for Library
     *


    /**
     * Adds a Song to the library. Duplicate Songs aren't added twice.
     *
     * @param pBook the EBook to add
     */

    public void addBook(Book pBook) {
        // Please add you implementation here
        if (!this.aEBooks.contains(pBook)){
            this.aEBooks.add(pBook);
        }
        else{
            System.out.println("Error: song already exists in library");
        }
    }

    /**
     * Adds a PlayList to the library. All Songs from the list are also added as individual Songs to the library.
     *
     * @param pList
     *            the PlayList to add
     * @pre pList!=null;
     */
    public void addReadingList(ReadingList pList) {
       // Please add you implementation here
        assert(pList != null);
        if (!this.aEBooks.contains(pList)){
            this.aEBooks.add(pList);
            for (int i = 0; i < pList.getLength(); i++){
                EBook p = pList.getEBook(i).get();
                if (p instanceof Book){
                    this.addBook((Book) p);
                }
                else if (p != null){
                    if (!this.aEBooks.contains(p)){
                        this.aEBooks.add(p);
                    }
                }
            }
        }
        else{
            System.out.println("Error: duplicate playlist " + pList.getName() + " exists in library. ");
        }

    }

    /**
     * Adds a Podcast to the library. All Episodes from the list are also added as individual episodes to the library.
     *
     * @param pPodcast
     *            the Podcast to add
     * @pre pPodcast!=null;
     */
    public void addComic(Comic pPodcast) {
        // Please add you implementation here
        assert(pPodcast != null);
        if (!this.aPodcasts.contains(pPodcast)){
            this.aPodcasts.add(pPodcast);
            for (int i = 0; i < pPodcast.getLength(); i++){
                this.aEBooks.add(pPodcast.getChapter(i));
            }
        }
        else{
            System.out.println("Error: Duplicate podcast exists in library. ");
        }

    }

    /**
     * Change name of the library.
     *
     * @param pName
     *            the new name to use
     * @pre pName!=null;
     */

    public void addName(String pName){
        assert (pName != null);
        this.aName = Optional.of(pName);
    }
    /**
     * Change description of the library.
     *
     * @param pDescription
     *            the new description to use
     * @pre pDescription!=null;
     */

    public void addDescription(String pDescription){
        assert(pDescription != null);
        this.aDescription = Optional.of(pDescription);
    }

    /**
     * Check if a certain Playable object exists in the Library
     *
     * @param p
     *            the Playable object in question
     * @pre p!=null;
     */

    public boolean containsPlayable(EBook p){
        assert p != null;
        return this.aEBooks.contains(p);
    }

    public void playAll(){
        for (EBook p: aEBooks){
            p.read();
        }
    }
}
