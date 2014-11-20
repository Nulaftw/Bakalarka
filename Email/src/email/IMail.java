package email;

import java.util.Date;

/**
 *
 * @author Nula
 */
public interface IMail {
    
    public void setSSLHost(String host);
    public void setSSLPort(String portNumber);
    public void setUser(String login, String password);
    
    public void createMessage(String reciever, String subject, String body);
    public void send();
    
    public void setTimer(Date date);
    public void setTimer(Date from, Date to);
    public void setContinuousTimer(long seconds);
    
}
