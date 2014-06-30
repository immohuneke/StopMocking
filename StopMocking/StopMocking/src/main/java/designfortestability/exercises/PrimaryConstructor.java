package designfortestability.exercises;

import designfortestability.collaborators.AwkwardCollaborator;

public class PrimaryConstructor {

    private String simple;

    public PrimaryConstructor(AwkwardCollaborator awkward) {
        simple = awkward.query();

    }
}
