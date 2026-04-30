package application.domain.enums;

public enum BedRoomState {
    DISPONIBLE("DISPONIBLE"),
    OCUPADA("OCUPADA"),
    RESERVADA("RESERVADA"),
    MANTENIMIENTO("MANTENIMIENTO");

    private final String description;

    BedRoomState(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


}

