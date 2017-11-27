package di.services;

public class TweeterMessage implements MessageInterface{

    private String msg;
    private String rec;

    public boolean sendMessage(String msg, String rec) {
        System.out.println("Tweeter message Sent to "+rec+ " with Message="+msg);
        return true;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }

    public void setRecepient(String rec) {
        this.rec = rec;
    }


    public String getDisplayMsg() {
        return("PRAX:: Tweeter msg = "+ msg +"; rec = "+ rec);
    }
}
