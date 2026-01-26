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
        System.out.println("Welcome to " + this.name + ": Photos");

    };

}
