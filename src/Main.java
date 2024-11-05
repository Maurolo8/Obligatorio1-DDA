import Controladora.Controladora;
import Persistencia.Conexion;
import Utilities.AppException;
import java.util.Scanner;

public class Main {
    private static Scanner escaner = new Scanner(System.in);
    private static Controladora controladora = new Controladora();

    public static void main(String[] args) {

       Conexion c = new Conexion();

        int opcion = -1;
        do{
            mostrarMenu();
            try {
                opcion = Integer.parseInt(escaner.nextLine());
                switch (opcion){
                    case 1:{
                        controladora.agregarHotel();
                        break;
                    }
                    case 2:{
                        controladora.modificarHotel();
                        break;
                    }
                    case 3:{
                    controladora.eliminarHotel();
                        break;
                    }

                    case 4:{
                        controladora.agregarHabitacion();
                        break;
                    }
                    case 5:{
                        controladora.modificarHabitacion();
                        break;
                    }
                    case 6:{
                        controladora.eliminarHabitacion();
                        break;
                    }

                    case 7:{
                        controladora.agregarHuesped();
                        break;
                    }
                    case 8:{
                        controladora.modificarHuesped();
                        break;
                    }
                    case 9:{
                        controladora.eliminarHuesped();
                        break;
                    }

                    case 10:{
                        controladora.agregarReserva();
                        break;
                    }
                    case 11:{
                        controladora.modificarReserva();
                        break;
                    }
                    case 12:{
                        controladora.eliminarReserva();
                        break;
                    }

                    case 13:{
                        controladora.agregarTarifa();
                        break;
                    }
                    case 14:{
                        controladora.modificarTarifa();
                        break;
                    }
                    case 15:{
                        controladora.eliminarTarifa();
                        break;
                    }
                    case 16:{
                        consultarHoteles();
                        break;
                    }
                    case 17:{
                        controladora.habitacionesEnUnPeriodo();
                        break;
                    }
                    case 18:{
                        controladora.habitacionesDesocupadas();
                    }
                    case 19:{
                        controladora.actualizarEstados();
                        break;
                    }

                    case 0:{
                        System.out.println("Que tenga un buen dia :)");;
                        break;
                    }
                    default:
                        throw new AppException("Valor no contemplado");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
            }
            catch (NumberFormatException nfe){
                System.out.println("El programa no recibe letras");
            }
            catch (Exception e){
                System.out.println("Error catastrofico, muerte inminente, contraseñas filtradas, dejaste el horno prendido... todo mal");
            }
        }
        while(opcion!= 0);
    }

    public static void mostrarMenu() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║          MENÚ PRINCIPAL      ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║   1. Agregar Hotel           ║");
        System.out.println("║   2. Modificar Hotel         ║");
        System.out.println("║   3. Eliminar Hotel          ║");
        System.out.println("║   4. Agregar Habitacion      ║");
        System.out.println("║   5. Modificar Habitacion    ║");
        System.out.println("║   6. Eliminar Habitacion     ║");
        System.out.println("║   7. Agregar Huesped         ║");
        System.out.println("║   8. Modificar Huesped       ║");
        System.out.println("║   9. Eliminar Huesped        ║");
        System.out.println("║   10. Agregar Reserva        ║");
        System.out.println("║   11. Modificar Reserva      ║");
        System.out.println("║   12. Eliminar Reserva       ║");
        System.out.println("║   13. Agregar Tarifa         ║");
        System.out.println("║   14. Modificar Tarifa       ║");
        System.out.println("║   15. Eliminar Tarifa        ║");
        System.out.println("║   16. Consulta de Hoteles    ║");
        System.out.println("║   17. Reservas entre fechas  ║");
        System.out.println("║   18. Habit. Res. y Dis.     ║");
        System.out.println("║   19. Actualizar Estados     ║");
        System.out.println("║   0. Salir                   ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.print("Elige una opción o ingrese 0 para salir: ");
    }

    public static void consultarHoteles(){
        menuConsultaHoteles();
        System.out.print("Elige una opción o ingrese 0 para salir: ");
        int opcion = -1;
        do{
            try {
                opcion = Integer.parseInt(escaner.nextLine());
                switch (opcion){
                    case 1:{
                        controladora.hotelXciudad();
                        break;
                    }
                    case 2:{
                        controladora.hotelXnombre();
                        break;
                    }
                    case 3:{
                        controladora.hotelXestrellas();
                        break;
                    }
                    case 0:{
                        System.out.println("Ha salido de 'Consultas de hoteles'");;
                        break;
                    }
                    default:
                        throw new AppException("Valor no contemplado");
                }
            }
            catch (AppException ae){
                System.out.println(ae.getMessage());
            }
            catch (NumberFormatException nfe){
                System.out.println("El programa no recibe letras");
            }
            catch (Exception e){
                System.out.println("Error catastrofico, muerte inminente, contraseñas filtradas, dejaste el horno prendido... todo mal");
            }
        }
        while(opcion!= 0);
    }

    public static void menuConsultaHoteles(){
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║        CONSULTA HOTELES      ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║   1. Hoteles por Ciudad      ║");
        System.out.println("║   2. Hoteles por nombre      ║");
        System.out.println("║   3. Hoteles por estrellas   ║");
        System.out.println("║   0. Salir                   ║");
        System.out.println("╚══════════════════════════════╝");

    }

}