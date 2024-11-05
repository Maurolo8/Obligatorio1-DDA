package Persistencia;

import Dominio.Reserva;
import Utilities.AppException;
import Utilities.AppSQLException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class pReserva {
    Conexion c = new Conexion();

    public pReserva() {
    }

    public boolean agregarReserva(Reserva PReserva) {
        String sql = "INSERT INTO Reservas VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(PReserva.getIdReserva(), PReserva.getIdHotel(), PReserva.getIdHabitacion(), PReserva.getIdHuesped(), PReserva.getCantidad_personas(), PReserva.getTipo(), PReserva.getFechaRes(), PReserva.getFechaInicio(), PReserva.getFechaFin(), PReserva.getObservacion(), PReserva.isEstado_pago(), PReserva.isPagoCompleto()));

        try {
            if (this.c.consulta(sql, parametros)) {
                System.out.println("Se agregó la reserva con éxito");
                return true;
            } else {
                System.out.println("Existió un problema al agregar la reserva");
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

    public boolean modificarReserva(Reserva PReserva) {
        String sql = "UPDATE reservas SET idHotel = ?, idHabitacion = ?, idHuesped = ?, cantidad_personas = ?, tipo = ?, fechaRes = ?, fechaInicio = ?, fechaFin = ?, observacion = ?, estado_pago = ?, pagoCompleto = ? WHERE idReserva = ?";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(PReserva.getIdHotel(), PReserva.getIdHabitacion(), PReserva.getIdHuesped(), PReserva.getCantidad_personas(), PReserva.getTipo(), PReserva.getFechaRes(), PReserva.getFechaInicio(), PReserva.getFechaFin(), PReserva.getObservacion(), PReserva.isEstado_pago(), PReserva.isPagoCompleto(), PReserva.getIdReserva()));

        try {
            if (this.c.consulta(sql, parametros)) {
                System.out.println("Se modificó la reserva con éxito");
                return true;
            } else {
                System.out.println("Existió un problema al modificar la reserva");
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

    public boolean eliminarReserva(int idR) {
        String sql = "DELETE FROM Reservas WHERE idReserva=?";
        ArrayList<Object> par = new ArrayList(Arrays.asList(idR));

        try {
            if (this.c.consulta(sql, par)) {
                System.out.println("Se eliminó la reserva con éxito");
                return true;
            } else {
                System.out.println("Existió un problema al eliminar la reserva");
                return false;
            }
        } catch (AppSQLException var5) {
            AppSQLException e = var5;
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Reserva buscarReserva(int pIdR) {
        String sql = "SELECT idReserva, idHotel, idHabitacion, idHuesped, cantidad_personas, tipo, fechaRes, fechaInicio, fechaFin, observacion, estado_pago, pagoCompleto FROM Reservas WHERE idReserva = ?";

        try {
            List<List<Object>> resultado = this.c.seleccion(sql, new ArrayList(Arrays.asList(pIdR)));
            if (resultado.isEmpty()) {
                throw new AppException("Reserva con ese ID no encontrada");
            }
            int idR = (Integer) ((List) resultado.get(0)).get(0);
            int idH = (Integer) ((List) resultado.get(0)).get(1);
            int idHo = (Integer) ((List) resultado.get(0)).get(2);
            int idHu = (Integer) ((List) resultado.get(0)).get(3);
            int cantidadP = (Integer) ((List) resultado.get(0)).get(4);
            String tipo = String.valueOf(((List) resultado.get(0)).get(5));
            LocalDate fechaRes = LocalDate.parse(String.valueOf(((List)resultado.get(0)).get(6)));
            LocalDate fechaInicio = LocalDate.parse(String.valueOf(((List)resultado.get(0)).get(7)));
            LocalDate fechaFin = LocalDate.parse(String.valueOf(((List)resultado.get(0)).get(8)));
            String observaciones = String.valueOf(((List) resultado.get(0)).get(9));
            Boolean estado_pago = (Boolean) ((List) resultado.get(0)).get(10);
            Boolean pagoCompleto = (Boolean) ((List) resultado.get(0)).get(11);
            Reserva re = new Reserva(idR, idH, idHo, idHu, cantidadP, tipo, fechaRes, fechaInicio, fechaFin, observaciones, estado_pago, pagoCompleto);
            return re;
        } catch (AppException ae) {
            System.out.println(ae.getMessage());
            return null;
        } catch (AppSQLException var10) {
            AppSQLException e = var10;
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<Reserva> listarReservas() {
        String sql = "SELECT idReserva, idHotel, idHabitacion, idHuesped, cantidad_personas, tipo, fechaRes, fechaInicio, fechaFin, observacion, estado_pago, pagoCompleto FROM reservas";
        try {
            List<List<Object>> resultado = this.c.seleccion(sql, (List) null);
            ArrayList<Reserva> reservas = new ArrayList();
            Iterator var4 = resultado.iterator();

            while (var4.hasNext()) {
                List<Object> fila = (List) var4.next();
                int idR = (Integer) fila.get(0);
                int idHo = (Integer) fila.get(1);
                int idHa = (Integer) fila.get(2);
                int idHu = (Integer) fila.get(3);
                int cantidadP = (Integer) fila.get(4);
                String tipo = String.valueOf(fila.get(5));
                LocalDate fechaRes = LocalDate.parse(String.valueOf(fila.get(6)));
                LocalDate fechaInicio = LocalDate.parse(String.valueOf(fila.get(7)));
                LocalDate fechaFin = LocalDate.parse(String.valueOf(fila.get(8)));
                String observacion = String.valueOf(fila.get(9));
                Boolean estado_pago = (Boolean) fila.get(10);
                Boolean pagoCompleto = (Boolean) fila.get(11);
                reservas.add(new Reserva(idR, idHo, idHa, idHu, cantidadP, tipo, fechaRes, fechaInicio, fechaFin, observacion, estado_pago, pagoCompleto));
            }

            return reservas;
        } catch (AppSQLException SQLe) {
            AppSQLException e = SQLe;
            System.out.println(e.getMessage());
            return null;
        }
    }
    public ArrayList<Reserva> listarReservasHabitacion(int pidHa, int pidHo) {
        String sql = "SELECT idReserva, idHotel, idHabitacion, idHuesped, cantidad_personas, tipo, fechaRes, fechaInicio, fechaFin, observacion, estado_pago, pagoCompleto FROM reservas WHERE idHabitacion = ? and idHotel = ?";
        try {
            List<List<Object>> resultado = this.c.seleccion(sql, new ArrayList(Arrays.asList(pidHa, pidHo)));
            ArrayList<Reserva> reservas = new ArrayList();
            Iterator var4 = resultado.iterator();

            while (var4.hasNext()) {
                List<Object> fila = (List) var4.next();
                int idR = (Integer) fila.get(0);
                int idHo = (Integer) fila.get(1);
                int idHa = (Integer) fila.get(2);
                int idHu = (Integer) fila.get(3);
                int cantidadP = (Integer) fila.get(4);
                String tipo = String.valueOf(fila.get(5));
                LocalDate fechaRes = LocalDate.parse(String.valueOf(fila.get(6)));
                LocalDate fechaInicio = LocalDate.parse(String.valueOf(fila.get(7)));
                LocalDate fechaFin = LocalDate.parse(String.valueOf(fila.get(8)));
                String observacion = String.valueOf(fila.get(9));
                Boolean estado_pago = (Boolean) fila.get(10);
                Boolean pagoCompleto = (Boolean) fila.get(11);
                reservas.add(new Reserva(idR, idHo, idHa, idHu, cantidadP, tipo, fechaRes, fechaInicio, fechaFin, observacion, estado_pago, pagoCompleto));
            }

            return reservas;
        } catch (AppSQLException SQLe) {
            AppSQLException e = SQLe;
            System.out.println(e.getMessage());
            return null;
        }
    }
}