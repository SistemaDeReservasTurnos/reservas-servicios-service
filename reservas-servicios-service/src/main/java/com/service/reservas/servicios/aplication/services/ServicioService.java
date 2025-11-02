package com.service.reservas.servicios.aplication.services;


import com.service.reservas.servicios.aplication.dto.ServicioMapper;
import com.service.reservas.servicios.aplication.dto.ServicioRequest;
import com.service.reservas.servicios.aplication.dto.ServicioResponse;
import com.service.reservas.servicios.domain.entities.Servicio;
import com.service.reservas.servicios.domain.repository.IServicioRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ServicioService implements IServicioService{

    private final IServicioRepository servicioRepository;

    public ServicioService(IServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    @Override
    public ServicioResponse createServicio(ServicioRequest servicioRequest) {

        return null;
    }


    @Override
    public ServicioResponse editServicio(Long id, ServicioRequest servicioRequest) {

        Servicio existsServicio = existenceServiceByid(id); // verificamos la existencia

        //verifico si no hay duplicados
        // si el nombre esta en la bd = true
        Optional<Servicio> duplicated = servicioRepository.findDuplicateByName(servicioRequest.getName());
        if (duplicated.isPresent()) {

            //comparamos los id's de la peticion y de la base de datos (!= duplicado, == se puede editar)
            Servicio idFound = duplicated.get();

            if (!existsServicio.getId().equals(idFound.getId())) {
                throw new DuplicateKeyException("Ya existe un servicio con ese nombre");
            }
        }

        //actualizamos el servicio
        existsServicio.updateInfoServ(servicioRequest.getName(), servicioRequest.getDescription(), servicioRequest.getDuration(), servicioRequest.getPrice());

        // llamamos al repositorio para pasarle/guardar el servicio actualizado
        Servicio updateServicio = servicioRepository.save(existsServicio);

        return ServicioMapper.toResponse(updateServicio);
    }

    @Override
    public Servicio existenceServiceByid(Long id) {

        //valido la existencia
        return servicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));

    }

    @Override
    public ServicioResponse seeDetailServicio(Long id) {

        // buscar servicio por id
        Servicio servicio = existenceServiceByid(id); //devuelve el servicio

        return ServicioMapper.toResponse(servicio);
    }


}

