package classes.config;

import java.io.File;

public class ConfigModel {
    private String photoDirectory;
    private String videoDirectory;

    public ConfigModel() {
        this.photoDirectory = System.getProperty("user.home") + File.separator +  "MyPhotosServer" + File.separator + "UploadedPhotos" + File.separator;
        this.videoDirectory = System.getProperty("user.home") + File.separator +  "MyPhotosServer" + File.separator + "UploadedVideos" + File.separator;
    }

    public String getVideoDirectory() {
        return videoDirectory;
    }

    public void setVideoDirectory(String videoDirectory) {
        this.videoDirectory = videoDirectory;
    }

    public String getPhotoDirectory() {
        return photoDirectory;
    }

    public void setPhotoDirectory(String photoDirectory) {
        this.photoDirectory = photoDirectory;
    }
}
