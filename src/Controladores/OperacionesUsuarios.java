/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import Modelos.Usuarios;
import Vistas.Principal;
import Vistas.Login;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Diego
 */
public class OperacionesUsuarios {
    
       private Session sesion;
       
       @Transactional 
       public boolean LoginUsuario(String nombre,String pass,Login login){
           iniciaOperacion();
           Usuarios usuario = (Usuarios) sesion.createCriteria(Usuarios.class).add(Restrictions.eq("nombre", nombre)).uniqueResult();
           
           if(usuario!=null){
               
               if(usuario.getPass().equals(pass)){
                   JOptionPane.showMessageDialog(null, "Bienvenido "+usuario.getNombre());
                   terminaOperacion();
                   Principal prin = new Principal();
                   prin.setVisible(true);   
                   login.dispose();
                   return true;
                   
               }else{
                   JOptionPane.showMessageDialog(null, "La contraseña introducida no es correcta");
                   return false;
               }
           }else{
               JOptionPane.showMessageDialog(null, "El usuario no existe");
               return false;
               
           }
           
       }
    
     //con transactional podemos volver a ejecutar otros métodos
    @Transactional
    private void iniciaOperacion(){
    
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        sesion = sessionFactory.openSession();
        sesion.beginTransaction();
    }
    
    @Transactional
    private void terminaOperacion(){
        sesion.getTransaction().commit();
        sesion.close();
    }
    @Transactional
    public int guardaUsuario(Usuarios usuario){
        int id = 0;
        iniciaOperacion();
        id = (int)sesion.save(usuario);
        terminaOperacion();
        JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
        return id;
    }
    @Transactional 
    public List<Usuarios> ListaUsuarios(){
         
         ArrayList<Usuarios> listaUsuarios = null;
         iniciaOperacion();
         listaUsuarios = (ArrayList<Usuarios>) sesion.createQuery("from Usuarios").list();
         terminaOperacion();         
         return listaUsuarios;
     }
    
    
    
    public int eliminaUsuario(Usuarios usuario){
        int id = usuario.getIdusuario();
        iniciaOperacion();
        sesion.delete(usuario);
        terminaOperacion();
        JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
        return id;
    } 
    
    @Transactional
    public Usuarios seleccionaUsuario(Usuarios usuario){
        int id = usuario.getIdusuario();
        iniciaOperacion();
        usuario = (Usuarios) sesion.get(Usuarios.class, id);    
        terminaOperacion();        
        return usuario;
    }
    @Transactional
    public int actualizaUsuario(Usuarios usuario){
        int id = usuario.getIdusuario();
        iniciaOperacion();        
        sesion.update(usuario);       
        terminaOperacion();
        JOptionPane.showMessageDialog(null, "Usuario modificado correctamente");
        return id;
    }
  
    @Transactional 
    public List<Usuarios> ListaUsuariosBuscar(String nombre){
         
         ArrayList<Usuarios> listaUsuarios = null;
         iniciaOperacion();
         listaUsuarios = (ArrayList<Usuarios>) sesion.createQuery("from Usuarios WHERE nombre ='"+nombre+"'").list();
         terminaOperacion();         
         return listaUsuarios;
     }
    
}
