package designfortestability.exercises;

import designfortestability.collaborators.AwkwardCollaborator;

public class SqueezeOutQueryToAwkward {

    private AwkwardCollaborator awkward;


    public String doSomething() {
        //some code...

        String temp = awkward.query().indexOf(2, 5) + "..." + "...";


        // more code...

        temp = temp.replace('a','b');
        return temp.replace("Hallo", "Goodby");

    }

}
