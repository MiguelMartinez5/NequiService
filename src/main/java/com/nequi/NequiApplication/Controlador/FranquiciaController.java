package com.nequi.NequiApplication.Controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nequi.NequiApplication.Medelo.Franquicia;
import com.nequi.NequiApplication.Medelo.Sucursal;
import com.nequi.NequiApplication.Medelo.Producto;
import com.nequi.NequiApplication.Servicio.FranquiciaService;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/api/franquicias")
public class FranquiciaController {

    @Autowired
    private FranquiciaService service;


    @GetMapping("/todas")
    public ResponseEntity<List<Franquicia>> getFranquicias() {
        List<Franquicia> lista = service.obtenerFranquicias();
        return ResponseEntity.ok(lista);
    }



    @PostMapping
    public ResponseEntity<String> nuevaFranquicia(@RequestBody Franquicia f) {
        service.agregarFranquicia(f);
        return ResponseEntity.ok("Franquicia creada");
    }

    @PostMapping("/{idFranquicia}/sucursales")
    public ResponseEntity<String> nuevaSucursal(@PathVariable Long idFranquicia, @RequestBody Sucursal s) {
        s.setFranquiciaId(idFranquicia);
        service.agregarSucursal(s);
        return ResponseEntity.ok("Sucursal agregada");
    }

    @PostMapping("/sucursales/{idSucursal}/productos")
    public ResponseEntity<String> nuevoProducto(@PathVariable Long idSucursal, @RequestBody Producto p) {
        p.setSucursalId(idSucursal);
        service.agregarProducto(p);
        return ResponseEntity.ok("Producto agregado");
    }

    @DeleteMapping("/productos/{idProducto}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long idProducto) {
        service.eliminarProducto(idProducto);
        return ResponseEntity.ok("Producto eliminado");
    }

    @PutMapping("/productos/{idProducto}/stock")
    public ResponseEntity<String> actualizarStock(
            @PathVariable Long idProducto,
            @RequestBody Map<String, Integer> body) {
        if (body.get("stock") == null || body.get("stock") < 0) {
            return ResponseEntity.badRequest().body("El stock debe ser un número válido mayor o igual a cero");
        }
        service.actualizarStock(idProducto, body.get("stock"));
        return ResponseEntity.ok("Stock actualizado");
    }

    @GetMapping("/{idFranquicia}/productos-max-stock")
    public ResponseEntity<List<Map<String, Object>>> productoConMasStock(@PathVariable Long idFranquicia) {
        List<Map<String, Object>> productos = service.obtenerProductoConMasStockPorSucursal(idFranquicia);
        return ResponseEntity.ok(productos);
    }

    @PutMapping("/{idFranquicia}/actualizar-nombre")
    public ResponseEntity<String> actualizarNombreFranquicia(
            @PathVariable Long idFranquicia,
            @RequestBody Map<String, String> body) {
        String nuevoNombre = body.get("nuevoNombre");
        if (nuevoNombre == null || nuevoNombre.isBlank()) {
            return ResponseEntity.badRequest().body("El nuevo nombre no puede estar vacío");
        }
        service.actualizarNombreFranquicia(idFranquicia, nuevoNombre);
        return ResponseEntity.ok("Nombre de franquicia actualizado");
    }

    @PutMapping("/sucursales/{idSucursal}/actualizar-nombre")
    public ResponseEntity<String> actualizarNombreSucursal(
            @PathVariable Long idSucursal,
            @RequestBody Map<String, String> body) {
        String nuevoNombre = body.get("nuevoNombre");
        if (nuevoNombre == null || nuevoNombre.isBlank()) {
            return ResponseEntity.badRequest().body("El nuevo nombre no puede estar vacío");
        }
        service.actualizarNombreSucursal(idSucursal, nuevoNombre);
        return ResponseEntity.ok("Nombre de sucursal actualizado");
    }

    @PutMapping("/productos/{idProducto}/actualizar-nombre")
    public ResponseEntity<String> actualizarNombreProducto(
            @PathVariable Long idProducto,
            @RequestBody Map<String, String> body) {
        String nuevoNombre = body.get("nuevoNombre");
        if (nuevoNombre == null || nuevoNombre.isBlank()) {
            return ResponseEntity.badRequest().body("El nuevo nombre no puede estar vacío");
        }
        service.actualizarNombreProducto(idProducto, nuevoNombre);
        return ResponseEntity.ok("Nombre de producto actualizado");
    }
}

