package classes.menus;

import interfaces.menus.IUploadMenu;

public class UploadMenu implements IUploadMenu {

    private final String name;

    public UploadMenu() {
    this.name = "UploadMenu";
    }

   
    public void uploadPhotos() {
        
    }

    
    public void uploadVideos() {
      
    }


   
    public void showUploadMenu() {
        System.out.println("Welcome to " + this.name + ": Photos");
    }
    
}
