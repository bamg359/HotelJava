package application;

import application.domain.Employee;
import application.domain.Guest;
import application.service.EmployeeServiceImplementation;
import application.service.GuestServiceImplementation;
import application.userinterface.MenuApp;
import application.view.EmployeeView;
import application.view.GuestView;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        Guest guest = new Guest();
        GuestServiceImplementation guestServiceImplementation = new GuestServiceImplementation();
        GuestView guestView = new GuestView(guestServiceImplementation, guest);

        Employee employee = new Employee();
        EmployeeServiceImplementation employeeServiceImplementation = new EmployeeServiceImplementation();
        EmployeeView employeeView = new EmployeeView(employeeServiceImplementation, employee);
        MenuApp menuApp = new MenuApp(guestView, employeeView);

        menuApp.showMainMenu();

    }
}
