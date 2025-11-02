package com.service.reservas.servicios.domain.repository;
 
import com.service.reservas.servicios.domain.entities.Servicio;
import java.util.Optional;
 
 //repository solo debe saber de la entidad dominio (no de aplication)
public interface IServicioRepository {

    Optional<Servicio> findById(Long id);
    Optional<Servicio> findDuplicateByName(String name); //buscar si hay un duplicado de servicio con el nombre
    Servicio save(Servicio servicio);

    //método para la eliminación lógica
    void deleteLogic(Long id, String updatedBy);
} 

