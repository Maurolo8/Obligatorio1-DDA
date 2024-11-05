package Persistencia;

import Dominio.Tarifa;
import Utilities.AppException;
import Utilities.AppSQLException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class pTarifa {
    Conexion c = new Conexion();

    public pTarifa() {
    }

    public boolean agregarTarifa(Tarifa PTarifa) {
        String sql = "INSERT INTO Tarifas VALUES(?, ?, ?, ?)";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(PTarifa.getIdTarifa(), PTarifa.getIdHotel(), PTarifa.getFechaVigencia(), PTarifa.getMonto()));

        try {
            if (this.c.consulta(sql, parametros)) {
                System.out.println("Se agregó la tarifa con éxito");
                return true;
            } else {
                System.out.println("Existió un problema al agregar la tarifa");
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

    public boolean modificarTarifa(Tarifa PTarifa) {
        String sql = "UPDATE tarifas SET fechaVigencia = ?, monto = ? WHERE idTarifa = ? AND idHotel = ?";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(PTarifa.getFechaVigencia(), PTarifa.getMonto(), PTarifa.getIdTarifa(), PTarifa.getIdHotel()));

        try {
            if (this.c.consulta(sql, parametros)) {
                System.out.println("Se modificó la tarifa con éxito");
                return true;
            } else {
                System.out.println("Existió un problema al modificar la tarifa");
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

    public boolean eliminarTarifa(int idT, int idH) {
        String sql = "DELETE FROM Tarifas WHERE idTarifa=? AND idHotel = ?";
        ArrayList<Object> par = new ArrayList(Arrays.asList(idT, idH));

        try {
            if (this.c.consulta(sql, par)) {
                System.out.println("Se eliminó la tarifa con éxito");
                return true;
            } else {
                System.out.println("Existió un problema al eliminar la tarifa");
                return false;
            }
        } catch (AppSQLException var5) {
            AppSQLException e = var5;
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Tarifa buscarTarifa(int pIdT, int idHo) {
        String sql = "SELECT idTarifa, idHotel, fechaVigencia, monto FROM Tarifas WHERE idTarifa = ? AND idHotel = ?";

        try {
            List<List<Object>> resultado = this.c.seleccion(sql, new ArrayList(Arrays.asList(pIdT, idHo)));
            if (resultado.isEmpty()) {
                throw new AppException("Tarifa con ese ID y en ese hotel no encontrada");
            }
            int idT = (Integer) ((List) resultado.get(0)).get(0);
            int idH = (Integer) ((List) resultado.get(0)).get(1);
            LocalDate fechaRes = LocalDate.parse(String.valueOf(((List) resultado.get(0)).get(2)));
            Double monto = ((BigDecimal) ((List) resultado.get(0)).get(3)).doubleValue();
            Tarifa ta = new Tarifa(idT, idH, fechaRes, monto);
            return ta;
        } catch (AppException ae) {
            System.out.println(ae.getMessage());
            return null;
        } catch (AppSQLException var10) {
            AppSQLException e = var10;
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<Tarifa> listarTarifas() {
        String sql = "SELECT idTarifa, idHotel, fechaVigencia, monto FROM tarifas";
        try {
            List<List<Object>> resultado = this.c.seleccion(sql, (List) null);
            ArrayList<Tarifa> tarifas = new ArrayList();
            Iterator var4 = resultado.iterator();

            while (var4.hasNext()) {
                List<Object> fila = (List) var4.next();
                int idT = (Integer) fila.get(0);
                int idHo = (Integer) fila.get(1);
                LocalDate fechaVigencia = LocalDate.parse(String.valueOf(fila.get(2)));
                Double monto = (Double) fila.get(3);
                tarifas.add(new Tarifa(idT, idHo, fechaVigencia, monto));
            }

            return tarifas;
        } catch (AppSQLException SQLe) {
            AppSQLException e = SQLe;
            System.out.println(e.getMessage());
            return null;
        }
    }
}
