package designfortestability.exercises;

import designfortestability.collaborators.AwkwardCollaborator;
import designfortestability.collaborators.SimpleCollaborator;

import java.util.List;

public class ListDecision {

    private List<SimpleCollaborator> customers;

    private AwkwardCollaborator awkwardCollaborator = new AwkwardCollaborator();

    public void doSomething() {
        for (SimpleCollaborator customer : customers) {
            if (customer.lastBillIsMissing()) {
                awkwardCollaborator.sendReminder(customer);
            }
        }
    }

}
