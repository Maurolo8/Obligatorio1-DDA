package Persistencia;

import Dominio.Huesped;
import Utilities.AppException;
import Utilities.AppSQLException;

import java.awt.*;
import java.awt.geom.PathIterator;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

public class pHuesped {
    Conexion c = new Conexion();

    public pHuesped(){}

    public boolean agregarHuesped(Huesped PHuesped){
        String sql = "INSERT INTO Huespedes VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(PHuesped.getIdHuesped(), PHuesped.getNombre(), PHuesped.getApaterno(), PHuesped.getAmaterno(), PHuesped.getTipo_documento(), PHuesped.getNum_documento(), PHuesped.getFecha_nacimineto(), PHuesped.getTelefono(), PHuesped.getPais()));

        try {
            if (this.c.consulta(sql, parametros)) {
                System.out.println("Se agregó el Huesped con éxito");
                return true;
            } else {
                System.out.println("Existió un problema al agregar el huesped");
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

    public boolean modificarHuesped(Huesped PHuesped) {
        String sql = "UPDATE huespedes SET nombre = ?, apaterno = ?, amaterno = ?, tipo_documento = ?, num_documento = ?, fecha_nacimiento = ?, telefono = ?, pais = ? WHERE idHuesped = ?";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(PHuesped.getNombre(), PHuesped.getApaterno(), PHuesped.getAmaterno(), PHuesped.getTipo_documento(), PHuesped.getNum_documento(), PHuesped.getFecha_nacimineto(), PHuesped.getTelefono(), PHuesped.getPais(), PHuesped.getIdHuesped()));

        try {
            if (this.c.consulta(sql, parametros)) {
                System.out.println("Se modificó el huesped con éxito");
                return true;
            } else {
                System.out.println("Ocurrió un problema al modificar el huesped");
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

    public boolean eliminarHuesped(int idH){
        String sql = "DELETE FROM Huespedes WHERE idHuesped=?";
        ArrayList<Object> par = new ArrayList(Arrays.asList(idH));

        try {
            if (this.c.consulta(sql, par)) {
                System.out.println("Se eliminó el huesped con éxito");
                return true;
            } else {
                System.out.println("Existió un problema al eliminar el Huesped");
                return false;
            }
        } catch (AppSQLException var5) {
            AppSQLException e = var5;
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Huesped buscarHuesped(int pIdH) {
        String sql = "SELECT idHuesped, nombre, apaterno, amaterno, tipo_documento, num_documento, fecha_nacimiento, telefono, pais FROM huespedes WHERE idHuesped = ?";

        try {
            List<List<Object>> resultado = this.c.seleccion(sql, new ArrayList(Arrays.asList(pIdH)));
            if(resultado.isEmpty()){
                throw new AppException("Huesped con ese ID no encontrado");
            }
            int idH = (Integer)((List)resultado.get(0)).get(0);
            String nombre = String.valueOf(((List)resultado.get(0)).get(1));
            String apaterno = String.valueOf(((List)resultado.get(0)).get(2));
            String amaterno = String.valueOf(((List)resultado.get(0)).get(3));
            String tipo_doc = String.valueOf(((List)resultado.get(0)).get(4));
            String num_doc = String.valueOf(((List)resultado.get(0)).get(5));
            LocalDate fecha_nac= LocalDate.parse(String.valueOf(((List)resultado.get(0)).get(6)));
            String telefono = String.valueOf(((List)resultado.get(0)).get(7));
            String pais = String.valueOf(((List)resultado.get(0)).get(8));
            Huesped hu = new Huesped(idH, nombre, apaterno, amaterno, tipo_doc, num_doc, fecha_nac, telefono,pais);
            return hu;
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

    public ArrayList<Huesped> listarHuespedes(){
        String sql = "SELECT idHuesped, nombre, apaterno, amaterno, tipo_documento, num_documento, fecha_nacimiento, telefono, pais FROM huespedes";
        try {
            List<List<Object>> resultado = this.c.seleccion(sql, (List)null);
            ArrayList<Huesped> huespedes = new ArrayList();
            Iterator var4 = resultado.iterator();

            while (var4.hasNext()) {
                List<Object> fila = (List)var4.next();
                int idH = (Integer)fila.get(0);
                String  nombre = String.valueOf(fila.get(1));
                String apaterno = String.valueOf(fila.get(2));
                String amaterno = String.valueOf(fila.get(3));
                String tipo_doc = String.valueOf(fila.get(4));
                String num_doc = String.valueOf(fila.get(5));
                LocalDate fecha_nac = (LocalDate) fila.get(6);
                String telefono = String.valueOf(fila.get(7));
                String pais = String.valueOf(fila.get(8));
                huespedes.add(new Huesped(idH, nombre, apaterno, amaterno, tipo_doc, num_doc, fecha_nac, telefono, pais));
            }

            return huespedes;
        }
        catch (AppSQLException SQLe){
            AppSQLException e = SQLe;
            System.out.println(e.getMessage());
            return null;
        }

    }
}
