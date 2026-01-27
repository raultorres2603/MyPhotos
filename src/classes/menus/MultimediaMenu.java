package classes.menus;

import interfaces.menus.IMultimediaMenu;
import java.io.File;
import java.util.Scanner;

public class MultimediaMenu implements IMultimediaMenu {
    private final String name;
    // TODO new property to handle if the user is on menu or not, by default OFF
    private boolean isOnMenu;
    private final Scanner userInput = new Scanner(System.in);

    public MultimediaMenu() {
        this.name = "MultimediaMenu";
        // TODO Initialize property if the user is here or not by default to false
        this.isOnMenu = false;
    }
//C:/Users/amata/Documents
//no entiendo porque no me pide el @override
    @Override
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
    //no entiendo porque no me pide el @override
    @Override
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
    //no entiendo porque no me pide el @override
    @Override
    public void showMultimediaMenu() {
        // TODO Handle the menu display
        // If user is on menu, concurrent in time being here, menu display
        System.out.println("Welcome to " + this.name + ": Photos");
        System.out.println("Select an option:");
        isOnMenu = true;
        while (isOnMenu) {
            System.out.println("1. List Photos.");
            System.out.println("2. List Videos.");
            System.out.println("3. Exit to Principal Menu.");
            int opcio = userInput.nextInt();
             switch (opcio) {
                 case 1 -> listPhotos();
                 case 2 -> listVideos();
                 case 3 -> {
                     System.out.println("Exiting to Principal Menu.");
                     isOnMenu = false;
                 }
                 default -> System.out.println("Invalid option. Please try again.");
             }
        }

    };

}
