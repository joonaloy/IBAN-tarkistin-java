import java.math.BigInteger;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kirjoita IBAN tilinumero pls");
        String tilinum = scanner.nextLine();
        tilinum = tilinum.replaceAll("\\s", "");
        String tun = tilinum.substring(0,4);
        char EKACHAR = tilinum.charAt(0);
        char TOKACHAR = tilinum.charAt(1);
        int position1 = getPosition(EKACHAR);
        int position2 = getPosition(TOKACHAR);
        String ekakirjainnumerona = Integer.toString(position1);
        String tokakirjainnumerona = Integer.toString(position2);
        String tunnum = tun.substring(2,4);
        tilinum = tilinum.replace(tun , "");
        tun = ekakirjainnumerona+tokakirjainnumerona+tunnum;
        tilinum = tilinum+tun;
        BigInteger loppunum = new BigInteger(tilinum);
        BigInteger jakari = loppunum.remainder(BigInteger.valueOf(97));
        if(jakari.compareTo(BigInteger.ONE) == 0){
            System.out.println("joo on oikee");
        }else {
            System.out.println("väärä");
        }
    }
    public static int getPosition(char ch) {
        ch = Character.toUpperCase(ch);
        return ch - 'A' + 1 + 9;
    }
}