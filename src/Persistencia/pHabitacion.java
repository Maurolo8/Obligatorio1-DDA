package Persistencia;

import Dominio.Habitacion;
import Utilities.AppException;
import Utilities.AppSQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class pHabitacion {
    Conexion c = new Conexion();

    public pHabitacion(){}

    public boolean agregarHabitacion(Habitacion PHabitacion){
        String sql = "INSERT INTO habitaciones VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(PHabitacion.getIdHabitacion(), PHabitacion.getIdHotel(), PHabitacion.getCapacidadCamas(), PHabitacion.getCamasMatrimoniales(), PHabitacion.isAireAcondicionado(), PHabitacion.isBalcon(), PHabitacion.isVista(), PHabitacion.getAmenities(), PHabitacion.getEstado()));

        try {
            if (this.c.consulta(sql, parametros)) {
                System.out.println("Se agregó la habitacion con éxito");
                return true;
            } else {
                System.out.println("Existió un problema al agregar la habitacione");
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

    public boolean modificarHabitacion(Habitacion PHabitacion) {
        String sql = "UPDATE habitaciones SET capacidadCamas = ?, camasMatrimoniales = ?, aireAcondicionado = ?, balcon = ?, vista = ?, amenities = ?, estado = ? WHERE idHabitacion = ? AND idHotel = ?";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(PHabitacion.getCapacidadCamas(), PHabitacion.getCamasMatrimoniales(), PHabitacion.isAireAcondicionado(), PHabitacion.isBalcon(), PHabitacion.isVista(), PHabitacion.getAmenities(), PHabitacion.getEstado(), PHabitacion.getIdHabitacion(), PHabitacion.getIdHotel()));

        try {
            if (this.c.consulta(sql, parametros)) {
                System.out.println("Se modificó la habitacion con idHabitacion: "+PHabitacion.getIdHabitacion()+" e idHotel: "+PHabitacion.getIdHotel()+" con éxito");
                return true;
            } else {
                System.out.println("Existió un problema al modificar la habitacion");
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

    public boolean eliminarHabitacion(int idHa, int idHo){
        String sql = "DELETE FROM HABITACIONES WHERE idHabitacion=? AND idHotel = ?";
        ArrayList<Object> par = new ArrayList(Arrays.asList(idHa, idHo));

        try {
            if (this.c.consulta(sql, par)) {
                System.out.println("Se eliminó la habitacion con éxito");
                return true;
            } else {
                System.out.println("Existió un problema al eliminar la habitacion");
                return false;
            }
        } catch (AppSQLException var5) {
            AppSQLException e = var5;
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Habitacion buscarHabitacion(int pIdHa, int pIdHo) {
        String sql = "SELECT idHabitacion, idHotel, capacidadCamas, camasMatrimoniales, aireAcondicionado, balcon, vista, amenities, estado FROM habitaciones WHERE idHabitacion = ? AND idHotel = ?";

        try {
            List<List<Object>> resultado = this.c.seleccion(sql, new ArrayList(Arrays.asList(pIdHa, pIdHo)));
            if(resultado.isEmpty()){
                throw new AppException("Combinacion de hotel y habitacion no encontrado");
            }
            int idHa = (Integer)((List)resultado.get(0)).get(0);
            int idHo = (Integer)((List)resultado.get(0)).get(1);
            int capacidad = (Integer)((List)resultado.get(0)).get(2);
            int camasM = (Integer)((List)resultado.get(0)).get(3);
            Boolean aireA = (Boolean)((List)resultado.get(0)).get(4);
            Boolean balcon = (Boolean)((List)resultado.get(0)).get(5);
            Boolean vistas = (Boolean)((List)resultado.get(0)).get(6);
            String amenities = String.valueOf(((List)resultado.get(0)).get(7));
            String estado = String.valueOf(((List)resultado.get(0)).get(8));
            Habitacion ha = new Habitacion(idHa, idHo, capacidad, camasM, aireA, balcon, vistas, amenities, estado);
            return ha;
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

    public ArrayList<Habitacion> listarHabitaciones(){
        String sql = "SELECT idHabitacion, idHotel, capacidadCamas, camasMatrimoniales, aireAcondicionado, balcon, vista, amenities, estado FROM habitaciones";
        try {
            List<List<Object>> resultado = this.c.seleccion(sql, (List)null);
            ArrayList<Habitacion> habitaciones = new ArrayList();
            Iterator var4 = resultado.iterator();

            while (var4.hasNext()) {
                List<Object> fila = (List)var4.next();
                int idHa = (Integer)fila.get(0);
                int idHo = (Integer)fila.get(1);
                int capacidad = (Integer)fila.get(2);
                int camasM = (Integer)fila.get(3);
                boolean aireA = (Boolean)fila.get(4);
                boolean balcon = (Boolean)fila.get(5);
                boolean vistas = (Boolean)fila.get(6);
                String amenities = String.valueOf(fila.get(7));
                String estado = String.valueOf(fila.get(8));
                habitaciones.add(new Habitacion(idHa, idHo, capacidad, camasM, aireA, balcon, vistas, amenities, estado));
            }

            return habitaciones;
        }
        catch (AppSQLException SQLe){
            AppSQLException e = SQLe;
            System.out.println(e.getMessage());
            return null;
        }

    }
}
