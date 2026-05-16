package hotel.infraestructure.configuration;

import hotel.application.BedRoomTypeInputAdapter;
import hotel.application.inputs.BedRoomTypeUseCase;
import hotel.application.ports.BedRoomTypeRepositoryPort;
import hotel.domain.Guest;
import hotel.infraestructure.in.view.adapter.BedRoomTypeView;
import hotel.infraestructure.out.adapter.BedRoomRepository;
import hotel.infraestructure.out.adapter.BedRoomTypeRepository;
import hotel.infraestructure.out.adapter.BedRoomTypeRepositoryDB;
import hotel.infraestructure.out.adapter.GuestRepository;
import hotel.application.BedRoomServiceImp;
import hotel.application.GuestAdminServiceImpl;
import hotel.application.GuestServiceImpl;
import hotel.application.inputs.BedRoomService;
import hotel.application.inputs.GuestAdminService;
import hotel.application.inputs.GuestService;
import hotel.application.ports.BedRoomRepositoryPort;
import hotel.infraestructure.out.db.DataBaseConnectionMySQL;
import hotel.infraestructure.out.mapper.BedRoomTypeRowMapper;
import hotel.infraestructure.out.mapper.RowMapper;
import hotel.userinterface.MenuApp;
import hotel.infraestructure.in.view.adapter.BedRoomView;
import hotel.infraestructure.in.view.adapter.GuestView;

import java.sql.Connection;

public class Config {

    public static MenuApp createMenuApp(){

        Connection connection = DataBaseConnectionMySQL.getInstance().getConnection();




        Guest guest = new Guest();
        GuestRepository guestRepository = new GuestRepository();
        GuestService guestService = new GuestServiceImpl(guestRepository);
        GuestAdminService guestAdminService = new GuestAdminServiceImpl(guestRepository);
        GuestView guestView = new GuestView(guestService, guest, guestAdminService );

        BedRoomTypeRowMapper bedRoomTypeRowMapper = new BedRoomTypeRowMapper();
        BedRoomTypeRepositoryPort bedRoomTypeRepository = new BedRoomTypeRepositoryDB(connection, bedRoomTypeRowMapper);
        BedRoomTypeUseCase bedRoomTypeUseCase = new BedRoomTypeInputAdapter(bedRoomTypeRepository);
        BedRoomTypeView bedRoomTypeView = new BedRoomTypeView(bedRoomTypeUseCase);


        BedRoomRepositoryPort bedRoomRepositoryPort = new BedRoomRepository();
        BedRoomService bedRoomService = new BedRoomServiceImp(bedRoomRepositoryPort, bedRoomTypeRepository);
        BedRoomView bedRoomView = new BedRoomView(bedRoomService);

        return new MenuApp(guestView, bedRoomView, bedRoomTypeView);
    }






}
