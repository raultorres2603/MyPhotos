package classes.menus;

import classes.utility.Utilities;
import interfaces.menus.IMultimediaMenu;
import interfaces.utility.IUtility;
import java.io.File;
import java.util.Scanner;

public class MultimediaMenu implements IMultimediaMenu {
    private final String name;
    // TODO new property to handle if the user is on menu or not, by default OFF
    private boolean isOnMenu;
    private final Scanner userInput = new Scanner(System.in);
    private final IUtility utilidades = new Utilities();

    public MultimediaMenu() {
        this.name = "MultimediaMenu";
     
        this.isOnMenu = false;
    }

     private void listThings(String type) {
        File folder;
        if (type.contains("photo")) {
            folder = new File(System.getProperty("user.home") + File.separator + "Pictures");
        } else if (type.contains("video")) {
            folder = new File(System.getProperty("user.home") + File.separator + "Videos");
        } else {
            System.out.println("Tipo no reconocido: " + type);
            return;
        }

        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            for (int i = 0; i < listOfFiles.length; i++) {
                boolean isValid = type.contains("photo") ? utilidades.fileIsPhoto(listOfFiles[i]) : utilidades.fileIsVideo(listOfFiles[i]);
                
                if (isValid) {
                    System.out.println(i + ". " + listOfFiles[i].getName());
                }
            }
        }
        
    }  
     @Override
    public void listPhotos() {
        listThings("photograph");
    }
    
    @Override
    public void listVideos() {
       listThings("videograph");
    }

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

    }

}
