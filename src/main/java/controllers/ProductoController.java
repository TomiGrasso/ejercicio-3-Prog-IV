package controllers;

import dtos.ProductoRequestDTO;
import dtos.ProductoResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.ProductoService;

import javax.xml.stream.Location;
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
