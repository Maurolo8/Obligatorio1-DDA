package Persistencia;

import Dominio.Hotel;
import Utilities.AppException;
import Utilities.AppSQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class pHotel {
    Conexion c = new Conexion();

    public pHotel(){}

    public boolean agregarHotel(Hotel PHotel){
        String sql = "INSERT INTO hoteles VALUES(?, ?, ?, ?, ?, ?, ?)";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(PHotel.getId(), PHotel.getNombre(), PHotel.getCiudad(), PHotel.getPais(), PHotel.getEstrellas(), PHotel.getDireccion(), PHotel.getZona()));

        try {
            if (this.c.consulta(sql, parametros)) {
                System.out.println("Se agregó el hotel con éxito");
                return true;
            } else {
                System.out.println("Existió un problema al agregar el hotel");
                return false;
            }
        } catch (AppSQLException var5) {
            AppSQLException e = var5;
            System.out.println(e.getMessage());
            return false;
        }
        catch (Exception e){
            System.out.println("Error externo");
            return false;
        }
    }

    public boolean modificarHotel(Hotel PHotel) {
        String sql = "UPDATE hoteles SET NOMBRE = ?, CIUDAD = ?, PAIS = ?, ESTRELLAS = ?, DIRECCION = ?, ZONA = ? WHERE IDHotel = ?";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(PHotel.getNombre(), PHotel.getCiudad(), PHotel.getPais(), PHotel.getEstrellas(), PHotel.getDireccion(), PHotel.getZona(), PHotel.getId()));

        try {
            if (this.c.consulta(sql, parametros)) {
                System.out.println("Se modificó el hotel con éxito");
                return true;
            } else {
                System.out.println("Existió un problema al modificar el hotel");
                return false;
            }
        } catch (AppSQLException var5) {
            AppSQLException e = var5;
            System.out.println(e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error externo");
            return false;
        }
    }

    public boolean eliminarHotel(int id){
        String sql = "DELETE FROM hoteles WHERE idHotel=?";
        ArrayList<Object> par = new ArrayList(Arrays.asList(id));

        try {
            if (this.c.consulta(sql, par)) {
                System.out.println("Se eliminó el hotel con éxito");
                return true;
            } else {
                System.out.println("Existió un problema al eliminar el hotel");
                return false;
            }
        } catch (AppSQLException var5) {
            AppSQLException e = var5;
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Hotel buscarHotel(int pId) {
        String sql = "SELECT idHotel, nombre, ciudad, pais, estrellas, direccion, zona FROM hoteles WHERE idHotel= ?";

        try {
            List<List<Object>> resultado = this.c.seleccion(sql, new ArrayList(Arrays.asList(pId)));
            if(resultado.isEmpty()){
                throw new AppException("Hoteles con ese id no encontrados");
            }
            int id = (Integer)((List)resultado.get(0)).get(0);
            String nombre = String.valueOf(((List)resultado.get(0)).get(1));
            String ciudad = String.valueOf(((List)resultado.get(0)).get(2));
            String pais = String.valueOf(((List)resultado.get(0)).get(3));
            int estrellas = (Integer)((List)resultado.get(0)).get(4);
            String direccion = String.valueOf(((List)resultado.get(0)).get(5));
            String zona = String.valueOf(((List)resultado.get(0)).get(6));
            Hotel h = new Hotel(id, nombre, ciudad, pais, estrellas, direccion, zona);
            return h;
        }
        catch (AppException ae){
            System.out.println(ae.getMessage());
            return null;
        }
        catch (AppSQLException var10) {
            AppSQLException e = var10;
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<Hotel> listarHoteles(){
        String sql = "SELECT idHotel, nombre, ciudad, pais, estrellas, direccion, zona FROM hoteles";
        try {
            List<List<Object>> resultado = this.c.seleccion(sql, (List)null);
            ArrayList<Hotel> hoteles = new ArrayList();
            Iterator var4 = resultado.iterator();

            while (var4.hasNext()) {
                List<Object> fila = (List)var4.next();
                int id = (Integer)fila.get(0);
                String nombre = String.valueOf(fila.get(1));
                String ciudad = String.valueOf(fila.get(2));
                String pais = String.valueOf(fila.get(3));
                int estrellas = (Integer)fila.get(4);
                String direccion = String.valueOf(fila.get(5));
                String zona = String.valueOf(fila.get(6));
                hoteles.add(new Hotel(id, nombre, ciudad, pais, estrellas, direccion, zona));
            }

            return hoteles;
        }
        catch (AppSQLException SQLe){
            AppSQLException e = SQLe;
            System.out.println(e.getMessage());
            return null;
        }

    }
}
