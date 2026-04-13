package com.practicos.ejercicio3.services;

import com.practicos.ejercicio3.dtos.ProductoRequestDTO;
import com.practicos.ejercicio3.dtos.ProductoResponseDTO;
import com.practicos.ejercicio3.models.Producto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    private List<Producto> productos = new ArrayList<>();
    Long contadorId = 1L;

    public ProductoResponseDTO agregarProducto(ProductoRequestDTO dto){

        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        producto.setEmailProveedor(dto.getEmailProveedor());
        producto.setFechaVencimiento(dto.getFechaVencimiento());
        producto.setCodigoSKU(dto.getCodigoSKU());

        producto.setId(contadorId);
        producto.setFechaRegistro(LocalDateTime.now());

        productos.add(producto);
        contadorId++;

        ProductoResponseDTO response = new ProductoResponseDTO();

        response.setId(producto.getId());
        response.setNombre(producto.getNombre());
        response.setPrecio(producto.getPrecio());
        response.setStock(producto.getStock());
        response.setCodigoSKU(producto.getCodigoSKU());
        response.setFechaRegistro(producto.getFechaRegistro());

        if (producto.getStock() == 0) {
            response.setEstadoStock("SIN STOCK");
        } else if (producto.getStock() < 10) {
            response.setEstadoStock("STOCK BAJO");
        } else {
            response.setEstadoStock("DISPONIBLE");
        }

        return response;
    }

}
