package utilities;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class CreateUserCredentials {

    public static Map<String, String> getListOfUsers(int quantity) {
        Map<String, String> users = new HashMap<>();
        String name;
        String password;
        for (int i = 0; i < quantity; i++) {
            name = generateString();
            password = encryptPassword(name);
            users.put(name, password);
        }
        return users;
    }

    public static String generateString() {
        String preparedString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(4);
        for (int j = 0; j < 4; j++) {
            int index
                    = (int) (preparedString.length()
                    * Math.random());
            sb.append(preparedString
                    .charAt(index));
        }
        return sb.toString();
    }

    private static String encryptPassword(String password) {
        String shaPassword = "";
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(password.getBytes(StandardCharsets.UTF_8));
            shaPassword = new BigInteger(1, crypt.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return shaPassword;
    }
}
