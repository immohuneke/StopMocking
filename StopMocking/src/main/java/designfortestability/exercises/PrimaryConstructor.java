package designfortestability.exercises;

import org.jetbrains.annotations.TestOnly;

import designfortestability.collaborators.AwkwardCollaborator;

public class PrimaryConstructor {

    private String simple;

    public PrimaryConstructor(AwkwardCollaborator awkward) {
        this(awkward.query());

    }

    @TestOnly
    public PrimaryConstructor(String queryResult) {
    	simple = queryResult;
    }
}
