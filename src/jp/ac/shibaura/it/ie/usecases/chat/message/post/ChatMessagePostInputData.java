package jp.ac.shibaura.it.ie.usecases.chat.message.post;

import jp.ac.shibaura.it.ie.usecases.core.InputData;

public class ChatMessagePostInputData implements InputData<ChatMessagePostOutputData> {
    private final String session;
    private final String roomId;
    private final String imageSource;
    private final String fileName;
    private final String fileExtension;

    public ChatMessagePostInputData(String session, String roomId, String imageSource, String fileName, String fileExtension) {
        this.session = session;
        this.roomId = roomId;
        this.imageSource = imageSource;
        this.fileName = fileName;
        this.fileExtension = fileExtension;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getSession() {
        return session;
    }

    public String getImageSource() {
        return imageSource;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public String getFileName() {
        return fileName;
    }
}
