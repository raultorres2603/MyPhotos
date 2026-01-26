package classes.menus;

import java.io.File;
import interfaces.menus.IMultimediaMenu;

public class MultimediaMenu implements IMultimediaMenu {
    private final String name;
    // TODO new property to handle if the user is on menu or not, by default OFF

    public MultimediaMenu() {
        this.name = "MultimediaMenu";
        // TODO Initialize property if the user is here or not by default to false
    }
//C:/Users/amata/Documents
    public void listPhotos() {
        File folder = new File(System.getProperty("user.home")+File.separator+"Pictures");
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (fileIsPhoto(listOfFiles[i])) {
                    System.out.println(i + ". " + listOfFiles[i].getName());
                } 
            }
        }
    }

    private boolean fileIsVideo(File file) {
        String fileName = file.getName().toLowerCase();
        return fileName.endsWith(".mp4") || fileName.endsWith(".avi") || fileName.endsWith(".mkv");
    }

    private boolean fileIsPhoto(File file) {
        String fileName = file.getName().toLowerCase();
        return fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".gif");
    }
    public void listVideos() {
        File folder = new File(System.getProperty("user.home")+File.separator+"Videos");
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (fileIsVideo(listOfFiles[i])) {
                    System.out.println(i + ". " + listOfFiles[i].getName());
                }
            }
        }
    }

    public void showMultimediaMenu() {
        // TODO Handle the menu display
        // If user is on menu, concurrent in time being here, menu display
        System.out.println("Welcome to " + this.name + ": Photos");

    };

}
