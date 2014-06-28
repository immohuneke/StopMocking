package designfortestability.collaborators;

import java.util.List;

public class AwkwardCollaborator {

    public void command(String param1) {

    }

    public String query() {
        return "something";
    }

    public void sendReminder(SimpleCollaborator customer) {
        //...
    }

    public boolean isStupid() {
        return true;
    }

    public boolean isAnIdiot() {
        return true;
    }

    public void execute(String s, List<Object> params) {
        //...
    }
}
