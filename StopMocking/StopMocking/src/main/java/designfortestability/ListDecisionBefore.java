package designfortestability;

import designfortestability.collaborators.AwkwardCollaborator;
import designfortestability.collaborators.SimpleCollaborator;

import java.util.List;

public class ListDecisionBefore {

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
