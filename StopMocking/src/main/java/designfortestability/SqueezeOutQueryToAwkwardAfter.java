package designfortestability;

import designfortestability.collaborators.AwkwardCollaborator;

public class SqueezeOutQueryToAwkwardAfter {

    private AwkwardCollaborator awkward;

    // this is only the first step. Question is,
    // if we can remove the dependency to awkward completly and push it up to the caller

       public String doSomething() {
           // Question: this is trivial code.
           // Does it really make sence to test this isolated by means of a stub for awkward??
           return doSomethingInternally(awkward.query());

       }

    // test separately
    String doSomethingInternally(String simple) {
        //some code...

        String temp = simple.indexOf(2, 5) + "..." + "...";


        // more code...

        temp = temp.replace('a','b');
        return temp.replace("Hallo", "Goodby");
    }
}
