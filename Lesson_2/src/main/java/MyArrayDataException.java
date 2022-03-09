public class MyArrayDataException extends RuntimeException{
    String sendMessage = "Incorrect data ";

    public void setSendMessage(String sendMessage) {
        this.sendMessage = sendMessage;
    }

    public String getSendMessage() {
        return sendMessage;
    }

}
