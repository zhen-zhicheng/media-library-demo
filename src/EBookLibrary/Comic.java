package EBookLibrary;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Comic{

    private String aName;
    private String aAuthor;
    private List<ComicChapter> aChapters = new ArrayList<>();

    /**
     * Create a new Podcast object
     * @param pName
     *              Name of the new Comic
     * @param pAuthor
     *              Author of the new Comic
     * @pre pName != null && pAuthor != null
     */
    private Comic(String pName, String pAuthor){
        assert (pName != null && pAuthor != null);
        this.aName = pName;
        this.aAuthor = pAuthor;
    }

    /**
     * Get new Podcast object from the Flyweight PodcastFactory
     * @param pName
     *              Name of the new Comic
     * @param pAuthor
     *              Author of the new Comic
     * @pre pName != null && pAuthor != null
     */

    public static Comic createComic (String pName, String pAuthor){
        ComicFactory.createComic(pName, pAuthor);
        return ComicFactory.getComic(pName,pAuthor);
    }


    /**
     * Add one chapter of comic
     * @param pChapter
     *              title of the new episode to add
     * @pre
     */
    protected void addChapter(ComicChapter pChapter) {
        if(!aChapters.contains(pChapter)) {
            aChapters.add(pChapter);
        }
    }

    /**
     * return one chapter from the comic
     * @param pIndex
     *
     */

    public ComicChapter getChapter(int pIndex) {
       //
        try {
            return this.aChapters.get(pIndex);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index. ");
            return null;
        }
    }


    public String getName() {
        return aName;
    }


    public String getHost() {
        return aAuthor;
    }


    public boolean equals(Object o) {
        if (o instanceof Comic) {
            Comic p = (Comic) o;
            return (this.aAuthor.equalsIgnoreCase(p.aAuthor)
                    && (this.aName.equalsIgnoreCase(p.aName)));
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        return (this.aName + this.aAuthor).hashCode();
    }
    public int getLength(){
        return this.aChapters.size();
    }


    public class ComicFactory{
        protected static HashMap<String, Comic> ComicMap = new HashMap<>();

        /**
         * Create new Comic object in the Flyweight ComicFactory
         * @param pName
         *              Name of the new Comic
         * @param pAuthor
         *              Author of the new Comic
         */
        public static void createComic(String pName, String pAuthor){
            if (ComicMap.get((pName + "|" + pAuthor).toLowerCase()) == null) {
                ComicMap.put((pName + "|" + pAuthor).toLowerCase(), new Comic(pName, pAuthor));
            }
            else{
                System.out.println("Error: comic \"" +  pName + " \\ " + pAuthor + "\" already exists. ");
            }
        }

        /**
         * Get a specified Podcast object in the Flyweight ComicFactory; create new one if none exists
         * @param pName
         *              Name of the Comic
         * @param pAuthor
         *              Author of the Comic
         */
        public static Comic getComic(String pName, String pAuthor){
            assert (pName != null && pAuthor != null);
            if (ComicMap.get((pName + "|" + pAuthor).toLowerCase()) == null) {
                createComic(pName, pAuthor);
                return ComicMap.get((pName + "|" + pAuthor).toLowerCase());
            }
            else{
                return ComicMap.get((pName + "|" + pAuthor).toLowerCase());
            }
        }
    }
}