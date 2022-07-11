package EBookLibrary;
/**
 * Represents a single episode, with at least a title, and an episode number.
 */
public class ComicChapter implements EBook {

    private final Comic aComic;
    private final String aTitle;
    private final int aChapterNumber;

    /**
     * Creates an episode
     *
     * @param pComic
     *            Podcast that this episode is a part of
     * @param pTitle
     *            title of the episode
     * @param pChapterNumber
     *            the episode number that identifies the episode
     * @pre   pPodcast != null && pTitle!=null
     * @throws IllegalArgumentException
     */
    ComicChapter(Comic pComic, String pTitle, int pChapterNumber) {
        assert (pComic != null) && (pTitle != null);
        aComic = pComic;
        aTitle = pTitle;
        aChapterNumber = pChapterNumber;
        aComic.addChapter(this);
    }

    public Comic getaPodcast() {
        return aComic;
    }

    public String getaTitle() {
        return aTitle;
    }

    public int getaEpisodeNumber() {
        return aChapterNumber;
    }

    @Override
    public void read() {
        System.out.println("Now reading " + aComic.getName() + " [" + aChapterNumber + "]: " + aTitle);
    }


}
