import { Component } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';

@Component({
  selector: 'app-producto-lista',
  standalone: true,
  imports: [],
  templateUrl: './producto-lista.component.html',
})
export class ProductoListaComponent {
  productos: Producto[];

  constructor(private productoServicio: ProductoService) {}

  ngOnInit() {
    //cargamos los productos
    this.obtenerProductos();
  }
  private obtenerProductos() {
    //Consumir los datos del observable (suscribirnos)
    this.productoServicio.obtenerProductosLista().subscribe((datos) => {
      this.productos = datos;
    });
  }
}
