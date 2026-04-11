package dtos;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductoRequestDTO {

    @NotBlank(message = "{producto.nombre.notblank}")
    @Size(min = 3, max = 100, message = "{producto.nombre.size}")
    private String nombre;

    @Size(max = 500, message = "{producto.descripcion.size}")
    private String descripcion;

    @NotNull(message = "{producto.precio.notnull}")
    @Positive(message = "{producto.precio.positive}")
    @DecimalMax(value = "99999.99", message = "{producto.precio.max}")
    private BigDecimal precio;

    @NotNull(message = "{producto.stock.notnull}")
    @Min(value = 0, message = "{producto.stock.min}") @Max(value = 9999, message = "{producto.stock.max}")
    private Integer stock;

    @NotBlank(message = "{producto.emailProveedor.notblank}")
    @Email(message = "{producto.emailProveedor.email}")
    private String emailProveedor;

    @Future(message = "{producto.fechaVencimiento.future}")
    private LocalDate fechaVencimiento;

    @Pattern(regexp = "[A-Z]{3}-\\d{4}", message = "{producto.codigoSKU.pattern}")
    private String codigoSKU;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCodigoSKU() {
        return codigoSKU;
    }

    public void setCodigoSKU(String codigoSKU) {
        this.codigoSKU = codigoSKU;
    }
}
