package com.nequi.NequiApplication.Servicio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nequi.NequiApplication.FranquiciaRepository.FranquiciaRepository;
import com.nequi.NequiApplication.Medelo.Franquicia;
import com.nequi.NequiApplication.Medelo.Sucursal;
import com.nequi.NequiApplication.Medelo.Producto;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;



@Service
public class FranquiciaService {

    @Autowired
    private FranquiciaRepository repository;




    public List<Franquicia> obtenerFranquicias() {
        try {
            return repository.obtenerTodasFranquicias();
        } catch (Exception e) {
            System.err.println("Error al obtener franquicias: " + e.getMessage());
            return new ArrayList<>();
        }
    }




    public void agregarFranquicia(Franquicia f) {
        try {
            repository.guardarFranquicia(f);
        } catch (Exception e) {
            System.err.println("Error al guardar franquicia: " + e.getMessage());
        }
    }

    public void agregarSucursal(Sucursal s) {
        try {
            repository.guardarSucursal(s);
        } catch (Exception e) {
            System.err.println("Error al guardar sucursal: " + e.getMessage());
        }
    }

    public void agregarProducto(Producto p) {
        try {
            repository.guardarProducto(p);
        } catch (Exception e) {
            System.err.println("Error al guardar producto: " + e.getMessage());
        }
    }

    public void eliminarProducto(Long productoId) {
        try {
            repository.eliminarProducto(productoId);
        } catch (Exception e) {
            System.err.println("Error al eliminar producto: " + e.getMessage());
        }
    }

    public void actualizarStock(Long productoId, int nuevoStock) {
        try {
            repository.actualizarStock(productoId, nuevoStock);
        } catch (Exception e) {
            System.err.println("Error al actualizar stock: " + e.getMessage());
        }
    }

    public List<Map<String, Object>> obtenerProductoConMasStockPorSucursal(Long franquiciaId) {
        try {
            return repository.obtenerProductoConMasStockPorSucursal(franquiciaId);
        } catch (Exception e) {
            System.err.println("Error al obtener productos: " + e.getMessage());
            return List.of(); // devuelve lista vacía si hay error
        }
    }

    public void actualizarNombreFranquicia(Long id, String nuevoNombre) {
        try {
            repository.actualizarNombreFranquicia(id, nuevoNombre);
        } catch (Exception e) {
            System.err.println("Error al actualizar nombre de franquicia: " + e.getMessage());
        }
    }

    public void actualizarNombreSucursal(Long id, String nuevoNombre) {
        try {
            repository.actualizarNombreSucursal(id, nuevoNombre);
        } catch (Exception e) {
            System.err.println("Error al actualizar nombre de sucursal: " + e.getMessage());
        }
    }

    public void actualizarNombreProducto(Long id, String nuevoNombre) {
        try {
            repository.actualizarNombreProducto(id, nuevoNombre);
        } catch (Exception e) {
            System.err.println("Error al actualizar nombre de producto: " + e.getMessage());
        }
    }
}

