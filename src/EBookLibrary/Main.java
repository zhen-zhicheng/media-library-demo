package EBookLibrary;

public class Main {
    public static void main(String[] args) {
        Library mainLibrary = Library.getLibrary();
        mainLibrary.initialize("Egg.", "Egg.");

        // Testing Book creation and duplicate Books

        Book s1 = Book.createSong("Court of the Crimson King", "King Crimson");
        Book s2 = Book.createSong("Court of the Crimson King", "King Crimson");
        Book s3 = Book.createSong("I Want to Become a Girl", "Mafumafu");
        mainLibrary.addBook(s1);
        mainLibrary.addBook(s2);
        mainLibrary.addBook(s3);

        //Testing Comic creation and duplicate Comics

        Comic p1 = Comic.createComic("CCTV 96h News (wtf)", "[Totally a human]");
        Comic p2 = Comic.createComic("CCTV 96h News (WTF)", "[Totally a human]");
        Comic p3 = Comic.createComic("Occult Rituals: Fun With the Whole Family", "[Redacted]");

        ComicChapter ep1 = new ComicChapter(p1,"SCP-[Redacted] Breached Containment", 114);
        ComicChapter ep2 = new ComicChapter(p1,"Mongolian Navy Defeats Godzilla", 514);
        ComicChapter ep3 = new ComicChapter(p3,"How to Borrow Strength From Eldritch Forces", 1919);
        ReadingList pl1 = new ReadingList("Blorbo");
        ReadingList pl2 = new ReadingList("Horse Plinko");
        ReadingList pl3 = new ReadingList("Blorbo");
        p1.addChapter(ep1); p1.addChapter(ep2);

        pl1.addEBook(ep2); pl1.addEBook(s2); pl1.addEBook(ep3); pl1.addEBook(s3); pl1.addEBook(ep1);

        pl2.addEBook(ep2); pl2.addEBook(s2); pl2.addEBook(ep3); pl2.addEBook(s3); pl2.addEBook(ep1);

        System.out.println("Playlist Equality Test: content equal but name different: \n >  " + pl1.equals(pl2));
        System.out.println("Playlist Equality Test: name equal but content different: \n >  " + pl1.equals(pl3));
        pl1.read();



        mainLibrary.addComic(p1);
        mainLibrary.addComic(p2);
        mainLibrary.addReadingList(pl1);
        mainLibrary.addReadingList(pl2);
        mainLibrary.playAll();





    }
}
