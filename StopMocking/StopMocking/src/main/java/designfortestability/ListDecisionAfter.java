package designfortestability;

import designfortestability.collaborators.AwkwardCollaborator;
import designfortestability.collaborators.SimpleCollaborator;

import java.util.ArrayList;
import java.util.List;

public class ListDecisionAfter {

    private List<SimpleCollaborator> customers;

    private AwkwardCollaborator awkwardCollaborator = new AwkwardCollaborator();

    public void doSomething() {
        for (SimpleCollaborator lateCustomer : findLateCustomers(customers)) {
            awkwardCollaborator.sendReminder(lateCustomer);
        }
    }

    // test this function separatly
    static List<SimpleCollaborator> findLateCustomers(Iterable<SimpleCollaborator> customers) {
                List<SimpleCollaborator> lateCustomers = new ArrayList<SimpleCollaborator>(10);
                for (SimpleCollaborator customer : customers) {
                    if (customer.lastBillIsMissing()) {
                        lateCustomers.add(customer);
                    }
                }
        return lateCustomers;
    }


}
