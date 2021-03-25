package ocjp;

public abstract class Message {
    public String recipient;
    public abstract void sendMessage();

    public static void main(String...args){
        Message m = new TextMessage();
        m.recipient = "12345678";
        m.sendMessage();
    }

    static class TextMessage extends Message{

        @Override
        public void sendMessage() {
            System.out.println("Text Message To "+ recipient);
        }
    }

}
