package application.view;

import application.domain.BedRoom;
import application.domain.BedRoomType;
import application.domain.enums.BedRoomState;
import application.service.outputs.BedRoomService;
import application.util.FormValidationUtil;

import java.util.List;
import java.util.Optional;

public class BedRoomView {

    private final BedRoomService bedRoomService;

    public BedRoomView(BedRoomService bedRoomService) {
        this.bedRoomService = bedRoomService;
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n--- MENÚ DE HABITACIONES ---");
            System.out.println("1. Crear habitación");
            System.out.println("2. Actualizar habitación");
            System.out.println("3. Consultar habitación por ID");
            System.out.println("4. Listar todas las habitaciones");
            System.out.println("5. Eliminar habitación");
            System.out.println("0. Salir");
            option = FormValidationUtil.validateInt("Seleccione una opción:");

            switch (option) {
                case 1 -> createBedRoom();
                case 2 -> updateBedRoom();
                case 3 -> getBedRoomById();
                case 4 -> listAllBedRooms();
                case 5 -> deleteBedRoom();
                case 0 -> System.out.println("Saliendo del menú de habitaciones...");
                default -> System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (option != 0);
    }

    private void showRoomTypes() {
        System.out.println("--- TIPOS DE HABITACIÓN ---");
        System.out.println("1. Single");
        System.out.println("2. Doble");
        System.out.println("3. Suite");
        System.out.println("4. Grupal");
    }

    private void showRoomStates() {
        System.out.println("--- ESTADOS DE HABITACIÓN ---");
        System.out.println("1. DISPONIBLE");
        System.out.println("2. OCUPADA");
        System.out.println("3. RESERVADA");
        System.out.println("4. MANTENIMIENTO");
    }

    private void createBedRoom() {
        int id = FormValidationUtil.validateInt("Ingrese el ID de la habitación");
        String room = FormValidationUtil.validateString("Ingrese el nombre de la habitación");

        showRoomTypes();
        int typeId = FormValidationUtil.validateInt("Ingrese el ID del tipo de habitación");

        double price = FormValidationUtil.validateDouble("Ingrese el precio");

        showRoomStates();
        int stateOption = FormValidationUtil.validateInt("Ingrese el número del estado");
        String state = BedRoomState.fromOption(stateOption).getDescription();

        BedRoom bedRoom = new BedRoom(id, room, new BedRoomType(typeId, ""), price, state);
        bedRoomService.createBedRoom(bedRoom);
        System.out.println("Habitación creada correctamente.");
    }


    private void updateBedRoom() {
        int id = FormValidationUtil.validateInt("Ingrese el ID de la habitación a actualizar");
        String room = FormValidationUtil.validateString("Ingrese el nombre actualizado");

        showRoomTypes();
        int typeId = FormValidationUtil.validateInt("Ingrese el ID del tipo de habitación actualizado");

        double price = FormValidationUtil.validateDouble("Ingrese el precio actualizado");

        showRoomStates();
        int stateOption = FormValidationUtil.validateInt("Ingrese el número del estado");
        String state = BedRoomState.fromOption(stateOption).getDescription();


        BedRoom bedRoom = new BedRoom(id, room, new BedRoomType(typeId, ""), price, state);
        bedRoomService.updateBedRoom(id, bedRoom);
        System.out.println("Habitación actualizada correctamente.");
    }

    private void getBedRoomById() {
        int id = FormValidationUtil.validateInt("Ingrese el ID de la habitación a consultar");
        Optional<BedRoom> bedRoom = bedRoomService.getBedRoomById(id);
        bedRoom.ifPresentOrElse(
                b -> System.out.println("Habitación encontrada: " + b.getRoomId() + " " +
                        b.getBedRoomType().getType() + " Precio: $" + b.getPrice() + " Estado: " + b.getState()),
                () -> System.out.println("No se encontró la habitación con ID " + id)
        );
    }

    private void listAllBedRooms() {
        List<BedRoom> bedRooms = bedRoomService.getAllBedRooms();
        System.out.println("--- LISTA DE HABITACIONES ---");
        bedRooms.forEach(b -> System.out.println(b.getRoomId() + " " +
                b.getBedRoomType().getType() + " Precio: $" + b.getPrice() + " Estado: " + b.getState()));
    }

    private void deleteBedRoom() {
        int id = FormValidationUtil.validateInt("Ingrese el ID de la habitación a eliminar");
        bedRoomService.deleteBedRoomById(id);
        System.out.println("Habitación eliminada correctamente.");
    }
}
