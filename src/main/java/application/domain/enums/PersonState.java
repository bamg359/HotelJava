package application.domain.enums;

public enum PersonState {
    ACTIVE("ACTIVO"),
    INACTIVE("INACTIVO");

    private final String description;

    PersonState(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static PersonState fromOption(int option) {
        return option == 1 ? ACTIVE : INACTIVE;
    }
}
