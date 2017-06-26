package Figures;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Андрей on 24.06.2017.
 */
public class ProcessingFigures {


    public static void compareFigures(Figure userFigure, Figure opponentFigure) {

        int indexOfUserFigure = Figure.getOrder().indexOf(userFigure.getName());
        int indexOfOpponentFigure = Figure.getOrder().indexOf(opponentFigure.getName());
        if (indexOfOpponentFigure != indexOfUserFigure)

            switch ((( Figure.getOrder().size() +indexOfUserFigure-indexOfOpponentFigure )%Figure.getOrder().size())%2){
            case 0:
                System.out.println("You win!");
                return;
            case 1:
                System.out.println("You lose!");
                return;
        }
        System.out.println("Draw");
    }

    public static String hmacDigest(String msg, String keyString, String algorithm) {
        String digest = null;
        try {
            SecretKeySpec key = new SecretKeySpec((keyString).getBytes("UTF-8"), algorithm);
            Mac mac = Mac.getInstance(algorithm);
            mac.init(key);

            byte[] bytes = mac.doFinal(msg.getBytes("ASCII"));

            StringBuffer hash = new StringBuffer();
            for (byte aByte : bytes) {
                String hex = Integer.toHexString(0xFF & aByte);
                if (hex.length() == 1) {
                    hash.append('0');
                }
                hash.append(hex);
            }
            digest = hash.toString();
        } catch (UnsupportedEncodingException ignored) {
        } catch (InvalidKeyException ignored) {
        } catch (NoSuchAlgorithmException ignored) {
        }
        return digest;
    }

}
