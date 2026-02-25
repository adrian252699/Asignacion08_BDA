/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jalt2
 */
public class ProductoDAO implements IProductoDAO{
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("TiendaPU");

    public ProductoDAO() {
    }
    
    

    @Override
    public void insertar(Producto p) {
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            
            em.persist(p);
            
            em.getTransaction().commit();
            em.close();
        }
    }

    @Override
    public void actualizar(Producto p) {
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            
            em.merge(p);
            
            em.getTransaction().commit();
            
            em.close();
        }
    }

    @Override
    public void eliminar(Integer id) {
        try(EntityManager em = emf.createEntityManager()){
            Producto productoEliminar = em.find(Producto.class, id);
            em.getTransaction().begin();
            if (productoEliminar != null) {
                
                em.remove(productoEliminar);
                
            }
            em.getTransaction().commit();
            em.close();
        }
    }

    @Override
    public Producto buscar(Integer id) {
        try(EntityManager em = emf.createEntityManager()){
            
            Producto productoEncontrado = em.find(Producto.class, id);
            em.close();
            return productoEncontrado;
        }
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        try(EntityManager em = emf.createEntityManager()){
            productos = em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
            em.close();
            return productos;
        }
    }

}
