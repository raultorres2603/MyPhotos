package Classes;


import Interfaces.IApp;
import java.util.Scanner;

public class App implements IApp {
    private boolean isOn;
    private final String name;
    private final Scanner userInput = new Scanner(System.in);

    public App(String appName) {
        this.isOn = false;
        this.name = appName;
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

    private void setIsOn(boolean state) {
        this.isOn = state;
        System.out.println("App " + this.name + " is now " + (this.isOn() ? "ON" : "OFF"));
    }

    public void turnOn() {
        System.out.println("Turning on the app: " + this.name);
        this.setIsOn(true);
        this.showPrincipalMenu();
    }

    private String getName() {
        return this.name;
    }

    public void showPrincipalMenu() {
        System.out.println("Welcome to " + this.getName());
        System.out.println("Select an option:");
        while (this.isOn()) {
            System.out.println("1. List multimedia files");
            System.out.println("2. Upload multimedia file");
            System.out.println("3. Turn Off " + this.getName());
            int userChoice = userInput.nextInt();
            switch (userChoice) {
                case 1:
                    System.out.println("You selected Option 1");
                    // Creates a new interface for MultimediaMenu to implement named IMultimediaMenu
                    // Create a new class of MultimediaMenu to handle this
                    // Creates a new MultimediaMenu and lists the files

                    break;
                case 2:
                    System.out.println("You selected Option 2");
                    // Creates a new interface for UploadMenu to implement named IUploadMenu
                    // Creates a new UploadMenu and then, will ask for file to upload
                    // Creates a new class of UploadMenu to handle this
                    break;
                case 3:
                    this.turnOff();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

    }

    public void turnOff() {
        setIsOn(false);
    }

}

// App app = new App("MyPhotos");
// App app2 = new App();
// app.turnOn();
// app.isOn(); // true