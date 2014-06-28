package designfortestability;

import designfortestability.collaborators.AwkwardCollaborator;
import org.jetbrains.annotations.TestOnly;

public class BinaryDecisionAfter {

    private AwkwardCollaborator awkward1;
    private AwkwardCollaborator awkward2;

    public void doSomething() {
        //...
        // LOTS OF CODE HERE (that would need complicated test setup)
        //...
        if (doIt(awkward1.isStupid(), awkward2.isStupid(), awkward1.isAnIdiot(), awkward2.isAnIdiot())) {
            //...
        } else {
            //...
        }
    }


    // test the decision making separately if the input vector has more than two compinations
    @TestOnly
    static boolean doIt(boolean stupid1, boolean stupid2, boolean anIdiot1, boolean anIdiot) {
        return (stupid1 && stupid2) || (anIdiot1 && anIdiot);
    }

}
