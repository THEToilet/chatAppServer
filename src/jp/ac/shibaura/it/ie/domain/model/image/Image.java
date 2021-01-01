package jp.ac.shibaura.it.ie.domain.model.image;

public class Image {
    private String imageId;
    private String imageURL;
    public Image(String imageId, String imageURL){
        this.imageId = imageId;
        this.imageURL = imageURL;
    }

    public String getImageId() {
        return imageId;
    }

    public String getImageURL() {
        return imageURL;
    }
}
