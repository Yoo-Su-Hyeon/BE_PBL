package net.likelion.pbl.dto;

public class LionCreateRequest {

    private String name;
    private String major;
    private int generation;
    private String part;
    private String studentId;

    public LionCreateRequest() {
    }

    public LionCreateRequest(String name, String major, int generation, String part, String studentId) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getGeneration() {
        return generation;
    }

    public String getPart() {
        return part;
    }

    public String getStudentId() {
        return studentId;
    }
}