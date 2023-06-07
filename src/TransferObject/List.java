
package TransferObject;

import java.util.ArrayList;

/**
 *
 * @author cesarcunyarache
 */
public class List {

    private ArrayList<ItemDTO> articulos;
    private double total;
    private int cantidad;

    public List() {
        articulos = new ArrayList<>();
        cantidad = 0;
        total = 0;
    }

    public void añadir(ItemDTO item) {
     
        if (!articulos.isEmpty()) {
            if (ingresar(item) == false) {
                articulos.add(item);
                cantidad++;
            }
        } else {
            articulos.add(item);
            cantidad++;
        }

    }

    public boolean ingresar(ItemDTO item) {
        boolean ingresar = false;
        for (ItemDTO articulo : articulos) {
            if (item.getProducto().getCodigo() == articulo.getProducto().getCodigo()) {
                articulo.setCantidad(articulo.getCantidad() + item.getCantidad());
                articulo.CalcularImporte();
                ingresar  = true;
            } else {
                ingresar= false;
            }
        }
        return ingresar;
    }

    public void eliminar(int codigo) {
        for (int i = 0; i < articulos.size(); i++) {
            ItemDTO articulo = articulos.get(i);
            if (articulo.getProducto().getCodigo() == codigo) {
                articulos.remove(i);
                cantidad--;
            }
        }
    }

    public double calcularTotal() {
        total = 0;
        for (ItemDTO articulo : articulos) {
            total += articulo.getImporte();
        }
        return total;
    }

    public ArrayList<ItemDTO> getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList<ItemDTO> articulos) {
        this.articulos = articulos;
    }

}
