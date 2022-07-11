package EBookLibrary;
import java.util.*;


public class ReadingList implements EBook {

    private final List<EBook> aList = new LinkedList<>();
    private String aName;
    private int aNext;

    /**
     * Creates a new empty ReadingList.
     *
     * @param pName
     *            the name of the list
     * @pre pName!=null;
     */
    public ReadingList(String pName) {
        assert pName != null;
        aName = pName;
        aNext = 0;
    }

    /**
     * Adds a EBook at the end of this ReadingList.
     *
     * @param pEBook
     *            the content to add to the list
     * @pre pEBook !=null;
     */
    public void addEBook(EBook pEBook) {
        assert pEBook != null;
        aList.add(pEBook);
    }



    @Override
    public void read() {
        System.out.println("Now playing: " + this.aName);
        for (int i = this.aNext; i < this.aList.size(); i++){
            this.aList.get(i).read();
        }
    }

    /**
     * Plays all EBook objects in the ReadingList in order.
     */

    public void readInOrder(){
        System.out.println("Now playing: " + this.aName);
        for (int i = 0; i < this.aList.size(); i++){
            this.aList.get(i).read();
        }
    }

    /**
     * Check equality between this ReadingList object and another object
     *
     * @param o
     *            the object to compare against
     */


    @Override
    public boolean equals(Object o){
        if (o instanceof ReadingList) {
            ReadingList p = (ReadingList) o;
            boolean contentEqual = true;
            if (this.aList.size() != p.aList.size()){
                return false;
            }
            else if (this.aList.size() == p.aList.size() && this.aList.size() == 0){
                return true;
            }
            else {
                for (int i = 0; i < this.aList.size(); i++) {
                    if (this.aList.get(i) != p.aList.get(i)) {
                        contentEqual = false;
                        break;
                    }
                }
                return contentEqual;
            }
        }
        else{
            return false;
        }
    }

    /**
     * Return a EBook object at specified index
     *
     * @param pIndex
     *            the index of the EBook object to return
     */

    public Optional<EBook> getEBook(int pIndex){
        try {
            return Optional.of(this.aList.get(pIndex));
        }
        catch(IndexOutOfBoundsException e){
            return Optional.of(null);
        }
    }

    public String getName(){
        return this.aName;
    }

    protected int getLength(){
        return this.aList.size();
    }

}
