
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Mascota {
    private String id;
    private String nombreMascota;
    private String tipoMascota;
    private int edadMascota;

    public Mascota() {
    }

    public Mascota(String id, String nombreMascota, String tipoMascota, int edadMascota) {
        this.id = id;
        this.nombreMascota = nombreMascota;
        this.tipoMascota = tipoMascota;
        this.edadMascota = edadMascota;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombreMascota;
    }

    public void setNombre(String nombre) {
        this.nombreMascota = nombre;
    }

    public String getTipo() {
        return tipoMascota;
    }

    public void setTipo(String tipo) {
        this.tipoMascota = tipo;
    }

    public int getEdad() {
        return edadMascota;
    }

    public void setEdad(int edad) {
        this.edadMascota = edad;
    }
    

    public void mostrarInformacion() {
    	
    	System.out.println( "-------Información-------\n" +
                "Identificación: " + id + "\n" +
                "Nombre: " + nombreMascota + "\n" +
                "Tipo: " + tipoMascota + "\n" +
                "Edad: " + edadMascota + " años\n");
    	System.out.println("_____________________");
        hacerSonido();
        comida();
    }

    public void hacerSonido() {
        if (tipoMascota.equalsIgnoreCase("perro")) {
            JOptionPane.showMessageDialog(null, "¡Guauuuuuuuuu!");
        } else if (tipoMascota.equalsIgnoreCase("gato")) {
            JOptionPane.showMessageDialog(null, "¡Miauuuuuuuuuuu!");
        } else {
            JOptionPane.showMessageDialog(null, "animal no registrado.");
        }
    }

    public void comida() {
        if (tipoMascota.equalsIgnoreCase("perro")) {
            JOptionPane.showMessageDialog(null, "¡Come cuido y carnes!");
        } else if (tipoMascota.equalsIgnoreCase("gato")) {
            JOptionPane.showMessageDialog(null, "¡Come pescado y cuido!");
        } else {
            JOptionPane.showMessageDialog(null, "La mascota no tiene hambre.");
        }
    }

    public void ingresarDatos() {
        id = JOptionPane.showInputDialog("Ingrese la identificación");
        nombreMascota = JOptionPane.showInputDialog("Ingrese el nombre");
        tipoMascota = JOptionPane.showInputDialog("Ingrese el tipo de mascota");
        edadMascota = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de la mascota"));
    }

    public static void main(String[] args) {
        ArrayList<Mascota> listaMascotas = new ArrayList<>();
        HashMap<String, Mascota> mapaMascotas = new HashMap<>();

        int opcion;
        String menu = "";
        do {
            menu = "MENU\n";
            menu += "1. Crear mascota\n";
            menu += "2. Consultar mascota individual\n";
            menu += "3. Consultar lista de mascotas\n";
            menu += "4. Modificar una mascota\n";
            menu += "5. Salir\n";
            menu += "Ingrese una opción:\n ";

            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1:
                    Mascota mascota = new Mascota();
                    mascota.ingresarDatos();
                    listaMascotas.add(mascota);
                    mapaMascotas.put(mascota.getId(), mascota);
                    break;
                case 2:
                    String id = JOptionPane.showInputDialog("Ingrese la identificación de la mascota a consultar: ");
                    if (mapaMascotas.containsKey(id)) {
                        Mascota mascotaConsultada = mapaMascotas.get(id);
                        mascotaConsultada.mostrarInformacion();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró ninguna mascota con la identificación ingresada.");
                    }
                    break;
                case 3:
                    String lista = "Lista de mascotas:\n";
                    for (Mascota mascotaLista : listaMascotas) {
                        lista += "Identificación: " + mascotaLista.getId() + ", Nombre: " + mascotaLista.getNombre() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, lista);
                    break;
                case 4:
                    id = JOptionPane.showInputDialog("Ingrese la identificación de la mascota a modificar: ");
                    if (mapaMascotas.containsKey(id)) {
                        Mascota mascotaModificar = mapaMascotas.get(id);
                        mascotaModificar.ingresarDatos();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró ninguna mascota con la identificación ingresada.");
                    }
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "*************Saliendo del sistema***********\n");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }
}
