package designfortestability.exercises;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.TestOnly;

import designfortestability.collaborators.AwkwardCollaborator;
import designfortestability.collaborators.SimpleCollaborator;

public class ListDecision {

    private List<SimpleCollaborator> customers;

    private AwkwardCollaborator awkwardCollaborator = new AwkwardCollaborator();

    public void doSomething() {
    	sendReminders(findLateCustomers(customers), awkwardCollaborator);
    }

	@TestOnly
	public static void sendReminders(List<SimpleCollaborator> lateCustomers,
			AwkwardCollaborator awkwardCollaborator) {
        for (SimpleCollaborator customer : lateCustomers) {
            awkwardCollaborator.sendReminder(customer);
        }
	}

	@TestOnly
	public static List<SimpleCollaborator> findLateCustomers(List<SimpleCollaborator> customers) {
    	List<SimpleCollaborator> lateCustomers = new ArrayList<SimpleCollaborator>();
        for (SimpleCollaborator customer : customers) {
            if (customer.lastBillIsMissing()) {
                lateCustomers.add(customer);
            }
        }
		return lateCustomers;
	}

}
