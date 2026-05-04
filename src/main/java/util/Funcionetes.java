package util;

import java.util.Locale;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * @author Abdó García
 * @author Paco Galera
 * @author Joan Gerard Camarena
 */
public class Funcionetes {

    // este teclat agafa la coma com a separador decimal
    static Scanner teclat = new Scanner(System.in);

    // este teclat agafa el punt com a separador decimal
    // static Scanner teclat = new Scanner(System.in).useLocale(Locale.US);

    // --------------------------------------------------------------
    public static int lligInt(String pregunta) {
        int numero;
        do {
            try {
                System.out.print(pregunta);
                numero = teclat.nextInt(); // Si hem posat lletres va al catch
                teclat.nextLine();
                return numero;
            } catch (Exception e) { // Si hem posat lletres, avisa i buida el buffer
                System.out.print("Ha de ser un número enter: ");
                teclat.nextLine();
            }
        } while (true); // Bucle infinit fins que retornem el número correcte
    }

    public static long lligLong(String pregunta) {
        long numero;
        do {
            try {
                System.out.print(pregunta);
                numero = teclat.nextLong(); // Si hem posat lletres va al catch
                teclat.nextLine();
                return numero;
            } catch (Exception e) { // Si hem posat lletres, avisa i buida el buffer
                System.out.print("Ha de ser un número enter: ");
                teclat.nextLine();
            }
        } while (true); // Bucle infinit fins que retornem el número correcte
    }
    // --------------------------------------------------------------
    public static float lligFloat(String pregunta) {
        float numero;
        do {
            try {
                System.out.print(pregunta);
                numero = teclat.nextFloat(); // Si hem posat lletres va al catch
                teclat.nextLine();
                return numero;
            } catch (Exception e) { // Si hem posat lletres, avisa i buida el buffer
                System.out.print("Ha de ser un número real: ");
                teclat.nextLine();
            }
        } while (true); // Bucle infinit fins que retornem el número correcte
    }

    public static double lligDouble(String pregunta) {
        double numero;
        do {
            try {
                System.out.print(pregunta);
                numero = teclat.nextDouble(); // Si hem posat lletres va al catch
                teclat.nextLine();
                return numero;
            } catch (Exception e) { // Si hem posat lletres, avisa i buida el buffer
                System.out.print("Ha de ser un número real: ");
                teclat.nextLine();
            }
        } while (true); // Bucle infinit fins que retornem el número correcte
    }

    // --------------------------------------------------------------
    public static char lligLletra(String pregunta) {
        char lletra;
        System.out.print(pregunta);
        lletra = teclat.nextLine().charAt(0); // Si hem posat lletres va al catch
        return lletra;
    }

    public static String lligText(String pregunta) {
        String linea;
        System.out.print(pregunta);
        linea = teclat.nextLine(); // Si hem posat lletres va al catch
        return linea;
    }

    public static void printMG(String missatge) {
        JOptionPane.showMessageDialog(null, missatge);
    } // ()

    /**
     * Recull un text per finestra emergent
     * @param missatge Missatge que es mostra a la finestra emergent
     * @return Text recollit
     */
    public static String lligTextG(String missatge) {
        String llegit = JOptionPane.showInputDialog(missatge);
        if (llegit == null) {
            return "";
        }
        return llegit;
    }

    /**
     * Recull un char per finestra emergent
     * @param missatge Missatge que es mostra a la finestra emergent
     * @return Lletra recollida
     */
    public static char lligLletraG(String missatge) {
        String llegit = JOptionPane.showInputDialog(missatge);
        if (llegit == null) {
            return ' ';
        }
        return llegit.charAt(0);
    }

    /**
     * Recull un número amb decimals per finestra emergent
     * @param missatge Missatge que es mostra a la finestra emergent
     * @return Número amb decimals recollit
     */
    public static float lligFloatG(String missatge) {
        return Float.parseFloat(lligTextG(missatge));
    } // ()

    /**
     * Recull un número amb decimals per finestra emergent
     * @param missatge Missatge que es mostra a la finestra emergent
     * @return Número amb decimals recollit
     */
    public static double lligDoubleG(String missatge) {
        return Double.parseDouble(lligTextG(missatge));
    } // ()

    /**
     * Recull un número sencer per finestra emergent
     * @param missatge Missatge que es mostra a la finestra emergent
     * @return Número sencer recollit
     */
    public static int lligIntG(String missatge) {
        return Integer.parseInt(lligTextG(missatge));
    } // ()

    /**
     * Recull un número sencer per finestra emergent
     * @param missatge Missatge que es mostra a la finestra emergent
     * @return Número sencer recollit
     */
    public static long lligLongG(String missatge) {
        return Long.parseLong(lligTextG(missatge));
    } // ()
}