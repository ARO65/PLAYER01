package mzk;

import java.util.*;

public class Runner {
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("album1", "AC/DC");

        album.addSong("sark1", 4.5);
        album.addSong("sark2", 3.5);
        album.addSong("sark3", 5.0);


        albums.add(album);


        album = new Album("album2", "eminem");
        album.addSong("sark4", 4.5);
        album.addSong("sark5", 3.5);
        album.addSong("sark6", 5.0);

        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("sark1", playList_1);
        albums.get(0).addToPlayList("sark2", playList_1);
        albums.get(1).addToPlayList("sark4 ", playList_1);
        albums.get(1).addToPlayList("sark6", playList_1);

        play(playList_1);
    }

    private static void play(LinkedList<Song> playList) {
        Scanner scan = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("mevcut sarkı lıstede yok");
        } else {
            System.out.println("şuan oynatılan " + listIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int ıslem = scan.nextInt();
            scan.nextLine();
            switch (ıslem) {

                case 0:
                    System.out.println("Calma lıstesi tamamlandı");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();

                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("suan calınan " + listIterator.next().toString());
                    } else {
                        System.out.println("listenın sonuna ulasıldı");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {

                        System.out.println("oynatılan sarkı " + listIterator.previous().toString());
                    } else {
                        System.out.println("ilk şarkımız");
                        forward = false;

                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("oynatılan sarkı " + listIterator.previous().toString());
                            forward = false;

                        } else {
                            System.out.println("listenın başı");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("oynatılan sarkı " + listIterator.next().toString());
                            forward = true;

                        } else {
                            System.out.println("listenın sonuna ulaştık");
                        }

                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("calınan sarkı " + listIterator.next().toString());

                        } else {
                            if (listIterator.hasPrevious()){
                                System.out.println("calınan sarkı "+listIterator.previous().toString());
                            }
                        }
                    }


            }
        }


    }


    private static void printMenu() {
        System.out.println("LUTFEN  SECİM YAPINIZ\n");
        System.out.println("0-cıkıs\n" +
                "1-sonraki sarkıya gecin\n" +
                "2-önceki sarkıya gecin\n" +
                "3-mevcut  sarkıyı tekrar dinle\n" +
                "4-tüm  sarkıların listesi\n" +
                "5-tüm  seceneklerın lıstesi\n" +
                "6-gecerli şarkıyı sil\n");
    }

    private static void printList(LinkedList<Song> playList) {

        Iterator<Song>iterator= playList.iterator();

        System.out.println("=============================");
        while (iterator.hasNext()) {

            System.out.println(iterator.next());

        }
        System.out.println("==============================");
    }
}
