package classes.menus;

import classes.utility.Utilities;
import interfaces.menus.IUploadMenu;
import interfaces.utility.IUtility;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Optimizar codigo, tanto en videos como en fotos. Automatizar y crear un metodo generico que dependiendo del tipo
    //de archivo haga una cosa u otra, en temas como el path, el folder del servidor, subir archivo.
public class UploadMenu implements IUploadMenu {

    private final String name;

    private boolean isOnMenu;

    private final Scanner uInput = new Scanner(System.in);
    private final IUtility utilidades = new Utilities();

    public UploadMenu() {
        this.name = "UploadMenu";
        this.isOnMenu = false;
    }
    private void executeUploadProcess(String folderName, String serverSubFolder, String label, String filterType) {
    // 1. Definir rutas
    String userHome = System.getProperty("user.home") + File.separator;
    File localFolder = new File(userHome + folderName + File.separator);
    File serverFolder = new File(userHome + "MyPhotosServer" + File.separator + serverSubFolder );

    // 2. Validar/Crear directorio del servidor
    if (!serverFolder.exists()) {
        System.out.println("El directorio del servidor no existe. Creando: " + serverFolder.getAbsolutePath());
        boolean dirCreated = serverFolder.mkdirs();
        if (!dirCreated) System.out.println("Error al crear el directorio del servidor: " + serverFolder.getAbsolutePath());
      
    }

    // 3. Obtener y filtrar archivos
    File[] listOfFiles = localFolder.listFiles();
    if (listOfFiles == null) {
        System.out.println("No se encontraron archivos en: " + folderName);
        return;
    }

    List<File> filteredFiles = new ArrayList<>();
    for (File f : listOfFiles) {
        // Filtramos dinámicamente según el tipo
        boolean isValid = filterType.equals("photo") ? utilidades.fileIsPhoto(f) : utilidades.fileIsVideo(f);
        if (isValid) filteredFiles.add(f);
    }

    // 4. Bucle de Interfaz de Usuario
    while (isOnMenu) {
        System.out.println("\n--- Elige el " + label + " a subir (0 para salir) ---");
        for (int i = 0; i < filteredFiles.size(); i++) {
            System.out.println((i + 1) + ". " + filteredFiles.get(i).getName());
        }

        int choice = uInput.nextInt();
        if (choice == 0) break;

        int index = choice - 1;
        if (index < 0 || index >= filteredFiles.size()) {
            System.out.println("Índice inválido.");
            continue;
        }

        // 5. Copiar archivo
        File fileToUpload = filteredFiles.get(index);
        try {
            Files.copy(fileToUpload.toPath(), serverFolder.toPath().resolve(fileToUpload.getName()), StandardCopyOption.REPLACE_EXISTING);
            System.out.println(label + " subido/a exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al subir: " + e.getMessage());
        }

        System.out.println("¿Deseas subir otro " + label + "? (1. Sí / 2. No)");
        if (uInput.nextInt() != 1) break;
    }
}
    public void uploadPhotos() {
    executeUploadProcess("Pictures", "UploadedPhotos", "foto", "photo");
}
//"C:\Users\amata\Pictures\willSmith.jpg"
    public void uploadVideos() {
    executeUploadProcess("Videos", "UploadedVideos", "video", "video");
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
