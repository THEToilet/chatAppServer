package jp.ac.shibaura.it.ie.message;

public class MessagePostRequest {
    private String imageSource;
    private String fileName;
    private String fileExtension;
    public MessagePostRequest(String imageSource, String fileName, String fileExtension){
        this.imageSource = imageSource;
        this.fileName = fileName;
        this.fileExtension = fileExtension;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }
}
