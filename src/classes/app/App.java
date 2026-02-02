package classes.app;

import classes.menus.MultimediaMenu;
import classes.menus.UploadMenu;
import interfaces.app.IApp;
import java.util.Scanner;
 //Optimizar codigo, tanto en videos como en fotos. Automatizar y crear un metodo generico que dependiendo del tipo
    //de archivo haga una cosa u otra, en temas como el path, el folder del servidor, subir archivo.
public class App implements IApp {
    private boolean isOn;
    private final String name;
    private final Scanner userInput = new Scanner(System.in);

    private final MultimediaMenu multimediaMenu;
    private final UploadMenu uploadMenu;



    public App(String appName) {
        this.isOn = false;
        this.name = appName;
        this.multimediaMenu = new MultimediaMenu();
        this.uploadMenu = new UploadMenu();
    }
    /*
    public App() {
        this.isOn = false;
        this.name = "DefaultApp";
    }
    */

    private boolean isOn() {
        return this.isOn;
    }

    /**
     * Sets the state of the app (on/off).
     * @param state The desired state of the app.
     */
    private void setIsOn(boolean state) {
        this.isOn = state;
        System.out.println("App " + this.name + " is now " + (this.isOn() ? "ON" : "OFF"));
    }
    //no entiendo porque no me pide el @override
    @Override
    public void turnOn() {
        System.out.println("Turning on the app: " + this.name);
        this.setIsOn(true);
        this.showPrincipalMenu();
    }

    private String getName() {
        return this.name;
    }
    //no entiendo porque no me pide el @override
    @Override
    public void showPrincipalMenu() {
        System.out.println("Welcome to " + this.getName());
        System.out.println("Select an option:");
        while (this.isOn()) {
            System.out.println("1. List multimedia files");
            System.out.println("2. Upload multimedia file");
            System.out.println("3. Turn Off " + this.getName());
            int userChoice = userInput.nextInt();
            switch (userChoice) {
                case 1 -> // Creates a new interface for MultimediaMenu to implement named IMultimediaMenu
                    // Create a new class of MultimediaMenu to handle this
                    // Creates a new MultimediaMenu and lists the files
                    multimediaMenu.showMultimediaMenu();
                case 2 -> // Creates a new interface for UploadMenu to implement named IUploadMenu
                    // Creates a new UploadMenu and then, will ask for file to upload
                    // Creates a new class of UploadMenu to handle this
                    uploadMenu.showUploadMenu();
                case 3 -> this.turnOff();
                default -> System.out.println("Invalid option. Please try again.");
            }
        }

    }
    //no entiendo porque no me pide el @override
    @Override
    public void turnOff() {
        setIsOn(false);
    }

    private MultimediaMenu getMultimediaMenu() {
        return multimediaMenu;
    }

    private UploadMenu getUploadMenu() {
        return uploadMenu;
    }
}

// App app = new App("MyPhotos");
// App app2 = new App();
// app.turnOn();
// app.isOn(); // true