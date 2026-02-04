package classes.config;

import interfaces.config.IConfig;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigService implements IConfig {
    private File configFile;

    public ConfigService() {
        this.configFile = createOrSelectConfigFile();
    }

    /*
    {
    "nombre": "osjdfiojsdf",
    "apellido":"ishduhsdhvc"
    }
     */

    private File createOrSelectConfigFile() {
        String appDirectoryPath = System.getProperty("user.home") + File.separator + "MyPhotosServer";
        String configFilePath = appDirectoryPath + File.separator + "config.json";
        // Check if config file exists, if not create one
        File configFile = new File(configFilePath);
        if (!new File(appDirectoryPath).exists()) {
            try {
                boolean isDirectoryCreated = new File(appDirectoryPath).mkdirs();
                if (isDirectoryCreated) {
                    System.out.println("Application directory created at: " + appDirectoryPath);
                } else {
                    System.out.println("Failed to create application directory at: " + appDirectoryPath);
                    System.exit(0);
                }
            } catch (SecurityException e) {
                System.out.println("Error creating application directory: " + e.getMessage());
                System.exit(0);
            }
        }


        if (!configFile.exists()) {
            File cfgFile = new File(configFilePath);
            // Create new config file with ConfigModel default values
            ConfigModel defaultConfig = new ConfigModel();
            try {
                boolean isFileCreated = cfgFile.createNewFile();
                if (isFileCreated) {
                    System.out.println("Config file created at: " + configFilePath);
                    try(FileWriter writer = new FileWriter(cfgFile)) {
                        writer.write("{\n");
                        writer.write("  \"photoDirectory\": \"" + defaultConfig.getPhotoDirectory() + "\",\n");
                        writer.write("  \"videoDirectory\": \"" + defaultConfig.getVideoDirectory() + "\"\n");
                        writer.write("}\n");
                        setConfigFile(cfgFile);
                        System.out.println("Default configuration written to config file:");
                        System.out.println(cfgFile);
                    } catch (IOException e) {
                        System.out.println("Error writing to config file: " + e.getMessage());
                        System.exit(0);
                    }
                } else {
                    System.out.println("Failed to create config file at: " + configFilePath);
                    System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Error creating config file: " + e.getMessage());
                System.exit(0);
            }

        }
        System.out.println("Using config file at: " + configFilePath);
        return configFile;
    }

    public File getConfigFile() {
        return configFile;
    }

    public void setConfigFile(File configFile) {
        this.configFile = configFile;
    }

    @Override
    public void loadConfig() {

    }

    @Override
    public void saveConfig() {

    }
}
