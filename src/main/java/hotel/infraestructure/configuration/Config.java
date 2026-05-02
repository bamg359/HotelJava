package hotel.infraestructure.configuration;

import hotel.domain.Guest;
import hotel.infraestructure.out.adapter.BedRoomRepository;
import hotel.infraestructure.out.adapter.BedRoomTypeRepository;
import hotel.infraestructure.out.adapter.GuestRepository;
import hotel.application.BedRoomServiceImp;
import hotel.application.GuestAdminServiceImpl;
import hotel.application.GuestServiceImpl;
import hotel.application.inputs.BedRoomService;
import hotel.application.inputs.GuestAdminService;
import hotel.application.inputs.GuestService;
import hotel.application.ports.BedRoomRepositoryPort;
import hotel.userinterface.MenuApp;
import hotel.infraestructure.in.view.adapter.BedRoomView;
import hotel.infraestructure.in.view.adapter.GuestView;

public class Config {

    public static MenuApp createMenuApp(){

        Guest guest = new Guest();
        GuestRepository guestRepository = new GuestRepository();
        GuestService guestService = new GuestServiceImpl(guestRepository);
        GuestAdminService guestAdminService = new GuestAdminServiceImpl(guestRepository);
        GuestView guestView = new GuestView(guestService, guest, guestAdminService );

        BedRoomTypeRepository bedRoomTypeRepository = new BedRoomTypeRepository();


        BedRoomRepositoryPort bedRoomRepositoryPort = new BedRoomRepository();
        BedRoomService bedRoomService = new BedRoomServiceImp(bedRoomRepositoryPort, bedRoomTypeRepository);
        BedRoomView bedRoomView = new BedRoomView(bedRoomService);

        return new MenuApp(guestView, bedRoomView);
    }






}
