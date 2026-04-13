package com.practicos.ejercicio3.controllers;

import com.practicos.ejercicio3.dtos.ProductoRequestDTO;
import com.practicos.ejercicio3.dtos.ProductoResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.practicos.ejercicio3.services.ProductoService;

import java.net.URI;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<ProductoResponseDTO>
        crear(@Valid @RequestBody ProductoRequestDTO dto) {
            ProductoResponseDTO creado = productoService.agregarProducto(dto);

            URI location = URI.create("/api/productos/" + creado.getId());

            return ResponseEntity
                    .created(location)
                    .body(creado);
    }
}
