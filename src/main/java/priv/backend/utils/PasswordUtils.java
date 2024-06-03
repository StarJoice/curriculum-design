package priv.backend.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordUtils {

    // 生成密码的MD5哈希值
    public static String generateMD5Hash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5算法不存在", e);
        }
    }

    // 验证密码
    public static boolean verifyPassword(String inputPassword, String storedHash) {
        String inputHash = generateMD5Hash(inputPassword);
        return inputHash.equals(storedHash);
    }

}
