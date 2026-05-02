package application.domain.enums;

public enum BedRoomState {
    DISPONIBLE("Disponible"),
    OCUPADA("Ocupada"),
    RESERVADA("Reservada"),
    MANTENIMIENTO("Mantenimiento");

    private final String description;

    BedRoomState(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    public static BedRoomState fromOption(int option) {
        return switch (option) {
            case 1 -> DISPONIBLE;
            case 2 -> OCUPADA;
            case 3 -> RESERVADA;
            case 4 -> MANTENIMIENTO;
            default -> throw new IllegalArgumentException("Opción inválida: " + option);
        };
    }
}

