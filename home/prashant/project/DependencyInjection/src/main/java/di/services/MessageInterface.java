package di.services;

public interface MessageInterface {
    boolean sendMessage( String msg, String rec );

    public String getDisplayMsg();
 }
