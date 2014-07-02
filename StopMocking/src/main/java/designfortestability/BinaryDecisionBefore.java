package designfortestability;

import designfortestability.collaborators.AwkwardCollaborator;

public class BinaryDecisionBefore {

    private AwkwardCollaborator awkward1;
    private AwkwardCollaborator awkward2;

    public void doSomething() {
        // lots of code...
        if ((awkward1.isStupid() && awkward2.isStupid()) || (awkward1.isAnIdiot() && awkward2.isAnIdiot())) {
            //...
        } else {
            //...
        }
    }

}
