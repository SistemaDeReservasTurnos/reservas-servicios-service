package com.service.reservas.servicios.config;

import lombok.NonNull;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;


public class AuditorAwareImplement implements AuditorAware<String> {

    @Override
    @NonNull
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.of("desconocido"); // si no esta autenticado (usuario desconocido)
        }
        return Optional.of(authentication.getName()); // obtenemos el nombre del usuario que edito (esta autenticado)
    }

}
