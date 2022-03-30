package az.parvin.hremployeeservice.domain.enums;

public enum Gender {

    MALE("male"),

    FEMALE("female"),

    UNKNOWN("unknown");

    private String name;

    Gender(String name) {
        this.name = name;
    }
}
