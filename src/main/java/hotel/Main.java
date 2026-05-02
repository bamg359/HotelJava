package hotel;

import hotel.infraestructure.configuration.Config;
import hotel.infraestructure.out.db.DataBaseConnectionMySQL;
import hotel.userinterface.MenuApp;

public class Main {

    public static void main(String[] args) {

        MenuApp menuApp = Config.createMenuApp();

        menuApp.showMainMenu();



    }
}
