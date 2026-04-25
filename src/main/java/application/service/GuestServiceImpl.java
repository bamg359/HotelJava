package application.service;

import application.domain.Guest;
import application.domain.enums.GuestType;
import application.domain.enums.PersonState;
import application.service.outputs.GuestService;
import application.service.ports.GuestRepositoryPort;
import application.util.FormValidationUtil;

import java.util.List;
import java.util.Optional;

public class GuestServiceImpl implements GuestService {
    private final GuestRepositoryPort guestRepository;

    public GuestServiceImpl(GuestRepositoryPort guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public Guest createGuest(Guest guest) {
        guest.setId(FormValidationUtil.validateInt("Ingrese el ID del huésped"));
        guest.setFirstName(FormValidationUtil.validateString("Ingrese el nombre"));
        guest.setLastName(FormValidationUtil.validateString("Ingrese el apellido"));
        guest.setEmail(FormValidationUtil.validateString("Ingrese el email"));
        guest.setPhone(FormValidationUtil.validateString("Ingrese el teléfono"));

        System.out.println("--- ESTADO DEL HUÉSPED ---");
        System.out.println("1. ACTIVO");
        System.out.println("2. INACTIVO");
        int stateOption = FormValidationUtil.validateInt("Ingrese el número del estado");
        guest.setState(PersonState.fromOption(stateOption));

        System.out.println("--- TIPO DE HUÉSPED ---");
        System.out.println("1. NUEVO");
        System.out.println("2. FRECUENTE");
        int typeOption = FormValidationUtil.validateInt("Ingrese el número del tipo");
        guest.setType(GuestType.fromOption(typeOption));

        guest.setCity(FormValidationUtil.validateString("Ingrese la ciudad"));

        return guestRepository.save(guest);
    }

    @Override
    public Guest updateGuest(int id, Guest guest) {
        // Primero buscamos el huésped existente
        Optional<Guest> existing = guestRepository.findById(id);
        if (existing.isEmpty()) {
            System.out.println("Huésped no encontrado.");
            return null;
        }

        // Actualizamos los datos
        guest.setId(id);
        guest.setFirstName(FormValidationUtil.validateString("Ingrese el nombre actualizado"));
        guest.setLastName(FormValidationUtil.validateString("Ingrese el apellido actualizado"));
        guest.setEmail(FormValidationUtil.validateString("Ingrese el email actualizado"));
        guest.setPhone(FormValidationUtil.validateString("Ingrese el teléfono actualizado"));

        System.out.println("--- ESTADO DEL HUÉSPED ---");
        System.out.println("1. ACTIVO");
        System.out.println("2. INACTIVO");
        int stateOption = FormValidationUtil.validateInt("Ingrese el número del estado");
        guest.setState(PersonState.fromOption(stateOption));

        System.out.println("--- TIPO DE HUÉSPED ---");
        System.out.println("1. NUEVO");
        System.out.println("2. FRECUENTE");
        int typeOption = FormValidationUtil.validateInt("Ingrese el número del tipo");
        guest.setType(GuestType.fromOption(typeOption));

        guest.setCity(FormValidationUtil.validateString("Ingrese la ciudad actualizada"));

        return guestRepository.update(guest);
    }

    @Override
    public Optional<Guest> getGuestById(int id) {
        return guestRepository.findById(id);
    }

    @Override
    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    @Override
    public boolean deleteGuest(int id) {
        return guestRepository.deleteById(id);
    }
}
