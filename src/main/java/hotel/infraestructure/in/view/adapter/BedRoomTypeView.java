package hotel.infraestructure.in.view.adapter;

import hotel.application.inputs.BedRoomTypeUseCase;
import hotel.domain.BedRoomType;
import hotel.infraestructure.util.FormValidationUtil;

import java.util.List;
import java.util.Scanner;

public class BedRoomTypeView {

    private final BedRoomTypeUseCase bedRoomTypeUseCase;

    public BedRoomTypeView(BedRoomTypeUseCase bedRoomTypeUseCase) {
        this.bedRoomTypeUseCase = bedRoomTypeUseCase;
    }

    public void createBedRoomTypeView() {
        System.out.println("Creating a new bedroom type...");
        int idType = FormValidationUtil.validateInt("Ingrese el id del tipo de habitación:");
        String nameType = FormValidationUtil.validateString("Ingrese el nombre del tipo de habitación:");

        bedRoomTypeUseCase.createBedRoomType(idType, nameType);

    }

    public void getAllBedRoomTypesView(){

        List<BedRoomType> bedRoomTypeList = bedRoomTypeUseCase.getAllBedRoomTypes();

        for (BedRoomType bedRoomType: bedRoomTypeList){
            System.out.println("Id: " + bedRoomType.getIdType() + "\n" +
                    "Tipo: " + bedRoomType.getType());
        }

    }


    public void getBedRoomTypeById(){

        System.out.println("Busca Tipo de Habitación por id");

        int id_type= FormValidationUtil.validateInt("Ingrese el id del tipo de habitación");

        BedRoomType bedRoomType = bedRoomTypeUseCase.getBedRoomType(id_type).orElseThrow();

        System.out.println("id: " + bedRoomType.getIdType()+ "\n" +
                "Tipo Habitación: " + bedRoomType.getType());

    }


    public void deleteBedRoomType(){

        int id = FormValidationUtil.validateInt("Indique el id de Tipo a eliminar");

        bedRoomTypeUseCase.deleteBedRoomType(id);

    }




}
