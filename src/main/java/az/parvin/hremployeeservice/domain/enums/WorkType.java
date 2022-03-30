package az.parvin.hremployeeservice.domain.enums;

public enum WorkType {
    REMOTE("remote"),

    LOCAL("local");

    private String name;

    WorkType(String name) {
        this.name = name;
    }
}
