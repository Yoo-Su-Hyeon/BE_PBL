package net.likelion.pbl.role;

import net.likelion.pbl.policy.SubmissionPolicy;

public abstract class Role {
    private String name;
    private String major;
    private int generation;
    private String part;
    private String RoleName;

    protected Role(String name, String major, int generation, String part, String RoleName) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.RoleName = RoleName;
    }

    public final String getName() {
        return name;
    }

    public final String getMajor() {
        return major;
    }

    public final int getGeneration() {
        return generation;
    }

    public final String getPart() {
        return part;
    }

    public final String getRoleName() {
        return RoleName;
    }

    public abstract SubmissionPolicy submissionPolicy();

    public boolean canSubmitAssignment() {
        return submissionPolicy().canSubmit();
    }

    public abstract String roleName();

    public abstract String getInfo();

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public void setPart(String part) {
        this.part = part;
    }
}