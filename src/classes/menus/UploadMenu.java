package classes.menus;

import interfaces.menus.IUploadMenu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class UploadMenu implements IUploadMenu {

    private final String name;

    private boolean isOnMenu;

    private final Scanner uInput = new Scanner(System.in);



    public UploadMenu() {
    this.name = "UploadMenu";
    this.isOnMenu = false;
    }

   
    public void uploadPhotos() {
        File folder = new File(System.getProperty("user.home")+File.separator+"Pictures/");
        File serverFolder = new File(System.getProperty("user.home")+File.separator+"MyPhotosServer"+File.separator+"UploadedPhotos/");
        if (!serverFolder.exists()) {
            System.out.println("El directorio del servidor no existe. Creando directorio...");
            try {
                boolean isCreated = serverFolder.mkdirs();
                if (isCreated) {
                    System.out.println("Directorio del servidor creado en: " + serverFolder.getAbsolutePath());
                } else {
                    System.out.println("No se pudo crear el directorio del servidor.");
                    return;
                }
            } catch (SecurityException e) {
                System.out.println("Error de seguridad al crear el directorio del servidor: " + e.getMessage());
                return;
            }
        }
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles == null) {
            System.out.println("No se encontraron archivos en el directorio de fotos.");
            return;
        }
        while (isOnMenu) {
            System.out.println("Elige la foto a subir:");
            for (int i = 0; i < listOfFiles.length ; i++) {
                String fileName = listOfFiles[i].getName().toLowerCase();
                if (fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".gif")) {
                    System.out.println((i+1) + ". " + listOfFiles[i].getName());
                }
            }
            int selectedPhoto = uInput.nextInt();
            int photoIndex = selectedPhoto - 1;
            if (photoIndex < 0 || photoIndex >= listOfFiles.length) {
                System.out.println("Índice inválido. prueba de nuevo.");
                continue;
            }
            File photoToUpload = listOfFiles[photoIndex];
            try {
                Files.copy(photoToUpload.toPath(), serverFolder.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.out.println("Error al subir la foto: " + e.getMessage());
            }
        }

    }

    
    public void uploadVideos() {
      
    }


   
    public void showUploadMenu() {
        System.out.println("Welcome to " + this.name);
        System.out.println("Select an option:");
        isOnMenu = true;
        while (isOnMenu) {
            System.out.println("1. Upload Photos.");
            System.out.println("2. Upload Videos.");
            System.out.println("3. Exit");
            int opcio = uInput.nextInt();
            switch (opcio) {
                case 1 -> uploadPhotos();
                case 2 -> uploadVideos();
                case 3 -> {
                    System.out.println("Exiting to Principal Menu.");
                    isOnMenu = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
}
