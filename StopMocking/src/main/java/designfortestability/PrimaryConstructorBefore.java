package designfortestability;

import designfortestability.collaborators.AwkwardCollaborator;

public class PrimaryConstructorBefore {

    private String simple;

    public PrimaryConstructorBefore(AwkwardCollaborator awkward) {
        simple = awkward.query();

    }
}
