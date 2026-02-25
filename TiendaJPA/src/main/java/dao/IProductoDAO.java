/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import dominio.Producto;
import java.util.List;

/**
 *
 * @author jalt2
 */
public interface IProductoDAO {
    public void insertar(Producto p);
    public void actualizar(Producto p);
    public void eliminar(Integer id);
    public Producto buscar(Integer id);
    public List<Producto> listar();
}
