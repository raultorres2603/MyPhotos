package classes.utility;

import interfaces.utility.IUtility;

import java.io.File;

public class Utilities implements IUtility {


    //fileisPhoto
    public boolean fileIsPhoto(File file) {
        String fileName = file.getName().toLowerCase();
        return fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".gif");
    }

    //fileisVideo
    public boolean fileIsVideo(File file) {
        String fileName = file.getName().toLowerCase();
        return fileName.endsWith(".mp4") || fileName.endsWith(".avi") || fileName.endsWith(".mkv");
    }

}
