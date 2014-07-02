package designfortestability;

import designfortestability.collaborators.AwkwardCollaborator;

public class PrimaryConstructorAfter {

    private String simple;

    public PrimaryConstructorAfter(AwkwardCollaborator awkward) {
        this(awkward.query());
    }

    // use this constructor for testing
    PrimaryConstructorAfter(String simple) {
        this.simple = simple;
    }
}
