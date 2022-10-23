package uyw.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SocketMessage {
    
    private MessageType type;
    private String content;
    private String sender;

    public enum MessageType {
        MESSAGE, ACTION
    }    
}