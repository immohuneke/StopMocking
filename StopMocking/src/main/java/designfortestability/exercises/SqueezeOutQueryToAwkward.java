package designfortestability.exercises;

import org.jetbrains.annotations.TestOnly;

import designfortestability.collaborators.AwkwardCollaborator;

public class SqueezeOutQueryToAwkward {

    private AwkwardCollaborator awkward;

    public String doSomething() {
    	return doSomethingInternal(awkward.query());
    }

    @TestOnly
    String doSomethingInternal(String queryResult) {
        //some code...

        String temp = queryResult.indexOf(2, 5) + "..." + "...";


        // more code...

        temp = temp.replace('a','b');
        return temp.replace("Hallo", "Goodby");

    }

}
