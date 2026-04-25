package application.domain.enums;

public enum GuestType {
    NEW("Nuevo"),
    FREQUENT("Frecuente"),
    VIP("VIP");

    private final String description;

    GuestType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static GuestType fromOption(int option) {
        return switch (option) {
            case 1 ->  NEW;
            case 2 -> FREQUENT;
            case 3 -> VIP;
            default -> throw new IllegalArgumentException("Opción de tipo inválida");
        };
    }
}
