package designfortestability.exercises;

import designfortestability.collaborators.AwkwardCollaborator;
import designfortestability.collaborators.InternetAddress;
import designfortestability.collaborators.MailAttachment;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class CommandsToCollaborator2 {


    private AwkwardCollaborator remoteClient;
    private boolean singleReceiver;
    private InternetAddress sender;
    private String subject;
    private String messageText;
    private Set<MailAttachment> attachments = new HashSet<MailAttachment>(10);
    private Iterable<InternetAddress> recipients = new HashSet<InternetAddress>(10);
    private String singleReceiverAddress;
    private String contentType = "text/plain";

    public void send() throws UnsupportedEncodingException {

        List<Object> params = new ArrayList<Object>(10);
        params.add(toByteArray(sender));
        if (!singleReceiver) {
            params.add(toByteArray(recipients));
        } else {
            Collection<InternetAddress> singleRecipients = new HashSet<InternetAddress>(2);
            singleRecipients.add(new InternetAddress(singleReceiverAddress));
            params.add(toByteArray(singleRecipients));
        }

        params.add(contentType);
        if (singleReceiver) {
            String origRecipient = "";
            for (InternetAddress recipient : recipients) {
                origRecipient = recipient.toString();
                break;
            }
            subject = origRecipient + " : " + subject;
        }
        params.add(subject.getBytes("UTF-8"));
        params.add(messageText.getBytes("UTF-8"));
        params.add(toByteArray(attachments));

        //THIS IS THE AWKWARD CALL
        remoteClient.execute("mail.sendMail", params);

    }

    public static byte[] toByteArray(Object object) {

        return null; //...
    }
}
