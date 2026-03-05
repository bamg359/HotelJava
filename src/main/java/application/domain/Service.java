package application.domain;

import application.domain.enums.ServiceStatus;
import application.domain.enums.ServiceType;

public class Service {
    // atributos

    private int id;
    private ServiceType serviceType;
    private String description;
    private double price;
    private ServiceStatus serviceStatus;

    // constructor

    public Service(int id,ServiceType serviceType,String description,double price,ServiceStatus serviceStatus){
        this.id = id;
        this.serviceType = serviceType;
        this.description = description;
        this.price = price;
        this.serviceStatus = serviceStatus;
    }

    // getters & setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ServiceStatus getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(ServiceStatus serviceStatus) {
        this.serviceStatus = serviceStatus;
    }
}




