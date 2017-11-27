package di.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageInterface {

    private String msg;
    private String rec;

    public boolean sendMessage(String msg, String rec) {
        System.out.println("Email Sent to " + rec + " with Message=" + msg);
        return true;
    }

    @Autowired
    public void setMessage(String msg) {
        this.msg = msg;
    }

    @Autowired
    public void setRecepient(String rec) {
        this.rec = rec;
    }


    public String getDisplayMsg() {
        return ("PRAX:: Email msg = " + msg + "; rec = " + rec);
    }
}
