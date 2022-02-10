

public class MyArraySizeException extends RuntimeException {
    String sendMessage = "Massiv must be 4x4";

    public String getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(String sendMessage) {
        this.sendMessage = sendMessage;
    }
}
