package com.stackroute.emailservice.model;
import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;

// Annotations
@Data
@AllArgsConstructor
@NoArgsConstructor

// Class
@Getter
@Setter

public class EmailDetails {
    // Class data members
    private String recipient; // customer email id
    private String msgBody;
    private String subject;
    private String attachment;

    private String firstname;

    private String lastname;

    public String getRecipient() {
        return recipient;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public String getSubject() {
        return subject;
    }
    public String getAttachment() {
    	return attachment;
    }

    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
}