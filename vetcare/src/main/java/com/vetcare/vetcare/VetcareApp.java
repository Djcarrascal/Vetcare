package com.vetcare.vetcare;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
import com.vetcare.exception.BusinessException;
import com.vetcare.exception.DuplicateOwnerDocumentException;
import com.vetcare.repository.OwnerRepository;
import com.vetcare.repository.impl.OwnerRepositoryJdbc;
import com.vetcare.service.impl.OwnerService;
import com.vetcare.service.impl.OwnerServiceImpl;
import com.vetcare.model.Owner;


public class VetcareApp {

    public static void main(String[] args) {
// 1. Instanciamos el repositorio y se lo inyectamos al servicio
        OwnerRepository ownerRepo = new OwnerRepositoryJdbc();
        OwnerService ownerService = new OwnerServiceImpl(ownerRepo);

        try {
            Owner owner1 = new Owner();
            owner1.setIdentificationType("CC");
            owner1.setDocumentNumber("1020304050");
            owner1.setFullName("Maria Lopez");
            owner1.setPhone("3009876543");
            owner1.setEmail("maria@example.com");
            owner1.setAddress("Calle 10 # 20-30");

            System.out.println("Intentando registrar primer dueño...");
            ownerService.registerOwner(owner1);
            System.out.println("✅ Primer dueño registrado con éxito.");

            // Intentamos registrar OTRO dueño con el MISMO documento (debe fallar)
            Owner owner2 = new Owner();
            owner2.setIdentificationType("CC");
            owner2.setDocumentNumber("1020304050"); // Mismo documento
            owner2.setFullName("Juan Perez");
            owner2.setPhone("3111234567");
            owner2.setEmail("juan@example.com");

            System.out.println("Intentando registrar dueño con documento repetido...");
            ownerService.registerOwner(owner2);

        } catch (DuplicateOwnerDocumentException e) {
            System.out.println("✅ Checkpoint superado con éxito (Excepción capturada): " + e.getMessage());
        } catch (BusinessException e) {
            System.err.println("❌ Error de negocio general: " + e.getMessage());
        }
    }
}
