import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

/**
 * @author Carlos Guaraca Nagua
 * @since 10/12/25 - 16:49
 * 
 */
public class UT4Tarea6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            menu();
            try {
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        manipularDate(sc);
                        break;
                    case 2:
                        operarCalendar(sc);
                        break;
                    case 3:
                        calendarioGregoriano(sc);
                        break;
                    case 4:
                        zonasHorarias(sc);
                        break;
                    case 5:
                        horarioVeranoSimpleTimeZone(sc);
                        break;
                    case 6:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Error, introduce un número válido");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: introduce un valor numérico válido.");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }

        } while (opcion != 6);
        sc.close();
    }

    /**
     * Imprime en pantalla las opciones disponibles del ejercicio para que el
     * usuario elija qué operación realizar.
     */
    public static void menu() {
        System.out.println("\nMenú UT4Tarea6");
        System.out.println("1. Manipular Date");
        System.out.println("2. Operaciones con Calendar");
        System.out.println("3. Usar GregorianCalendar");
        System.out.println("4. Zonas horarias con TimeZone");
        System.out.println("5. Horario de Verano con SimpleTimeZone");
        System.out.println("6. Finalizar Programa");
        System.out.print("\nSeleccione una opción: ");
    }

    public static void manipularDate(Scanner sc) {
        Date actual = new Date();
        System.out.println("Fecha y hora actual: " + actual);
        //Modificamos la fecha por milisegundos
        System.out.print("Introduce los milisegundos a sumar o restar respecto a la hora actual (puedes usar negativos): ");
        try {
            long diferencia = sc.nextLong();
            sc.nextLine();

            long tiempoModificado = actual.getTime() + diferencia;
            actual.setTime(tiempoModificado);
            System.out.println("Fecha y hora modificada: " + actual);
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.out.println("Valor no válido, no se modificó la fecha.");
        }
    }

    public static void operarCalendar(Scanner sc) {
        Calendar calendario = Calendar.getInstance();
        int year = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH) + 1; // Calendar cuenta los meses desde 0
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        System.out.println("Fecha actual del calendario: " + dia + "/" + mes + "/" + year);
        System.out.print("¿Cuántos días quieres sumar o restar? (usa negativos para restar): ");

        try {
            int ajusteDias = sc.nextInt();
            sc.nextLine();

            calendario.add(Calendar.DAY_OF_MONTH, ajusteDias);
            int nuevoyear = calendario.get(Calendar.YEAR);
            int nuevoMes = calendario.get(Calendar.MONTH) + 1;
            int nuevoDia = calendario.get(Calendar.DAY_OF_MONTH);

            System.out.println("Nueva fecha: " + nuevoDia + "/" + nuevoMes + "/" + nuevoyear);
        } catch (InputMismatchException e) {
            System.out.println("Valor no válido, no se modificó la fecha del calendario.");
            sc.nextLine();
        }

    }

    public static void calendarioGregoriano(Scanner sc) {
        GregorianCalendar calendariogre = new GregorianCalendar();
        int yearActual = calendariogre.get(Calendar.YEAR);
        System.out.println("El año actual " + yearActual + (calendariogre.isLeapYear(yearActual) ? " es " : " no es ") + "bisiesto.");

        System.out.print("Introduce un año para comprobar si es bisiesto: ");
        try {
            int year = sc.nextInt();
            sc.nextLine();
            boolean comprobaryear = calendariogre.isLeapYear(year);
            System.out.println("¿El año " + year + " es bisiesto?: " + comprobaryear);
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.out.println("Valor no válido, operación cancelada.");
        }
    }

    public static void zonasHorarias(Scanner sc) {
        TimeZone zonaPredeterminada = TimeZone.getDefault();
        System.out.println("Zona horaria predeterminada: " + zonaPredeterminada.getID());

        String[] idsDisponibles = TimeZone.getAvailableIDs();
        System.out.println("\nZonas horarias disponibles:");
        for (int i = 0; i < idsDisponibles.length; i++) {
            System.out.println(i + ". " + idsDisponibles[i]);
        }

        System.out.print("\nSelecciona el numero de la zona horaria: ");
        try {
            int seleccion = sc.nextInt();
            sc.nextLine();

            if (seleccion < 0 || seleccion >= idsDisponibles.length) {
                System.out.println("Indice fuera de rango, operacion cancelada.");
                return;
            }

            TimeZone zonaElegida = TimeZone.getTimeZone(idsDisponibles[seleccion]);
            Calendar calendarioZona = Calendar.getInstance(zonaElegida);

            int year = calendarioZona.get(Calendar.YEAR);
            int mes = calendarioZona.get(Calendar.MONTH) + 1;
            int dia = calendarioZona.get(Calendar.DAY_OF_MONTH);
            int hora = calendarioZona.get(Calendar.HOUR_OF_DAY);
            int minuto = calendarioZona.get(Calendar.MINUTE);
            int segundo = calendarioZona.get(Calendar.SECOND);

            System.out.println("Hora actual en " + zonaElegida.getID() + ": " + dia + "/" + mes + "/" + year
                    + " " + hora + ":" + minuto + ":" + segundo);
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.out.println("Valor no valido, operacion cancelada.");
        }
    }

    public static void horarioVeranoSimpleTimeZone(Scanner sc) {
        SimpleTimeZone zona = new SimpleTimeZone(0, "GMT");
        Date fechaActual = new Date();

        System.out.println("\nZona seleccionada: " + zona.getID());
        System.out.println("¿Actualmente en horario de verano? " + zona.inDaylightTime(fechaActual));

        try {
            System.out.print("Introduce el año desde el que aplicarán las reglas: ");
            int startYear = sc.nextInt();
            sc.nextLine();
            zona.setStartYear(startYear);

            System.out.println("\nConfigura la regla de inicio del horario de verano");
            int mesInicio = solicitarMes(sc);
            int semanaInicio = solicitarSemana(sc);
            int diaSemanaInicio = solicitarDiaSemana(sc);
            int horaInicio = solicitarHora(sc);
            zona.setStartRule(mesInicio, semanaInicio, diaSemanaInicio, horaInicio * 3600000);

            System.out.println("\nConfigura la regla de fin del horario de verano");
            int mesFin = solicitarMes(sc);
            int semanaFin = solicitarSemana(sc);
            int diaSemanaFin = solicitarDiaSemana(sc);
            int horaFin = solicitarHora(sc);
            zona.setEndRule(mesFin, semanaFin, diaSemanaFin, horaFin * 3600000);

            System.out.println("\nLa zona usa horario de verano: " + zona.useDaylightTime());

            System.out.print("Introduce el mes (1-12) para comprobar la regla: ");
            int mesPrueba = sc.nextInt() - 1;
            System.out.print("Introduce el día del mes: ");
            int diaPrueba = sc.nextInt();
            sc.nextLine();

            Calendar fechaPrueba = Calendar.getInstance();
            fechaPrueba.set(Calendar.YEAR, startYear);
            fechaPrueba.set(Calendar.MONTH, mesPrueba);
            fechaPrueba.set(Calendar.DAY_OF_MONTH, diaPrueba);
            fechaPrueba.set(Calendar.HOUR_OF_DAY, 12);
            fechaPrueba.set(Calendar.MINUTE, 0);
            fechaPrueba.set(Calendar.SECOND, 0);

            boolean enVerano = zona.inDaylightTime(fechaPrueba.getTime());
            System.out.println("¿La fecha " + diaPrueba + "/" + (mesPrueba + 1) + "/" + startYear
                    + " está en horario de verano? " + enVerano);
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.out.println("Valor no valido, operacion cancelada.");
        }
    }

    private static int solicitarMes(Scanner sc) {
        System.out.print("Mes (1-12): ");
        return sc.nextInt() - 1;
    }

    private static int solicitarSemana(Scanner sc) {
        System.out.print("Semana del mes (1-4 o -1 para la última): ");
        return sc.nextInt();
    }

    private static int solicitarDiaSemana(Scanner sc) {
        System.out.print("Día de la semana (1=Domingo ... 7=Sábado): ");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                return Calendar.SUNDAY;
            case 2:
                return Calendar.MONDAY;
            case 3:
                return Calendar.TUESDAY;
            case 4:
                return Calendar.WEDNESDAY;
            case 5:
                return Calendar.THURSDAY;
            case 6:
                return Calendar.FRIDAY;
            case 7:
                return Calendar.SATURDAY;
            default:
                return Calendar.SUNDAY;
        }
    }

    private static int solicitarHora(Scanner sc) {
        System.out.print("Hora del día (0-23): ");
        return sc.nextInt();
    }

}