package application.repository;

import java.util.List;
import java.util.Scanner;

public class ServiceRepository {

    Scanner sc = new Scanner(System.in);

    int idService;
    String nameService;
    double price;
    String state;

    public ServiceRepository(int idService, String nameService, double price, String state) {
        this.idService = idService;
        this.nameService = nameService;
        this.price = price;
        this.state = state;
    }

    public ServiceRepository() {

    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ServiceRepository create(ServiceRepository service) {
        System.out.println("Ingrese el id del servicio");
        int id = sc.nextInt();
        service.idService = id;
        sc.nextLine();

        System.out.println("Ingrese el nombre del servicio");
        String name = sc.nextLine();
        service.nameService = name;

        System.out.println("Ingrese el precio del servicio");
        double price = sc.nextDouble();
        service.price = price;
        sc.nextLine();

        System.out.println("Ingrese el estado del servicio");
        String state = sc.nextLine();
        service.state = state;

        return service;
    }

    public List<ServiceRepository> getAll(List<ServiceRepository> serviceList) {
        return serviceList;
    }

    public void getById(int id, ServiceRepository service) {
        if(this.idService == id){
            System.out.println("Id: " + service.idService + "\n" +
                    "Nombre: " + service.nameService + "\n" +
                    "Precio: " + service.price + "\n" +
                    "Estado: " + service.state + "\n");
        }else{
            System.out.println("Valide el id del servicio que esta consultando");
        }
    }

    public void update(ServiceRepository productoEditado) {
    }

    public void delete(int id) {
    }

}
