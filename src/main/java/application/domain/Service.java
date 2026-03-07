package application.domain;

import java.util.List;
import java.util.Scanner;

public class Service {

    Scanner sc = new Scanner(System.in);

    // Service Attributes
    private int id;
    private String name;
    private double price;

    // Constructors
    public Service() {
    }

    public Service(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Class Methods

    public Service createService(Service service) {
        System.out.println("Enter Service Name:");
        service.setName(sc.nextLine());
        System.out.println("Enter Service Price:");
        service.setPrice(sc.nextDouble());
        sc.nextLine(); // Consume newline
        return service;
    }

    public Service updateService(Service service) {
        return service;
    }

    public List<Service> getAllServices() {
        return null;
    }

    public void getServiceById(int id, Service service) {
        if (service.getId() == id) {
            System.out.println("ID: " + service.getId());
            System.out.println("Nombre: " + service.getName());
            System.out.println("Precio: " + service.price);
        } else {
            System.out.println("No se encontró el servicio con ID: " + id);
        }
    }

    public void deleteService(int id) {

    }

}
