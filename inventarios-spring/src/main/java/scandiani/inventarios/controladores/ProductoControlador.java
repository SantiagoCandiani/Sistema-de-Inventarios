package scandiani.inventarios.controladores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scandiani.inventarios.modelos.Producto;
import scandiani.inventarios.servicios.IProductoServicio;

import java.util.List;

@RestController
@RequestMapping("inventario-app") //http://localhost:8080/inventario-app/
@CrossOrigin(value = "http://localhost:4200")
public class ProductoControlador {

    //Para enviar informacion a consola
    private static final Logger logguer = LoggerFactory.getLogger(ProductoControlador.class);
    @Autowired
    private IProductoServicio productoServicio;

    @GetMapping("/productos") //http://localhost:8080/inventario-app/productos
    public List<Producto> obtenerProductos() {
        List<Producto> productos = this.productoServicio.listarProductos();
        logguer.info("Productos Obtenidos:");
        productos.forEach(producto -> logguer.info(producto.toString()));
        return productos;
    }


}//class