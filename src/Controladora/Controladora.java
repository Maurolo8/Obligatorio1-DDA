package Controladora;

import Dominio.Hotel;
import Persistencia.pHotel;
import Dominio.Habitacion;
import Persistencia.pHabitacion;
import Dominio.Huesped;
import Persistencia.pHuesped;
import Dominio.Reserva;
import Persistencia.pReserva;
import Dominio.Tarifa;
import Persistencia.pTarifa;
import Utilities.AppException;
import Utilities.AppSQLException;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Controladora {
    private static pHotel PHotel = new pHotel();
    private static pHabitacion PHabitacion = new pHabitacion();
    private static pHuesped PHuesped = new pHuesped();
    private static pReserva PReserva = new pReserva();
    private static pTarifa PTarifa = new pTarifa();
    private static Scanner escaner = new Scanner(System.in);

    // <editor-fold desc= "Hotel">
    public boolean agregarHotel(){
        int id = 0;
        do {
            System.out.println("Ingrese el ID del hotel: ");

            try {
                id = Integer.parseInt(escaner.nextLine());
                Hotel h = buscarHotel(id);
                if(h != null){
                    throw new AppException("Id de hotel en uso");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                id = 0;
            }
            catch (NumberFormatException nfe){
                System.out.println("Se ingresó un id no numérico");
                id=0;
            }
        }
        while (id==0);

        String nombre = "";
        do{
            System.out.println("Ingrese nombre del Hotel: ");
            nombre = escaner.nextLine();

            try {
                if (nombre.length() < 3) {
                    throw new AppException("El largo del nombre debe ser mayor a 2 caracteres");
                }

                if (nombre.length() > 20) {
                    throw new AppException("El largo del nombre debe ser menor a 21 caracteres");
                }
            } catch (AppException var4) {
                AppException e = var4;
                nombre = "";
                System.out.println(e.getMessage());
            }
        }
        while (nombre.isEmpty());

        String ciudad = "";
        do{
            System.out.println("Ingrese ciudad del Hotel: ");
            ciudad = escaner.nextLine();

            try {
                if (ciudad.length() < 3) {
                    throw new AppException("El largo de la ciudad debe ser mayor a 2 caracteres");
                }

                if (ciudad.length() > 20) {
                    throw new AppException("El largo de la ciudad debe ser menor a 21 caracteres");
                }
            } catch (AppException var4) {
                AppException e = var4;
                ciudad = "";
                System.out.println(e.getMessage());
            }
        }
        while (ciudad.isEmpty());

        String pais = "";
        do{
            System.out.println("Ingrese pais del Hotel: ");
            pais = escaner.nextLine();

            try {
                if (pais.length() < 3) {
                    throw new AppException("El largo del pais debe ser mayor a 2 caracteres");
                }

                if (pais.length() > 20) {
                    throw new AppException("El largo del pais debe ser menor a 21 caracteres");
                }
            } catch (AppException var4) {
                AppException e = var4;
                pais = "";
                System.out.println(e.getMessage());
            }
        }
        while (pais.isEmpty());

        int estrellas = 0;
        do {
            System.out.println("Ingrese las estrellas del hotel: ");

            try {
                estrellas = Integer.parseInt(escaner.nextLine());

                if(estrellas<0){
                    throw new AppException("Estrellas no puede ser menor a 0");
                }
                if(estrellas>5){
                    throw new AppException("Estrellas no puede ser mayor a 5");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                estrellas=0;
            }
            catch (NumberFormatException nfe){
                System.out.println("Se ingresó valor de estrellas no numérico");
                estrellas = 0;
            }
        }
        while (estrellas==0);

        String direccion = "";
        do{
            System.out.println("Ingrese direccion del Hotel: ");
            direccion = escaner.nextLine();

            try {
                if (direccion.length() < 3) {
                    throw new AppException("El largo de la direccion debe ser mayor a 2 caracteres");
                }

                if (direccion.length() > 100) {
                    throw new AppException("El largo de la direccion debe ser menor a 100 caracteres");
                }
            } catch (AppException var4) {
                AppException e = var4;
                direccion = "";
                System.out.println(e.getMessage());
            }
        }
        while (direccion.isEmpty());

        String zona = "";
        do{
            System.out.println("Ingrese zona del Hotel: ");
            zona = escaner.nextLine();

            try {
                if (zona.length() < 3) {
                    throw new AppException("El largo de la zona debe ser mayor a 2 caracteres");
                }

                if (zona.length() > 100) {
                    throw new AppException("El largo de la zona debe ser menor a 100 caracteres");
                }
            } catch (AppException var4) {
                AppException e = var4;
                zona = "";
                System.out.println(e.getMessage());
            }
        }
        while (zona.isEmpty());

        Hotel hotel = new Hotel(id, nombre, ciudad, pais, estrellas, direccion, zona);
        return PHotel.agregarHotel(hotel);
    }
    public boolean modificarHotel(){
        int id = 0;
        do {
            System.out.println("Ingrese el ID del hotel: ");

            try {
                id = Integer.parseInt(escaner.nextLine());
                Hotel h = buscarHotel(id);
                if(h.getId() != id){
                    throw new AppException("Id de hotel no encontrado");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                id = 0;
            }
            catch (NumberFormatException nfe){
                System.out.println("Se ingresó un id no numérico");
                id=0;
            }
        }
        while (id==0);

        String nombre = "";
        do{
            System.out.println("Ingrese nombre del Hotel: ");
            nombre = escaner.nextLine();

            try {
                if (nombre.length() < 3) {
                    throw new AppException("El largo del nombre debe ser mayor a 2 caracteres");
                }

                if (nombre.length() > 20) {
                    throw new AppException("El largo del nombre debe ser menor a 21 caracteres");
                }
            } catch (AppException var4) {
                AppException e = var4;
                nombre = "";
                System.out.println(e.getMessage());
            }
        }
        while (nombre.isEmpty());

        String ciudad = "";
        do{
            System.out.println("Ingrese ciudad del Hotel: ");
            ciudad = escaner.nextLine();

            try {
                if (ciudad.length() < 3) {
                    throw new AppException("El largo de la ciudad debe ser mayor a 2 caracteres");
                }

                if (ciudad.length() > 20) {
                    throw new AppException("El largo de la ciudad debe ser menor a 21 caracteres");
                }
            } catch (AppException var4) {
                AppException e = var4;
                ciudad = "";
                System.out.println(e.getMessage());
            }
        }
        while (ciudad.isEmpty());

        String pais = "";
        do{
            System.out.println("Ingrese pais del Hotel: ");
            pais = escaner.nextLine();

            try {
                if (pais.length() < 3) {
                    throw new AppException("El largo del pais debe ser mayor a 2 caracteres");
                }

                if (pais.length() > 20) {
                    throw new AppException("El largo del pais debe ser menor a 21 caracteres");
                }
            } catch (AppException var4) {
                AppException e = var4;
                pais = "";
                System.out.println(e.getMessage());
            }
        }
        while (pais.isEmpty());

        int estrellas = 0;
        do {
            System.out.println("Ingrese las estrellas del hotel: ");

            try {
                estrellas = Integer.parseInt(escaner.nextLine());

                if(estrellas<0){
                    throw new AppException("Estrellas no puede ser menor a 0");
                }
                if(estrellas>5){
                    throw new AppException("Estrellas no puede ser mayor a 5");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                estrellas=0;
            }
            catch (NumberFormatException nfe){
                System.out.println("Se ingresó valor de estrellas no numérico");
                estrellas = 0;
            }
        }
        while (estrellas==0);

        String direccion = "";
        do{
            System.out.println("Ingrese direccion del Hotel: ");
            direccion = escaner.nextLine();

            try {
                if (direccion.length() < 3) {
                    throw new AppException("El largo de la direccion debe ser mayor a 2 caracteres");
                }

                if (direccion.length() > 100) {
                    throw new AppException("El largo de la direccion debe ser menor a 100 caracteres");
                }
            } catch (AppException var4) {
                AppException e = var4;
                direccion = "";
                System.out.println(e.getMessage());
            }
        }
        while (direccion.isEmpty());

        String zona = "";
        do{
            System.out.println("Ingrese zona del Hotel: ");
            zona = escaner.nextLine();

            try {
                if (zona.length() < 3) {
                    throw new AppException("El largo de la zona debe ser mayor a 2 caracteres");
                }

                if (zona.length() > 100) {
                    throw new AppException("El largo de la zona debe ser menor a 100 caracteres");
                }
            } catch (AppException var4) {
                AppException e = var4;
                zona = "";
                System.out.println(e.getMessage());
            }
        }
        while (zona.isEmpty());

        Hotel hotel = new Hotel(id, nombre, ciudad, pais, estrellas, direccion, zona);
        return PHotel.modificarHotel(hotel);
    }
    public boolean eliminarHotel(){
        int id = 0;
        do {
            System.out.println("Ingrese el ID del hotel: ");

            try {
                id = Integer.parseInt(escaner.nextLine());
                Hotel h = buscarHotel(id);
                if(h.getId() != id){
                    throw new AppException("Id de hotel no encontrado");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                id = 0;
            }
            catch (NumberFormatException nfe){
                System.out.println("Se ingresó un id no numérico");
                id=0;
            }
        }
        while (id==0);

        return PHotel.eliminarHotel(id);
    }
    public Hotel buscarHotel(int pId){
        return PHotel.buscarHotel(pId);
    }
    public ArrayList<Hotel> listarHoteles(){
        return PHotel.listarHoteles();
    }
    // </editor-fold>

    //<editor-fold desc="Habitacion">
    public boolean agregarHabitacion(){
        int idHa = 0;
        int idHo = 0;
        do {
            System.out.println("Ingrese el ID de la habitacion: ");

            try {
                idHa = Integer.parseInt(escaner.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Se ingresó un id no numérico");
                idHa = 0;
            }

            if (idHa != 0) {
                do {
                    System.out.println("Ingrese el ID del Hotel: ");

                    try {
                        idHo = Integer.parseInt(escaner.nextLine());
                        Hotel hotel = buscarHotel(idHo);
                        if(hotel == null){
                            throw new AppException("No hay hoteles con ese id");
                        }
                    }
                    catch (AppException ae){
                        System.out.println(ae.getMessage());
                        idHo = 0;
                    }
                    catch (NumberFormatException nfe) {
                        System.out.println("Se ingresó un id no numérico");
                        idHo = 0;
                    }
                }
                while (idHo == 0);
            }
            try {
                Habitacion ha = buscarHabitacion(idHa, idHo);
                if (ha != null) {
                    throw new AppException("Combinacion de id Habitacion e id Hotel en uso");
                }
            } catch (AppException ae) {
                System.out.println(ae.getMessage());
                idHa = 0;
                idHo = 0;
            }
        }
        while (idHa==0);

        int capacidad = 0;
        do {
                System.out.println("Ingrese la capacidad de la  habitacion: ");

                try {
                    capacidad = Integer.parseInt(escaner.nextLine());

                    if(capacidad<1){
                        throw new AppException("Capacidad no puede ser menor a 1");
                    }
                    if(capacidad>10){
                        throw new AppException("Capacidad no puede ser mayor a 10");
                    }
                }
                catch (AppException ae){
                    System.out.println(ae.getMessage());
                    capacidad=0;
                }
                catch (NumberFormatException nfe){
                    System.out.println("Se ingresó valor de capacidad no numérico");
                    capacidad = 0;
                }
        }
        while (capacidad==0);

        int camasM = -1;
        do {
            System.out.println("Ingrese la cantidad camas matrimoniales de la  habitacion: ");

            try {
                camasM = Integer.parseInt(escaner.nextLine());
                if(camasM < 0){
                    throw new AppException("Cantidad de camas matrimoniales no puede ser menor a 0");
                }
                int limit = Math.floorDiv(capacidad, 2);
                if(camasM>limit){
                    throw new AppException("No puede haber mas de "+limit+" camas matrimoniales");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                camasM=-1;
            }
            catch (NumberFormatException nfe){
                System.out.println("Se ingresó valor de camas matrimoniales no numérico");
                camasM =-1;
            }
        }
        while (camasM == -1);

        int aireA = -1;
        do {
            System.out.println("La habitacion cuenta con aire acondicionado(responda 1 para 'si', 0 para 'no'): ");
            try {
                aireA = Integer.parseInt(escaner.nextLine());
                if(aireA<0 || aireA>1){
                    throw new AppException("Solo se permiten valores entre 1(SI) y 0(NO)");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                aireA = -1;
            }
            catch (NumberFormatException nfe){
                System.out.println("Se ingresó valor de Aire acondicionado no numérico");
                aireA = -1;
            }
        }
        while (aireA==-1);
        boolean aireAc = (aireA==1);

            int balcon = -1;
            do {
                System.out.println("La habitacion cuenta con balcon(responda 1 para 'si', 0 para 'no'): ");
                try {
                    balcon = Integer.parseInt(escaner.nextLine());
                    if(balcon<0 || balcon>1){
                        throw new AppException("Solo se permiten valores entre 1(SI) y 0(NO)");
                    }
                }
                catch (AppException ae){
                    System.out.println(ae.getMessage());
                    balcon = -1;
                }
                catch (NumberFormatException nfe){
                    System.out.println("Se ingresó valor de balcon no numérico");
                    balcon = -1;
                }
            }
            while (balcon==-1);
            boolean balconcito = (balcon==1);

            int vista = -1;
            do {
                System.out.println("La habitacion cuenta con vista(responda 1 para 'si', 0 para 'no'): ");
                try {
                    vista = Integer.parseInt(escaner.nextLine());
                    if(vista<0 || vista>1){
                        throw new AppException("Solo se permiten valores entre 1(SI) y 0(NO)");
                    }
                }
                catch (AppException ae){
                    System.out.println(ae.getMessage());
                    vista = -1;
                }
                catch (NumberFormatException nfe){
                    System.out.println("Se ingresó valor de Vista no numérico");
                    vista = -1;
                }
            }
            while (vista==-1);
            boolean vistas = (vista==1);

        String amenities = "";
        do{
            System.out.println("Ingrese amenities de la habitacion: ");
            amenities = escaner.nextLine();

            try {
                if (amenities.length() < 2) {
                    throw new AppException("El largo de los amenities debe ser mayor a 1 caracteres");
                }

                if (amenities.length() > 200) {
                    throw new AppException("El largo de los amenities debe ser menor a 201 caracteres");
                }
            }
            catch (AppException var4) {
                AppException e = var4;
                amenities = "";
                System.out.println(e.getMessage());
            }
        }
        while (amenities.isEmpty());

        String estado = "";
        do{
            System.out.println("Ingrese el estado de la habitacion('disponible', 'reservada', 'ocupada'): ");
            estado = escaner.nextLine().trim().toLowerCase();

            try {
                if (!estado.equals("disponible") && !estado.equals("reservada") && !estado.equals("ocupada")) {
                    throw new AppException("Estado no comprendido dentro de las posibilidades ('disponible', 'reservada', 'ocupada')");
                }
            }
            catch (AppException var4) {
                AppException e = var4;
                estado = "";
                System.out.println(e.getMessage());
            }
        }
        while (estado.isEmpty());

        Habitacion habitacion = new Habitacion(idHa, idHo, capacidad, camasM, aireAc, balconcito, vistas, amenities, estado);
        return PHabitacion.agregarHabitacion(habitacion);
    }
    public boolean modificarHabitacion(){
        int idHa = 0;
        int idHo = 0;
        do {
            System.out.println("Ingrese el ID de la habitacion: ");

            try {
                idHa = Integer.parseInt(escaner.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Se ingresó un id no numérico");
                idHa = 0;
            }

            if (idHa != 0) {
                do {
                    System.out.println("Ingrese el ID del Hotel: ");

                    try {
                        idHo = Integer.parseInt(escaner.nextLine());
                    } catch (NumberFormatException nfe) {
                        System.out.println("Se ingresó un id no numérico");
                        idHo = 0;
                    }
                }
                while (idHo == 0);
            }
            try {
                Habitacion ha = buscarHabitacion(idHa, idHo);
                if (!(ha.getIdHabitacion() == idHa && ha.getIdHotel() == idHo)) {
                    throw new AppException("Combinacion de id Habitacion e id Hotel no encotrada");
                }
            } catch (AppException ae) {
                System.out.println(ae.getMessage());
                idHa = 0;
                idHo = 0;
            }
        }
        while (idHa==0);

        int capacidad = 0;
        do {
            System.out.println("Ingrese la capacidad de la  habitacion: ");

            try {
                capacidad = Integer.parseInt(escaner.nextLine());

                if(capacidad<1){
                    throw new AppException("Capacidad no puede ser menor a 1");
                }
                if(capacidad>10){
                    throw new AppException("Capacidad no puede ser mayor a 10");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                capacidad=0;
            }
            catch (NumberFormatException nfe){
                System.out.println("Se ingresó valor de capacidad no numérico");
                capacidad = 0;
            }
        }
        while (capacidad==0);

        int camasM = -1;
        do {
            System.out.println("Ingrese la cantidad camas matrimoniales de la  habitacion: ");

            try {
                camasM = Integer.parseInt(escaner.nextLine());
                if(camasM < 0){
                    throw new AppException("Cantidad de camas matrimoniales no puede ser menor a 0");
                }
                int limit = Math.floorDiv(capacidad, 2);
                if(camasM>limit){
                    throw new AppException("No puede haber mas de "+limit+" camas matrimoniales");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                camasM=-1;
            }
            catch (NumberFormatException nfe){
                System.out.println("Se ingresó valor de camas matrimoniales no numérico");
                camasM =-1;
            }
        }
        while (camasM == -1);

        int aireA = -1;
        do {
            System.out.println("La habitacion cuenta con aire acondicionado(responda 1 para 'si', 0 para 'no'): ");
            try {
                aireA = Integer.parseInt(escaner.nextLine());
                if(aireA<0 || aireA>1){
                    throw new AppException("Solo se permiten valores entre 1(SI) y 0(NO)");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                aireA = -1;
            }
            catch (NumberFormatException nfe){
                System.out.println("Se ingresó valor de Aire acondicionado no numérico");
                aireA = -1;
            }
        }
        while (aireA==-1);
        boolean aireAc = (aireA==1);

        int balcon = -1;
        do {
            System.out.println("La habitacion cuenta con balcon(responda 1 para 'si', 0 para 'no'): ");
            try {
                balcon = Integer.parseInt(escaner.nextLine());
                if(balcon<0 || balcon>1){
                    throw new AppException("Solo se permiten valores entre 1(SI) y 0(NO)");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                balcon = -1;
            }
            catch (NumberFormatException nfe){
                System.out.println("Se ingresó valor de balcon no numérico");
                balcon = -1;
            }
        }
        while (balcon==-1);
        boolean balconcito = (balcon==1);

        int vista = -1;
        do {
            System.out.println("La habitacion cuenta con vista(responda 1 para 'si', 0 para 'no'): ");
            try {
                vista = Integer.parseInt(escaner.nextLine());
                if(vista<0 || vista>1){
                    throw new AppException("Solo se permiten valores entre 1(SI) y 0(NO)");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                vista = -1;
            }
            catch (NumberFormatException nfe){
                System.out.println("Se ingresó valor de Vista no numérico");
                vista = -1;
            }
        }
        while (vista==-1);
        boolean vistas = (vista==1);

        String amenities = "";
        do{
            System.out.println("Ingrese amenities de la habitacion: ");
            amenities = escaner.nextLine();

            try {
                if (amenities.length() < 2) {
                    throw new AppException("El largo de los amenities debe ser mayor a 1 caracteres");
                }

                if (amenities.length() > 200) {
                    throw new AppException("El largo de los amenities debe ser menor a 201 caracteres");
                }
            }
            catch (AppException var4) {
                AppException e = var4;
                amenities = "";
                System.out.println(e.getMessage());
            }
        }
        while (amenities.isEmpty());

        String estado = "";
        do{
            System.out.println("Ingrese el estado de la habitacion('disponible', 'reservada', 'ocupada'): ");
            estado = escaner.nextLine().trim().toLowerCase();

            try {
                if (!estado.equals("disponible") && !estado.equals("reservada") && !estado.equals("ocupada")) {
                    throw new AppException("Estado no comprendido dentro de las posibilidades ('disponible', 'reservada', 'ocupada')");
                }
            }
            catch (AppException var4) {
                AppException e = var4;
                estado = "";
                System.out.println(e.getMessage());
            }
        }
        while (estado.isEmpty());

        Habitacion habitacion = new Habitacion(idHa, idHo, capacidad, camasM, aireAc, balconcito, vistas, amenities, estado);
        return PHabitacion.modificarHabitacion(habitacion);
    }
    public boolean eliminarHabitacion(){
        int idHa = 0;
        int idHo = 0;
        do {
            System.out.println("Ingrese el ID de la habitacion: ");

            try {
                idHa = Integer.parseInt(escaner.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Se ingresó un id no numérico");
                idHa = 0;
            }

            if (idHa != 0) {
                do {
                    System.out.println("Ingrese el ID del Hotel: ");

                    try {
                        idHo = Integer.parseInt(escaner.nextLine());
                    } catch (NumberFormatException nfe) {
                        System.out.println("Se ingresó un id no numérico");
                        idHo = 0;
                    }
                }
                while (idHo == 0);
            }
            try {
                Habitacion ha = buscarHabitacion(idHa, idHo);
                if (!(ha.getIdHabitacion() == idHa && ha.getIdHotel() == idHo)) {
                    throw new AppException("Combinacion de id Habitacion e id Hotel no encotrada");
                }
            } catch (AppException ae) {
                System.out.println(ae.getMessage());
                idHa = 0;
                idHo = 0;
            }
        }
        while (idHa==0);

        return PHabitacion.eliminarHabitacion(idHa, idHo);
    }
    public Habitacion buscarHabitacion(int pIdHa, int pIdHo){
        return PHabitacion.buscarHabitacion(pIdHa, pIdHo);
    }
    public ArrayList<Habitacion> listarHabitaciones(){
        return PHabitacion.listarHabitaciones();
    }
    // </editor-fold>

    //<editor-fold desc="Huesped">
    public boolean agregarHuesped(){
        int idH = 0;
        do {
            System.out.println("Ingrese el ID del huesped: ");

            try {
                idH = Integer.parseInt(escaner.nextLine());
                Huesped huesped = buscarHuesped(idH);
                if(huesped != null){
                    throw new AppException("Id de huesped en uso");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                idH = 0;
            }
            catch (NumberFormatException nfe) {
                System.out.println("Se ingresó un id no numérico");
                idH = 0;
            }
        }
        while (idH==0);
        
        String nombre = "";
        do{
            System.out.println("Ingrese nombre del huesped: ");
            nombre = escaner.nextLine();

            try {
                if (nombre.length() < 2) {
                    throw new AppException("El largo del nombre debe ser mayor a 1 caracteres");
                }

                if (nombre.length() > 20) {
                    throw new AppException("El largo del nombre debe ser menor a 21 caracteres");
                }
            }
            catch (AppException var4) {
                AppException e = var4;
                nombre = "";
                System.out.println(e.getMessage());
            }
        }
        while (nombre.isEmpty());

        String aPaterno = "";
        do{
            System.out.println("Ingrese aPaterno del huesped: ");
            aPaterno = escaner.nextLine();

            try {
                if (aPaterno.length() < 2) {
                    throw new AppException("El largo del aPaterno debe ser mayor a 1 caracteres");
                }

                if (aPaterno.length() > 20) {
                    throw new AppException("El largo del aPaterno debe ser menor a 21 caracteres");
                }
            }
            catch (AppException var4) {
                AppException e = var4;
                aPaterno = "";
                System.out.println(e.getMessage());
            }
        }
        while (aPaterno.isEmpty());

        String aMaterno = "";
        do{
            System.out.println("Ingrese aMaterno del huesped: ");
            aMaterno = escaner.nextLine();

            try {
                if (aMaterno.length() < 2) {
                    throw new AppException("El largo del aMaterno debe ser mayor a 1 caracteres");
                }

                if (aMaterno.length() > 20) {
                    throw new AppException("El largo del aMaterno debe ser menor a 21 caracteres");
                }
            }
            catch (AppException var4) {
                AppException e = var4;
                aMaterno = "";
                System.out.println(e.getMessage());
            }
        }
        while (aMaterno.isEmpty());

        String TipoDocumento = "";
        do{
            System.out.println("Ingrese TipoDocumento del huesped: ");
            TipoDocumento = escaner.nextLine();

            try {
                if (TipoDocumento.length() < 2) {
                    throw new AppException("El largo del TipoDocumento debe ser mayor a 1 caracteres");
                }

                if (TipoDocumento.length() > 20) {
                    throw new AppException("El largo del TipoDocumento debe ser menor a 21 caracteres");
                }
            }
            catch (AppException var4) {
                AppException e = var4;
                TipoDocumento = "";
                System.out.println(e.getMessage());
            }
        }
        while (TipoDocumento.isEmpty());

        String NumDocumento = "";
        do{
            System.out.println("Ingrese NumDocumento del huesped: ");
            NumDocumento = escaner.nextLine();

            try {
                if (NumDocumento.length() < 2) {
                    throw new AppException("El largo del NumDocumento debe ser mayor a 1 caracteres");
                }

                if (NumDocumento.length() > 20) {
                    throw new AppException("El largo del NumDocumento debe ser menor a 21 caracteres");
                }
            }
            catch (AppException var4) {
                AppException e = var4;
                NumDocumento = "";
                System.out.println(e.getMessage());
            }
        }
        while (NumDocumento.isEmpty());

        LocalDate fechaNac = null;
        do {
            System.out.println("Ingrese la fecha de nacimiento (formato aaaa-MM-dd):");
            String fecha = escaner.nextLine();
            try {
                fechaNac = LocalDate.parse(fecha);
                LocalDate fechaLegal = fechaNac.plusYears(18);
                LocalDate hoy = LocalDate.now();
                if(fechaLegal.isAfter(hoy)){
                    throw new AppException("Debe ser mayor de 18 años para realizar una reserva.");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                fechaNac = null;
            }
            catch (DateTimeParseException dtpe){
                System.out.println("Fecha ingresada en formato incorrecto(Recuerde usar '-', ejemplo '2010-10-20')");
                fechaNac = null;
            }
        }
        while (fechaNac == null);

        String telefono = "";
        do{
            System.out.println("Ingrese telefono del huesped: ");
            telefono = escaner.nextLine();

            try {
                if (telefono.length() < 2) {
                    throw new AppException("El largo del telefono debe ser mayor a 1 caracteres");
                }

                if (telefono.length() > 20) {
                    throw new AppException("El largo del telefono debe ser menor a 21 caracteres");
                }
            }
            catch (AppException var4) {
                AppException e = var4;
                telefono = "";
                System.out.println(e.getMessage());
            }
        }
        while (telefono.isEmpty());

        String pais = "";
        do{
            System.out.println("Ingrese pais del huesped: ");
            pais = escaner.nextLine();

            try {
                if (pais.length() < 2) {
                    throw new AppException("El largo del pais debe ser mayor a 1 caracteres");
                }

                if (pais.length() > 20) {
                    throw new AppException("El largo del pais debe ser menor a 21 caracteres");
                }
            }
            catch (AppException var4) {
                AppException e = var4;
                pais = "";
                System.out.println(e.getMessage());
            }
        }
        while (pais.isEmpty());

        Huesped huesped = new Huesped(idH, nombre, aPaterno, aMaterno, TipoDocumento, NumDocumento, fechaNac, telefono, pais);
        return PHuesped.agregarHuesped(huesped);
    }
    public boolean modificarHuesped(){
        int idH = 0;
        do {
            System.out.println("Ingrese el ID del huesped: ");

            try {
                idH = Integer.parseInt(escaner.nextLine());
                Huesped huesped = buscarHuesped(idH);
                if(huesped == null){
                    throw new AppException("Id de huesped no encontrado");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                idH = 0;
            }
            catch (NumberFormatException nfe) {
                System.out.println("Se ingresó un id no numérico");
                idH = 0;
            }
        }
        while (idH==0);

        String nombre = "";
        do{
            System.out.println("Ingrese nombre del huesped: ");
            nombre = escaner.nextLine();

            try {
                if (nombre.length() < 2) {
                    throw new AppException("El largo del nombre debe ser mayor a 1 caracteres");
                }

                if (nombre.length() > 20) {
                    throw new AppException("El largo del nombre debe ser menor a 21 caracteres");
                }
            }
            catch (AppException var4) {
                AppException e = var4;
                nombre = "";
                System.out.println(e.getMessage());
            }
        }
        while (nombre.isEmpty());

        String aPaterno = "";
        do{
            System.out.println("Ingrese aPaterno del huesped: ");
            aPaterno = escaner.nextLine();

            try {
                if (aPaterno.length() < 2) {
                    throw new AppException("El largo del aPaterno debe ser mayor a 1 caracteres");
                }

                if (aPaterno.length() > 20) {
                    throw new AppException("El largo del aPaterno debe ser menor a 21 caracteres");
                }
            }
            catch (AppException var4) {
                AppException e = var4;
                aPaterno = "";
                System.out.println(e.getMessage());
            }
        }
        while (aPaterno.isEmpty());

        String aMaterno = "";
        do{
            System.out.println("Ingrese aMaterno del huesped: ");
            aMaterno = escaner.nextLine();

            try {
                if (aMaterno.length() < 2) {
                    throw new AppException("El largo del aMaterno debe ser mayor a 1 caracteres");
                }

                if (aMaterno.length() > 20) {
                    throw new AppException("El largo del aMaterno debe ser menor a 21 caracteres");
                }
            }
            catch (AppException var4) {
                AppException e = var4;
                aMaterno = "";
                System.out.println(e.getMessage());
            }
        }
        while (aMaterno.isEmpty());

        String TipoDocumento = "";
        do{
            System.out.println("Ingrese TipoDocumento del huesped: ");
            TipoDocumento = escaner.nextLine();

            try {
                if (TipoDocumento.length() < 2) {
                    throw new AppException("El largo del TipoDocumento debe ser mayor a 1 caracteres");
                }

                if (TipoDocumento.length() > 20) {
                    throw new AppException("El largo del TipoDocumento debe ser menor a 21 caracteres");
                }
            }
            catch (AppException var4) {
                AppException e = var4;
                TipoDocumento = "";
                System.out.println(e.getMessage());
            }
        }
        while (TipoDocumento.isEmpty());

        String NumDocumento = "";
        do{
            System.out.println("Ingrese NumDocumento del huesped: ");
            NumDocumento = escaner.nextLine();

            try {
                if (NumDocumento.length() < 2) {
                    throw new AppException("El largo del NumDocumento debe ser mayor a 1 caracteres");
                }

                if (NumDocumento.length() > 20) {
                    throw new AppException("El largo del NumDocumento debe ser menor a 21 caracteres");
                }
            }
            catch (AppException var4) {
                AppException e = var4;
                NumDocumento = "";
                System.out.println(e.getMessage());
            }
        }
        while (NumDocumento.isEmpty());

        LocalDate fechaNac = null;
        do {
            System.out.println("Ingrese la fecha de nacimiento (formato aaaa-MM-dd):");
            String fecha = escaner.nextLine();
            try {
                fechaNac = LocalDate.parse(fecha);
                LocalDate fechaLegal = fechaNac.plusYears(18);
                LocalDate hoy = LocalDate.now();
                if(fechaLegal.isAfter(hoy)){
                    throw new AppException("Debe ser mayor de 18 años para realizar una reserva.");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                fechaNac = null;
            }
            catch (DateTimeParseException dtpe){
                System.out.println("Fecha ingresada en formato incorrecto(Recuerde usar '-', ejemplo '2010-10-20')");
                fechaNac = null;
            }
        }
        while (fechaNac == null);

        String telefono = "";
        do{
            System.out.println("Ingrese telefono del huesped: ");
            telefono = escaner.nextLine();

            try {
                if (telefono.length() < 2) {
                    throw new AppException("El largo del telefono debe ser mayor a 1 caracteres");
                }

                if (telefono.length() > 20) {
                    throw new AppException("El largo del telefono debe ser menor a 21 caracteres");
                }
            }
            catch (AppException var4) {
                AppException e = var4;
                telefono = "";
                System.out.println(e.getMessage());
            }
        }
        while (telefono.isEmpty());

        String pais = "";
        do{
            System.out.println("Ingrese pais del huesped: ");
            pais = escaner.nextLine();

            try {
                if (pais.length() < 2) {
                    throw new AppException("El largo del pais debe ser mayor a 1 caracteres");
                }

                if (pais.length() > 20) {
                    throw new AppException("El largo del pais debe ser menor a 21 caracteres");
                }
            }
            catch (AppException var4) {
                AppException e = var4;
                pais = "";
                System.out.println(e.getMessage());
            }
        }
        while (pais.isEmpty());

        Huesped huesped = new Huesped(idH, nombre, aPaterno, aMaterno, TipoDocumento, NumDocumento, fechaNac, telefono, pais);
        return PHuesped.modificarHuesped(huesped);
    }
    public boolean eliminarHuesped(){
        int idH = 0;
        do {
            System.out.println("Ingrese el ID del huesped: ");

            try {
                idH = Integer.parseInt(escaner.nextLine());
                Huesped huesped = buscarHuesped(idH);
                if(huesped == null){
                    throw new AppException("Id de huesped no encontrado");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                idH = 0;
            }
            catch (NumberFormatException nfe) {
                System.out.println("Se ingresó un id no numérico");
                idH = 0;
            }
        }
        while (idH==0);

        return PHuesped.eliminarHuesped(idH);
    }
    public Huesped buscarHuesped(int pIdH){
        return PHuesped.buscarHuesped(pIdH);
    }
    public ArrayList<Huesped> listarHuespedes(){
        return PHuesped.listarHuespedes();
    }
    // </editor-fold>

    //<editor-fold desc="Reserva">
    public boolean agregarReserva(){
        int idHa = 0;
        int idHo = 0;
        do {
            System.out.println("Ingrese el ID del Hotel: ");

            try {
                idHo = Integer.parseInt(escaner.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Se ingresó un id no numérico");
                idHo = 0;
            }

            if (idHo != 0) {
                do {
                    System.out.println("Ingrese el ID de la habitacion: ");

                    try {
                        idHa = Integer.parseInt(escaner.nextLine());
                    } catch (NumberFormatException nfe) {
                        System.out.println("Se ingresó un id no numérico");
                        idHa = 0;
                    }
                }
                while (idHa == 0);
            }
            try {
                Habitacion ha = buscarHabitacion(idHa, idHo);
                if (!(ha.getIdHabitacion() == idHa && ha.getIdHotel() == idHo)) {
                    throw new AppException("Combinacion de id Habitacion e id Hotel no encotrada");
                }
            } catch (AppException ae) {
                System.out.println(ae.getMessage());
                idHa = 0;
                idHo = 0;
            }
        }
        while (idHo==0);
        Habitacion habitacion = buscarHabitacion(idHa, idHo);

        int idH = 0;
        do {
            System.out.println("Ingrese el ID del huesped: ");

            try {
                idH = Integer.parseInt(escaner.nextLine());
                Huesped huesped = buscarHuesped(idH);
                if(huesped == null){
                    throw new AppException("Id de huesped no encontrado");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                idH = 0;
            }
            catch (NumberFormatException nfe) {
                System.out.println("Se ingresó un id no numérico");
                idH = 0;
            }
        }
        while (idH==0);

        int cantP = 0;
        do {
            System.out.println("Ingrese cantidad de personas: ");

            try {
                cantP = Integer.parseInt(escaner.nextLine());
                if(cantP > habitacion.getCapacidadCamas()){
                    throw new AppException("La cantidad de personas exceden la capacidad de la habitacion");
                }
                if(cantP<1){
                    throw new AppException("Debe haber al menos una persona como huesped");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                cantP = 0;
            }
            catch (NumberFormatException nfe) {
                System.out.println("Se ingresó valor no numérico");
                cantP = 0;
            }
        }
        while (cantP==0);

        String tipo = "";
        do{
            System.out.println("Ingrese tipo de la reserva: ");
            tipo = escaner.nextLine();

            try {
                if (tipo.length() < 2) {
                    throw new AppException("El largo del tipo debe ser mayor a 1 caracteres");
                }

                if (tipo.length() > 30) {
                    throw new AppException("El largo del tipo debe ser menor a 31 caracteres");
                }
            }
            catch (AppException var4) {
                AppException e = var4;
                tipo = "";
                System.out.println(e.getMessage());
            }
        }
        while (tipo.isEmpty());

        LocalDate fechaRes = null;
        do {
            System.out.println("Ingrese la fecha de Reserva (formato aaaa-MM-dd):");
            String fecha = escaner.nextLine();
            try {
                fechaRes = LocalDate.parse(fecha);
                LocalDate hoy = LocalDate.now();
                if(fechaRes.isAfter(hoy)){
                    throw new AppException("La fecha de reserva debe ser menor o igual a la actual.");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                fechaRes = null;
            }
            catch (DateTimeParseException dtpe){
                System.out.println("Fecha ingresada en formato incorrecto(Recuerde usar '-', ejemplo '2010-10-20')");
                fechaRes = null;
            }
        }
        while (fechaRes == null);

        LocalDate fechaInicio = null;
        do {
            System.out.println("Ingrese la fecha de Inicio de estadía (formato aaaa-MM-dd):");
            String fecha = escaner.nextLine();
            try {
                fechaInicio = LocalDate.parse(fecha);
                if(fechaRes.isAfter(fechaInicio)){
                    throw new AppException("La fecha de inicio de estadía no puede ser menor a la de reserva.");
                }
                ArrayList<Reserva> reservas = listarReservas();
                ArrayList<Reserva> reservasH = new ArrayList<>();
                for(Reserva r : reservas){
                    if(r.getIdHabitacion() == habitacion.getIdHabitacion() && r.getIdHotel() == habitacion.getIdHotel()){
                        reservasH.add(r);
                    }
                }
                if(!(reservasH.isEmpty())){
                    for(Reserva r : reservasH){
                        if (fechaInicio.isAfter(r.getFechaInicio().minusDays(1)) && fechaInicio.isBefore(r.getFechaFin().plusDays(1))){
                            throw new AppException("Fecha de inicio se superpone a otra reserva");
                        }
                    }
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                fechaInicio = null;
            }
            catch (DateTimeParseException dtpe){
                System.out.println("Fecha ingresada en formato incorrecto(Recuerde usar '-', ejemplo '2010-10-20')");
                fechaInicio = null;
            }
        }
        while (fechaInicio == null);

        LocalDate fechaFin = null;
        do {
            System.out.println("Ingrese la fecha de fin de estadía (formato aaaa-MM-dd):");
            String fecha = escaner.nextLine();
            try {
                fechaFin = LocalDate.parse(fecha);
                if(fechaInicio.isAfter(fechaFin)){
                    throw new AppException("La fecha de salida no puede ser menor a la de inicio de estadía.");
                }
                ArrayList<Reserva> reservas = listarReservas();
                ArrayList<Reserva> reservasH = new ArrayList<>();
                for(Reserva r : reservas){
                    if(r.getIdHabitacion() == habitacion.getIdHabitacion() && r.getIdHotel() == habitacion.getIdHotel()){
                        reservasH.add(r);
                    }
                }
                if(!(reservasH.isEmpty())){
                    for(Reserva r : reservasH){
                        if ((fechaFin.isAfter(r.getFechaInicio()) && fechaFin.isBefore(r.getFechaFin().plusDays(1))) || (fechaInicio.isBefore(r.getFechaInicio().plusDays(1)) && fechaFin.isAfter(r.getFechaFin().minusDays(1)))){
                            throw new AppException("Fecha de fin se superpone a otra reserva");
                        }
                    }
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                fechaFin = null;
            }
            catch (DateTimeParseException dtpe){
                System.out.println("Fecha ingresada en formato incorrecto(Recuerde usar '-', ejemplo '2010-10-20')");
                fechaFin = null;
            }
        }
        while (fechaFin == null);
        
        String observacion = "";
        do{
            System.out.println("Ingrese observacion de la reserva: ");
            observacion = escaner.nextLine();

            try {
                if (observacion.length() < 2) {
                    throw new AppException("El largo del observacion debe ser mayor a 1 caracteres");
                }

                if (observacion.length() > 30) {
                    throw new AppException("El largo del observacion debe ser menor a 31 caracteres");
                }
            }
            catch (AppException var4) {
                AppException e = var4;
                observacion = "";
                System.out.println(e.getMessage());
            }
        }
        while (observacion.isEmpty());

        int estado_pago = -1;
        do {
            System.out.println("¿Tarifa congelada por pago?(responda 1 para 'si', 0 para 'no'): ");
            try {
                estado_pago = Integer.parseInt(escaner.nextLine());
                if(estado_pago<0 || estado_pago>1){
                    throw new AppException("Solo se permiten valores entre 1(SI) y 0(NO)");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                estado_pago = -1;
            }
            catch (NumberFormatException nfe){
                System.out.println("Se ingresó valor no numérico(responda 1 para 'si', 0 para 'no')");
                estado_pago = -1;
            }
        }
        while (estado_pago==-1);
        boolean estado_Pago = (estado_pago==1);

        int pagoCompleto = -1;
        if(estado_Pago) {
            do {
                System.out.println("La reserva fue paga en su totalidad(responda 1 para 'si', 0 para 'no'): ");
                try {
                    pagoCompleto = Integer.parseInt(escaner.nextLine());
                    if (pagoCompleto < 0 || pagoCompleto > 1) {
                        throw new AppException("Solo se permiten valores entre 1(SI) y 0(NO)");
                    }
                } catch (AppException ae) {
                    System.out.println(ae.getMessage());
                    pagoCompleto = -1;
                } catch (NumberFormatException nfe) {
                    System.out.println("Se ingresó valor no numérico(responda 1 para 'si', 0 para 'no')");
                    pagoCompleto = -1;
                }
            }
            while (pagoCompleto == -1);
        }
        boolean pagoCompletito = (pagoCompleto==1);

        Reserva reserva = new Reserva(idHo, idHa, idH, cantP, tipo, fechaRes, fechaInicio, fechaFin, observacion, estado_Pago, pagoCompletito);
        return PReserva.agregarReserva(reserva);
    }
    public boolean modificarReserva(){
        int idR = 0;
        do{
            System.out.println("Ingrese el ID de reserva: ");
            try {
                idR = Integer.parseInt(escaner.nextLine());
                Reserva reserva = buscarReserva(idR);
                if(reserva == null){
                    throw new AppException("Reserva con ese ID no encontrado");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                idR = 0;
            }
        }
        while (idR == 0);

        int idHa = 0;
        int idHo = 0;
        do {
            System.out.println("Ingrese el ID del Hotel: ");

            try {
                idHo = Integer.parseInt(escaner.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Se ingresó un id no numérico");
                idHo = 0;
            }

            if (idHo != 0) {
                do {
                    System.out.println("Ingrese el ID de la habitacion: ");

                    try {
                        idHa = Integer.parseInt(escaner.nextLine());
                    } catch (NumberFormatException nfe) {
                        System.out.println("Se ingresó un id no numérico");
                        idHa = 0;
                    }
                }
                while (idHa == 0);
            }
            try {
                Habitacion ha = buscarHabitacion(idHa, idHo);
                if (!(ha.getIdHabitacion() == idHa && ha.getIdHotel() == idHo)) {
                    throw new AppException("Combinacion de id Habitacion e id Hotel no encotrada");
                }
            } catch (AppException ae) {
                System.out.println(ae.getMessage());
                idHa = 0;
                idHo = 0;
            }
        }
        while (idHo==0);
        Habitacion habitacion = buscarHabitacion(idHa, idHo);

        int idH = 0;
        do {
            System.out.println("Ingrese el ID del huesped: ");

            try {
                idH = Integer.parseInt(escaner.nextLine());
                Huesped huesped = buscarHuesped(idH);
                if(huesped == null){
                    throw new AppException("Id de huesped no encontrado");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                idH = 0;
            }
            catch (NumberFormatException nfe) {
                System.out.println("Se ingresó un id no numérico");
                idH = 0;
            }
        }
        while (idH==0);

        int cantP = 0;
        do {
            System.out.println("Ingrese cantidad de personas: ");

            try {
                cantP = Integer.parseInt(escaner.nextLine());
                if(cantP > habitacion.getCapacidadCamas()){
                    throw new AppException("La cantidad de personas exceden la capacidad de la habitacion");
                }
                if(cantP<1){
                    throw new AppException("Debe haber al menos una persona como huesped");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                cantP = 0;
            }
            catch (NumberFormatException nfe) {
                System.out.println("Se ingresó valor no numérico");
                cantP = 0;
            }
        }
        while (cantP==0);

        String tipo = "";
        do{
            System.out.println("Ingrese tipo de la reserva: ");
            tipo = escaner.nextLine();

            try {
                if (tipo.length() < 2) {
                    throw new AppException("El largo del tipo debe ser mayor a 1 caracteres");
                }

                if (tipo.length() > 30) {
                    throw new AppException("El largo del tipo debe ser menor a 31 caracteres");
                }
            }
            catch (AppException var4) {
                AppException e = var4;
                tipo = "";
                System.out.println(e.getMessage());
            }
        }
        while (tipo.isEmpty());

        LocalDate fechaRes = null;
        do {
            System.out.println("Ingrese la fecha de Reserva (formato aaaa-MM-dd):");
            String fecha = escaner.nextLine();
            try {
                fechaRes = LocalDate.parse(fecha);
                LocalDate hoy = LocalDate.now();
                if(fechaRes.isAfter(hoy)){
                    throw new AppException("La fecha de reserva debe ser menor o igual a la actual.");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                fechaRes = null;
            }
            catch (DateTimeParseException dtpe){
                System.out.println("Fecha ingresada en formato incorrecto(Recuerde usar '-', ejemplo '2010-10-20')");
                fechaRes = null;
            }
        }
        while (fechaRes == null);

        LocalDate fechaInicio = null;
        do {
            System.out.println("Ingrese la fecha de Inicio de estadía (formato aaaa-MM-dd):");
            String fecha = escaner.nextLine();
            try {
                fechaInicio = LocalDate.parse(fecha);
                if(fechaRes.isAfter(fechaInicio)){
                    throw new AppException("La fecha de inicio de estadía no puede ser menor a la de reserva.");
                }
                ArrayList<Reserva> reservas = listarReservas();
                ArrayList<Reserva> reservasH = new ArrayList<>();
                for(Reserva r : reservas){
                    if(r.getIdHabitacion() == habitacion.getIdHabitacion() && r.getIdHotel() == habitacion.getIdHotel()){
                        reservasH.add(r);
                    }
                }
                if(!(reservasH.isEmpty())){
                    for(Reserva r : reservasH){
                        if (fechaInicio.isAfter(r.getFechaInicio().minusDays(1)) && fechaInicio.isBefore(r.getFechaFin().plusDays(1))){
                            throw new AppException("Fecha de inicio se superpone a otra reserva");
                        }
                    }
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                fechaInicio = null;
            }
            catch (DateTimeParseException dtpe){
                System.out.println("Fecha ingresada en formato incorrecto(Recuerde usar '-', ejemplo '2010-10-20')");
                fechaInicio = null;
            }
        }
        while (fechaInicio == null);

        LocalDate fechaFin = null;
        do {
            System.out.println("Ingrese la fecha de fin de estadia (formato aaaa-MM-dd):");
            String fecha = escaner.nextLine();
            try {
                fechaFin = LocalDate.parse(fecha);
                if(fechaInicio.isAfter(fechaFin)){
                    throw new AppException("La fecha de salida no puede ser menor a la de inicio de estadía.");
                }
                ArrayList<Reserva> reservas = listarReservas();
                ArrayList<Reserva> reservasH = new ArrayList<>();
                for(Reserva r : reservas){
                    if(r.getIdHabitacion() == habitacion.getIdHabitacion() && r.getIdHotel() == habitacion.getIdHotel()){
                        reservasH.add(r);
                    }
                }
                if(!(reservasH.isEmpty())){
                    for(Reserva r : reservasH){
                        if ((fechaFin.isAfter(r.getFechaInicio().minusDays(1)) && fechaFin.isBefore(r.getFechaFin().plusDays(1))) || (fechaInicio.isBefore(r.getFechaInicio().plusDays(1)) && fechaFin.isAfter(r.getFechaFin().minusDays(1)))){
                            throw new AppException("Fecha de fin se superpone a otra reserva");
                        }
                    }
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                fechaFin = null;
            }
            catch (DateTimeParseException dtpe){
                System.out.println("Fecha ingresada en formato incorrecto(Recuerde usar '-', ejemplo '2010-10-20')");
                fechaFin = null;
            }
        }
        while (fechaFin == null);

        String observacion = "";
        do{
            System.out.println("Ingrese observacion de la reserva: ");
            observacion = escaner.nextLine();

            try {
                if (observacion.length() < 2) {
                    throw new AppException("El largo del observacion debe ser mayor a 1 caracteres");
                }

                if (observacion.length() > 50) {
                    throw new AppException("El largo del observacion debe ser menor a 51 caracteres");
                }
            }
            catch (AppException var4) {
                AppException e = var4;
                observacion = "";
                System.out.println(e.getMessage());
            }
        }
        while (observacion.isEmpty());

        int estado_pago = -1;
        do {
            System.out.println("¿Tarifa congelada por pago?(responda 1 para 'si', 0 para 'no'): ");
            try {
                estado_pago = Integer.parseInt(escaner.nextLine());
                if(estado_pago<0 || estado_pago>1){
                    throw new AppException("Solo se permiten valores entre 1(SI) y 0(NO)");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                estado_pago = -1;
            }
            catch (NumberFormatException nfe){
                System.out.println("Se ingresó valor no numérico(responda 1 para 'si', 0 para 'no')");
                estado_pago = -1;
            }
        }
        while (estado_pago==-1);
        boolean estado_Pago = (estado_pago==1);

        int pagoCompleto = -1;
        if(estado_Pago) {
            do {
                System.out.println("La reserva fue paga en su totalidad(responda 1 para 'si', 0 para 'no'): ");
                try {
                    pagoCompleto = Integer.parseInt(escaner.nextLine());
                    if (pagoCompleto < 0 || pagoCompleto > 1) {
                        throw new AppException("Solo se permiten valores entre 1(SI) y 0(NO)");
                    }
                } catch (AppException ae) {
                    System.out.println(ae.getMessage());
                    pagoCompleto = -1;
                } catch (NumberFormatException nfe) {
                    System.out.println("Se ingresó valor no numérico(responda 1 para 'si', 0 para 'no')");
                    pagoCompleto = -1;
                }
            }
            while (pagoCompleto == -1);
        }
        boolean pagoCompletito = (pagoCompleto==1);

        Reserva reserva = new Reserva(idR, idHo, idHa, idH, cantP, tipo, fechaRes, fechaInicio, fechaFin, observacion, estado_Pago, pagoCompletito);
        return PReserva.modificarReserva(reserva);
    }
    public void eliminarReserva(){
        int idR = 0;
        do{
            System.out.println("Ingrese el ID de reserva: ");
            try {
                idR = Integer.parseInt(escaner.nextLine());
                Reserva reserva = buscarReserva(idR);
                if(reserva == null){
                    throw new AppException("Reserva con ese ID no encontrado");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                idR = 0;
            }
        }
        while (idR == 0);
        PReserva.eliminarReserva(idR);
    }
    public Reserva buscarReserva(int pIdR){
        return PReserva.buscarReserva(pIdR);
    }
    public ArrayList<Reserva> listarReservas(){
        return PReserva.listarReservas();
    }
    public ArrayList<Reserva> listarReservasHabitacion(int pidHa, int pidHo){
        return PReserva.listarReservasHabitacion(pidHa, pidHo);
    }
    // </editor-fold>

    //<editor-fold desc="Tarifa">
    public boolean agregarTarifa(){
        int idT = 0;
        int idHo = 0;
        do {
            System.out.println("Ingrese el ID del Hotel: ");

            try {
                idHo = Integer.parseInt(escaner.nextLine());
                Hotel hotel = buscarHotel(idHo);
                if(hotel == null){
                    throw new AppException("No se encontro un hotel con ese id");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                idHo = 0;
            }
            catch (NumberFormatException nfe) {
                System.out.println("Se ingresó un id no numérico");
                idHo = 0;
            }

            if (idHo != 0) {
                do {
                    System.out.println("Ingrese el ID de la tarifa: ");

                    try {
                        idT = Integer.parseInt(escaner.nextLine());
                    } catch (NumberFormatException nfe) {
                        System.out.println("Se ingresó un id no numérico");
                        idT = 0;
                    }
                }
                while (idT == 0);
            }
            try {
                Tarifa ta = buscarTarifa(idT, idHo);
                if (ta != null) {
                    throw new AppException("Combinacion de id tarifa e id Hotel en uso");
                }
            } catch (AppException ae) {
                System.out.println(ae.getMessage());
                idT = 0;
                idHo = 0;
            }
        }
        while (idHo==0);

        LocalDate fechaVigencia = null;
        do {
            System.out.println("Ingrese la fecha de vigencia de tarifa (formato aaaa-MM-dd):");
            String fecha = escaner.nextLine();
            try {
                fechaVigencia = LocalDate.parse(fecha);
                LocalDate hoy = LocalDate.now();
                if(fechaVigencia.isAfter(hoy)){
                    throw new AppException("La fecha de vigencia no puede ser mayor a la fecha actual.");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                fechaVigencia = null;
            }
            catch (DateTimeParseException dtpe){
                System.out.println("Fecha ingresada en formato incorrecto(Recuerde usar '-', ejemplo '2010-10-20')");
                fechaVigencia = null;
            }
        }
        while (fechaVigencia == null);

        Double monto = 0.0;
        do {
            System.out.println("Ingrese el monto de la tarifa: ");

            try {
                monto = Double.parseDouble(escaner.nextLine());
                if(monto < 0.0){
                    throw new AppException("El monto no puede ser menor a 0");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                monto = 0.0;
            }
            catch (NumberFormatException nfe) {
                System.out.println("Se ingresó un monto no numérico");
                monto = 0.0;
            }
        }
        while (monto==0.0);

        Tarifa tarifa = new Tarifa(idT, idHo, fechaVigencia, monto);
        return PTarifa.agregarTarifa(tarifa);
    }
    public boolean modificarTarifa(){
        int idT = 0;
        int idHo = 0;
        do {
            System.out.println("Ingrese el ID del Hotel: ");

            try {
                idHo = Integer.parseInt(escaner.nextLine());
                Hotel hotel = buscarHotel(idHo);
                if(hotel == null){
                    throw new AppException("No se encontro un hotel con ese id");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                idHo = 0;
            }
            catch (NumberFormatException nfe) {
                System.out.println("Se ingresó un id no numérico");
                idHo = 0;
            }

            if (idHo != 0) {
                do {
                    System.out.println("Ingrese el ID de la tarifa: ");

                    try {
                        idT = Integer.parseInt(escaner.nextLine());
                    } catch (NumberFormatException nfe) {
                        System.out.println("Se ingresó un id no numérico");
                        idT = 0;
                    }
                }
                while (idT == 0);
            }
            try {
                Tarifa ta = buscarTarifa(idT, idHo);
                if (ta == null) {
                    throw new AppException("Combinacion de id tarifa e id Hotel no encotrada");
                }
            } catch (AppException ae) {
                System.out.println(ae.getMessage());
                idT = 0;
                idHo = 0;
            }
        }
        while (idHo==0);

        LocalDate fechaVigencia = null;
        do {
            System.out.println("Ingrese la fecha de vigencia de tarifa (formato aaaa-MM-dd):");
            String fecha = escaner.nextLine();
            try {
                fechaVigencia = LocalDate.parse(fecha);
                LocalDate hoy = LocalDate.now();
                if(fechaVigencia.isAfter(hoy)){
                    throw new AppException("La fecha de vigencia no puede ser mayor a la fecha actual.");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                fechaVigencia = null;
            }
            catch (DateTimeParseException dtpe){
                System.out.println("Fecha ingresada en formato incorrecto(Recuerde usar '-', ejemplo '2010-10-20')");
                fechaVigencia = null;
            }
        }
        while (fechaVigencia == null);

        Double monto = 0.0;
        do {
            System.out.println("Ingrese el monto de la tarifa: ");

            try {
                monto = Double.parseDouble(escaner.nextLine());
                if(monto < 0.0){
                    throw new AppException("El monto no puede ser menor a 0");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                monto = 0.0;
            }
            catch (NumberFormatException nfe) {
                System.out.println("Se ingresó un monto no numérico");
                monto = 0.0;
            }
        }
        while (monto==0.0);

        Tarifa tarifa = new Tarifa(idT, idHo, fechaVigencia, monto);
        return PTarifa.modificarTarifa(tarifa);
    }
    public boolean eliminarTarifa(){
        int idT = 0;
        int idHo = 0;
        do {
            System.out.println("Ingrese el ID del Hotel: ");

            try {
                idHo = Integer.parseInt(escaner.nextLine());
                Hotel hotel = buscarHotel(idHo);
                if(hotel == null){
                    throw new AppException("No se encontro un hotel con ese id");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                idHo = 0;
            }
            catch (NumberFormatException nfe) {
                System.out.println("Se ingresó un id no numérico");
                idHo = 0;
            }

            if (idHo != 0) {
                do {
                    System.out.println("Ingrese el ID de la tarifa: ");

                    try {
                        idT = Integer.parseInt(escaner.nextLine());
                    } catch (NumberFormatException nfe) {
                        System.out.println("Se ingresó un id no numérico");
                        idT = 0;
                    }
                }
                while (idT == 0);
            }
            try {
                Tarifa ta = buscarTarifa(idT, idHo);
                if (!(ta.getIdTarifa() == idT && ta.getIdHotel() == idHo)) {
                    throw new AppException("Combinacion de id tarifa e id Hotel no encotrada");
                }
            } catch (AppException ae) {
                System.out.println(ae.getMessage());
                idT = 0;
                idHo = 0;
            }
        }
        while (idHo==0);
        return PTarifa.eliminarTarifa(idT, idHo);
    }
    public Tarifa buscarTarifa(int idT, int idHo){
        Tarifa tarifa = PTarifa.buscarTarifa(idT, idHo);
        return tarifa;
    }
    public ArrayList<Tarifa> listarTarifas(){
        return PTarifa.listarTarifas();
    }
    // </editor-fold>

    //<editor-fold desc="Consultas">
        public boolean hotelXciudad(){
            String ciudad = "";
            do{
                System.out.println("Ingrese ciudad del Hotel: ");
                ciudad = escaner.nextLine();

                try {
                    if (ciudad.length() < 3) {
                        throw new AppException("El largo de la ciudad debe ser mayor a 2 caracteres");
                    }

                    if (ciudad.length() > 20) {
                        throw new AppException("El largo de la ciudad debe ser menor a 21 caracteres");
                    }
                } catch (AppException var4) {
                    AppException e = var4;
                    ciudad = "";
                    System.out.println(e.getMessage());
                }
            }
            while (ciudad.isEmpty());
            try{
                ArrayList<Hotel> hoteles = PHotel.listarHoteles();
                ArrayList<Hotel> hotelesC = new ArrayList<>();
                for(Hotel h : hoteles){
                    if(h.getCiudad().equals(ciudad)){
                        hotelesC.add(h);
                    }
                }
                if (hotelesC.isEmpty()){
                    throw new AppException("No se encontraron coincidencias");
                }
                for (Hotel hC : hotelesC){
                    System.out.println(hC.toString());
                }
                return true;
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                return true;
            }
        }

        public boolean hotelXnombre(){
            String nombre = "";
            do{
                System.out.println("Ingrese nombre del Hotel: ");
                nombre = escaner.nextLine();

                try {
                    if (nombre.length() < 3) {
                        throw new AppException("El largo del nombre debe ser mayor a 2 caracteres");
                    }

                    if (nombre.length() > 20) {
                        throw new AppException("El largo del nombre debe ser menor a 21 caracteres");
                    }
                } catch (AppException var4) {
                    AppException e = var4;
                    nombre = "";
                    System.out.println(e.getMessage());
                }
            }
            while (nombre.isEmpty());
            try{
                ArrayList<Hotel> hoteles = PHotel.listarHoteles();
                ArrayList<Hotel> hotelesN = new ArrayList<>();
                for(Hotel h : hoteles){
                    if(h.getNombre().equals(nombre)){
                        hotelesN.add(h);
                    }
                }
                if (hotelesN.isEmpty()){
                    throw new AppException("No se encontraron coincidencias");
                }
                for (Hotel hC : hotelesN){
                    System.out.println(hC.toString());
                }
                return true;
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                return true;
            }
        }

        public boolean hotelXestrellas(){
        int estrellas = 0;
        do {
            System.out.println("Ingrese las estrellas del hotel: ");

            try {
                estrellas = Integer.parseInt(escaner.nextLine());

                if(estrellas<0){
                    throw new AppException("Estrellas no puede ser menor a 0");
                }
                if(estrellas>5){
                    throw new AppException("Estrellas no puede ser mayor a 5");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
                estrellas=0;
            }
            catch (NumberFormatException nfe){
                System.out.println("Se ingresó valor de estrellas no numérico");
                estrellas = 0;
            }
        }
        while (estrellas==0);
        try{
            ArrayList<Hotel> hoteles = PHotel.listarHoteles();
            ArrayList<Hotel> hotelesE = new ArrayList<>();
            for(Hotel h : hoteles){
                if(h.getEstrellas() == estrellas){
                    hotelesE.add(h);
                }
            }
            if (hotelesE.isEmpty()){
                throw new AppException("No se encontraron coincidencias");
            }
            for (Hotel hC : hotelesE){
                System.out.println(hC.toString());
            }
            return true;
        }
        catch (AppException ae){
            System.out.println(ae.getMessage());
            return true;
        }
        }

        public boolean habitacionesEnUnPeriodo() {
            LocalDate fechaInicio = null;
            do {
                System.out.println("Ingrese la fecha de inicio (formato aaaa-MM-dd):");
                String fecha = escaner.nextLine();
                try {
                    fechaInicio = LocalDate.parse(fecha);
                    LocalDate hoy = LocalDate.now();
                    if (fechaInicio.isAfter(hoy)) {
                        throw new AppException("La fecha debe ser menor o igual a la actual.");
                    }
                } catch (AppException ae) {
                    System.out.println(ae.getMessage());
                    fechaInicio = null;
                } catch (DateTimeParseException dtpe) {
                    System.out.println("Fecha ingresada en formato incorrecto(Recuerde usar '-', ejemplo '2010-10-20')");
                    fechaInicio = null;
                }
            }
            while (fechaInicio == null);

            LocalDate fechaFin = null;
            do {
                System.out.println("Ingrese la fecha de fin (formato aaaa-MM-dd):");
                String fecha = escaner.nextLine();
                try {
                    fechaFin = LocalDate.parse(fecha);
                    LocalDate hoy = LocalDate.now();
                    if (fechaFin.isAfter(hoy)) {
                        throw new AppException("La fecha debe ser menor o igual a la actual.");
                    }
                    if(fechaFin.isBefore(fechaInicio)){
                        throw new AppException("La fecha fin debe ser igual o posterior a la fecha de inicio("+fechaInicio);
                    }
                } catch (AppException ae) {
                    System.out.println(ae.getMessage());
                    fechaFin = null;
                } catch (DateTimeParseException dtpe) {
                    System.out.println("Fecha ingresada en formato incorrecto(Recuerde usar '-', ejemplo '2010-10-20')");
                    fechaFin = null;
                }
            }
            while (fechaFin == null);

            ArrayList<Reserva> reservas = listarReservas();
            for(Reserva r : reservas){
                if((r.getFechaRes().isAfter(fechaInicio.minusDays(1)) && r.getFechaRes().isBefore(fechaFin.plusDays(1))) || (r.getFechaFin().isBefore(fechaFin.plusDays(1)) && r.getFechaFin().isAfter(fechaInicio.minusDays(1))) || (r.getFechaRes().isBefore(fechaInicio.plusDays(1)) && r.getFechaFin().isAfter(fechaFin.minusDays(1)))){
                    System.out.println(r.toString());
                }
            }
            return true;
        }

        public boolean habitacionesDesocupadas() {
            actualizarEstados();

            ArrayList<Habitacion> habitaciones = listarHabitaciones();
            ArrayList<Habitacion> habitacionesR = new ArrayList<>();
            ArrayList<Habitacion> habitacionS = new ArrayList<>();

            for (Habitacion h : habitaciones) {
                if (h.getEstado().equals("disponible")) {
                    habitacionS.add(h);
                } else {
                    habitacionesR.add(h);
                }
            }
            if (!habitacionesR.isEmpty()) {
                System.out.println("Habitaciones Reservadas: ");
                for (Habitacion h : habitacionesR) {
                    System.out.println(h.toString());
                }
            }
            if (!habitacionS.isEmpty()) {
                System.out.println("Habitaciones Disponibles: ");
                for (Habitacion h : habitacionS) {
                    System.out.println(h.toString());
                }
            }
            return true;

        }

    // </editor-fold>

    //<editor-fold desc="Utilidades">
    public void actualizarEstados(){
        ArrayList<Habitacion> habitaciones = listarHabitaciones();
        LocalDate hoy = LocalDate.now();
        Boolean modificacion = false;
        for(Habitacion h : habitaciones){
            ArrayList<Reserva> reservas = listarReservasHabitacion(h.getIdHabitacion(), h.getIdHotel());
            Boolean control = false;
            for(Reserva r : reservas){
                if(hoy.isAfter(r.getFechaRes().minusDays(1)) && hoy.isBefore(r.getFechaFin().plusDays(1))){
                    if(hoy.isAfter(r.getFechaInicio().minusDays(1)) && hoy.isBefore(r.getFechaFin().plusDays(1))){
                        Habitacion habitacion = new Habitacion(h.getIdHabitacion(), h.getIdHotel(), h.getCapacidadCamas(), h.getCamasMatrimoniales(), h.isAireAcondicionado(), h.isBalcon(), h.isVista(), h.getAmenities(), "ocupada");
                        PHabitacion.modificarHabitacion(habitacion);
                    }
                    else {
                        Habitacion habitacion = new Habitacion(h.getIdHabitacion(), h.getIdHotel(), h.getCapacidadCamas(), h.getCamasMatrimoniales(), h.isAireAcondicionado(), h.isBalcon(), h.isVista(), h.getAmenities(), "reservada");
                        PHabitacion.modificarHabitacion(habitacion);
                    }
                    modificacion = true;
                    control = true;
                }

            }
            if(!(h.getEstado().equals("disponible")) && !(control)){
                Habitacion habitacion = new Habitacion(h.getIdHabitacion(), h.getIdHotel(), h.getCapacidadCamas(), h.getCamasMatrimoniales(), h.isAireAcondicionado(), h.isBalcon(), h.isVista(), h.getAmenities(), "disponible");
                PHabitacion.modificarHabitacion(habitacion);
                modificacion = true;
            }
        }
        if(!modificacion){
            System.out.println("Todos los estados al dia.");
        }
    }
    // </editor-fold>
}
