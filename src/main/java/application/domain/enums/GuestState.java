package application.domain.enums;

public enum GuestState {
    ACTIVE ("ACTIVO"),
    INACTIVE("INACTIVO");

    private final String description;

    GuestState(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static GuestState fromOption(int option) {
        return switch (option) {
            case 1 -> ACTIVE;
            case 2 -> INACTIVE;
            default -> throw new IllegalArgumentException("Opción de estado inválida");
        };
    }
}
