/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author windows
 */
public class ClientesDAO 
{
    Connection conexion;


         public ClientesDAO() throws ClassNotFoundException
	{
		Conexion con=new Conexion();
		conexion=con.getConnection();
	}

    public List<Clientes> listarClientes()
    {
       PreparedStatement ps;
       ResultSet rs;   
       List<Clientes> lista=new ArrayList<>(); 


       try
       {

           ps=conexion.prepareStatement("select * from clientes where activo = 1");
	   rs=ps.executeQuery();

           while(rs.next())
           {
               int id=rs.getInt("cliente_id");
               String nombre=rs.getString("nombre");
               String apellido=rs.getString("apellido");
               String direccion=rs.getString("direccion");
               String localidad=rs.getString("localidad");             
               LocalDate fecha = rs.getDate("fecha_nac").toLocalDate();
               String email=rs.getString("email");
               String telefono=rs.getString("telefono");
               boolean activo=rs.getBoolean("activo");                 
               Clientes c1=new Clientes(id,nombre,apellido,direccion,localidad,fecha,email,telefono,activo);
               lista.add(c1);                

           }


       }
       catch(SQLException e)
       {
           System.out.println(e);
           //return null;
       }     


        return lista;


    }


    public Clientes mostrarCliente(int _id)
    {
        PreparedStatement ps;
        ResultSet rs;
        Clientes c1=null;
        try
        {
            ps=conexion.prepareStatement("select * from clientes where cliente_id=?");
            ps.setInt(1, _id);
            rs=ps.executeQuery();
            while(rs.next())
            {
                int id=rs.getInt("cliente_id");
                String nombre=rs.getString("nombre");
                String apellido=rs.getString("apellido");
                String direccion=rs.getString("direccion");
                String localidad=rs.getString("Localidad");
                LocalDate fnac = rs.getDate("fecha_nac").toLocalDate();
                String email=rs.getString("email");
                String telefono=rs.getString("telefono");
                boolean activo=rs.getBoolean("activo");                 
                c1=new Clientes(id,nombre,apellido,direccion,localidad,fnac,email,telefono,activo);
            }


            return c1;

        }
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }

    }


    public boolean InsertClientes(Clientes c1)
    {
        PreparedStatement ps;

        try
        {
            ps=conexion.prepareStatement("insert into clientes (nombre,apellido,direccion,localidad,fecha_nac,email,telefono,activo) values (?,?,?,?,?,?,?,?)");
            ps.setString(1, c1.getNombre());
            ps.setString(2, c1.getApellido());
            ps.setString(3, c1.getDireccion());
            ps.setString(4, c1.getLocalidad());
            ps.setObject(5, c1.getFnac()); 
            ps.setString(6, c1.getMail());
            ps.setString(7, c1.getTelefono());
            ps.setBoolean(8, true);
            ps.execute();
            return true;        

        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;
        }
    }


    public boolean EliminarCliente(int _id)
    {
        PreparedStatement ps;

        try
        {
            ps=conexion.prepareStatement("update clientes set activo = false where cliente_id=?");
            ps.setInt(1,_id);            
            ps.execute();
            return true;          

        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;
        }
    }

    public boolean ActualizarClientes(Clientes c1)
    {
        PreparedStatement ps;        
        try
        {
            ps=conexion.prepareStatement("update clientes set nombre=?,apellido=?,direccion=?,localidad=?,fecha_nac=?,email=?,telefono=?,activo=? where cliente_id=?");
            ps.setString(1, c1.getNombre());
            ps.setString(2, c1.getApellido());
            ps.setString(3, c1.getDireccion());
            ps.setString(4, c1.getLocalidad());
            ps.setObject(5, c1.getFnac()); 
            ps.setString(6, c1.getMail());
            ps.setString(7, c1.getTelefono());
            ps.setBoolean(8, c1.isActivo());
            ps.setInt(9,c1.getIdCliente());
            ps.execute();
            return true;          

        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;
        }
    }

}
