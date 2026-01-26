package classes;

import java.io.File;
import interfaces.IMultimediaMenu;

public class MultimediaMenu implements IMultimediaMenu {
    private final String name;

    private MultimediaMenu() {
        this.name = "MultimediaMenu";
    }
//C:/Users/amata/Documents
    public void listPhotos() {
        File folder = new File(System.getProperty("user.home")+File.separator+"Pictures");
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } 
            }
        }

    }

    public void listVideos() {
        File folder = new File(System.getProperty("user.home")+File.separator+"Videos");
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        }
    }

    public void showMultimediaMenu() {
        System.out.println("Welcome to " + this.name + ": Photos");

    };

}
