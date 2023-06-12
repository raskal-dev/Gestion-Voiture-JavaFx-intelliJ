package mg.coursjavafx.coursjavafx.Controllers;

import java.util.Random;

public class FoncionController {

    public static String genererNumero(int longueur) {
        String caracteres = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(longueur);
        Random random = new Random();

        for (int i = 0; i < longueur; i++) {
            int index = random.nextInt(caracteres.length());
            char caractere = caracteres.charAt(index);
            sb.append(caractere);
        }

        return sb.toString();
    }
}
