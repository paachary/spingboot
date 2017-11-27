package di.consumer;


import di.services.MessageInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyApplication {

    //field-based dependency injection
    //@Autowired
    private MessageInterface service;

//	constructor-based dependency injection
	@Autowired
	public MyApplication(MessageInterface svc){
        System.out.println("PRAX::: in constructor service:"+ svc);
		this.service=svc;
	}

    //@Autowired
    public void setService(MessageInterface svc){
        System.out.println("PRAX::: in set service:"+ svc);
        this.service=svc;
    }

    public boolean processMessage(String msg, String rec){
        //some magic like validation, logging etc
        return this.service.sendMessage(msg, rec);
    }

    public String getDisplayMsg() {
        return this.service.getDisplayMsg();
    }
}
