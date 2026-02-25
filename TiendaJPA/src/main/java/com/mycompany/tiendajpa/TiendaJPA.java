/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tiendajpa;

import dao.IProductoDAO;
import dao.ProductoDAO;
import dominio.Producto;

/**
 *
 * @author jalt2
 */
public class TiendaJPA {

    public static void main(String[] args) {
        
        IProductoDAO dao = new ProductoDAO();
        
        // =============================
        // INSERTAR
        // =============================
        System.out.println("=== INSERTANDO PRODUCTOS ===");

        Producto p1 = new Producto(null, "Hamburguesa", 85.50);
        Producto p2 = new Producto(null, "Pizza", 120.00);

        dao.insertar(p1);
        dao.insertar(p2);

        // =============================
        // LISTAR
        // =============================
        System.out.println("\n=== LISTA DE PRODUCTOS ===");
        dao.listar().forEach(p ->
            System.out.println(p.getId() + " - " + p.getNombre() + " - $" + p.getPrecio())
        );

        // =============================
        // BUSCAR
        // =============================
        System.out.println("\n=== BUSCAR PRODUCTO ID 1 ===");
        Producto encontrado = dao.buscar(1);

        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.getNombre());
        }

        // =============================
        // ACTUALIZAR
        // =============================
        System.out.println("\n=== ACTUALIZANDO PRODUCTO ID 1 ===");

        if (encontrado != null) {
            encontrado.setPrecio(99.99);
            dao.actualizar(encontrado);
        }

        // Verificar actualización
        Producto actualizado = dao.buscar(1);
        System.out.println("Nuevo precio: $" + actualizado.getPrecio());

        // =============================
        // ELIMINAR
        // =============================
        System.out.println("\n=== ELIMINANDO PRODUCTO ID 2 ===");
        dao.eliminar(2);

        // =============================
        // LISTAR FINAL
        // =============================
        System.out.println("\n=== LISTA FINAL ===");
        dao.listar().forEach(p ->
            System.out.println(p.getId() + " - " + p.getNombre() + " - $" + p.getPrecio())
        );

    }
}
