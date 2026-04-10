package services;

import dtos.ProductoResponseDTO;
import models.Producto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductoService {

    private List<Producto> productos = new ArrayList<>();
    Long contadorId = 1L;

    public ProductoResponseDTO agregarProducto(Producto producto){
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
