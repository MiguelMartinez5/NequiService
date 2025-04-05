package com.nequi.NequiApplication.FranquiciaRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.nequi.NequiApplication.Medelo.Franquicia;
import com.nequi.NequiApplication.Medelo.Sucursal;
import com.nequi.NequiApplication.Medelo.Producto;
import java.util.List;
import java.util.Map;



@Repository
public class FranquiciaRepository {

    @Autowired
    private JdbcTemplate jdbc;



    public List<Franquicia> obtenerTodasFranquicias() {
        String sql = "SELECT * FROM franquicia";
        return jdbc.query(sql, (rs, rowNum) -> {
            Franquicia f = new Franquicia();
            f.setId(rs.getLong("id"));
            f.setNombre(rs.getString("nombre"));
                        return f;
        });
    }




    public void guardarFranquicia(Franquicia franquicia) {
        String sql = "INSERT INTO franquicia (nombre) VALUES (?)";
        jdbc.update(sql, franquicia.getNombre());
    }

    public void guardarSucursal(Sucursal sucursal) {
        String sql = "INSERT INTO sucursal (nombre, franquicia_id) VALUES (?, ?)";
        jdbc.update(sql, sucursal.getNombre(), sucursal.getFranquiciaId());
    }

    public void guardarProducto(Producto producto) {
        String sql = "INSERT INTO producto (nombre, stock, sucursal_id) VALUES (?, ?, ?)";
        jdbc.update(sql, producto.getNombre(), producto.getStock(), producto.getSucursalId());
    }

////////////////////////////////////////////////////////////////////



    public void eliminarProducto(Long productoId) {
        String sql = "DELETE FROM producto WHERE id = ?";
        jdbc.update(sql, productoId);
    }


    public void actualizarStock(Long productoId, int nuevoStock) {
        String sql = "UPDATE producto SET stock = ? WHERE id = ?";
        jdbc.update(sql, nuevoStock, productoId);
    }


    public List<Map<String, Object>> obtenerProductoConMasStockPorSucursal(Long franquiciaId) {
        String sql = """
        SELECT s.nombre AS sucursal, p.nombre AS producto, p.stock
        FROM sucursal s
        JOIN producto p ON s.id = p.sucursal_id
        WHERE s.franquicia_id = ?
        AND (p.stock, p.nombre) IN (
            SELECT MAX(p2.stock), p2.nombre
            FROM producto p2
            WHERE p2.sucursal_id = s.id
        )
    """;
        return jdbc.queryForList(sql, franquiciaId);
    }




    public void actualizarNombreFranquicia(Long franquiciaId, String nuevoNombre) {
        String sql = "UPDATE franquicia SET nombre = ? WHERE id = ?";
        jdbc.update(sql, nuevoNombre, franquiciaId);
    }


    public void actualizarNombreSucursal(Long sucursalId, String nuevoNombre) {
        String sql = "UPDATE sucursal SET nombre = ? WHERE id = ?";
        jdbc.update(sql, nuevoNombre, sucursalId);
    }


    public void actualizarNombreProducto(Long productoId, String nuevoNombre) {
        String sql = "UPDATE producto SET nombre = ? WHERE id = ?";
        jdbc.update(sql, nuevoNombre, productoId);
    }








}



