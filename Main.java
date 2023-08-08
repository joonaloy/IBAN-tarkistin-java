import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //pyytää iban tilinumeroa
        System.out.println("Kirjoita IBAN tilinumero pls");
        String tilinum = scanner.nextLine();
        //poistaa välilyönnit
        tilinum = tilinum.replaceAll("\\s", "");
        //tallentaa maatunnuksen ja kaksinumeroisen tarkistenumeron
        String tun = tilinum.substring(0,4);
        //tallentaa ekan ja tokan kirjaimen ja tekee niistä numeroita getpositionin avulla
        char EKACHAR = tilinum.charAt(0);
        char TOKACHAR = tilinum.charAt(1);
        int position1 = getPosition(EKACHAR);
        int position2 = getPosition(TOKACHAR);
        //muuttaa numerot stringiksi
        String ekakirjainnumerona = Integer.toString(position1);
        String tokakirjainnumerona = Integer.toString(position2);
        //poistaa maatunnuksen ja kaksinumeroisen tarkistenumeron tilinumeron alusta ja lisää ne tilinumeron loppuun
        String tunnum = tun.substring(2,4);
        tilinum = tilinum.replace(tun , "");
        tun = ekakirjainnumerona+tokakirjainnumerona+tunnum;
        tilinum = tilinum+tun;
        //muuttaa tilinumeron integeriksi, jakaa numerolla 97 ja tallentaa jakojäännöksen
        BigInteger loppunum = new BigInteger(tilinum);
        BigInteger jakari = loppunum.remainder(BigInteger.valueOf(97));
        //jos jakojäännös on 1 tilinumero on kelvollinen
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
