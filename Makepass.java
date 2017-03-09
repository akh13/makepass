import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.Console;

public class Makepass {
	Cipher cipher;
	public final static String AES_KEY = "1234567890123456789012345678901234567890123456789012345678901234";
	public static void main( String[] args ) throws NoSuchAlgorithmException,
        InvalidAlgorithmParameterException, InvalidKeyException{
        String name;
        String key;
        Console console = System.console();
        name = new String(console.readPassword("Please enter your password: "));
        key = encrypt(name);
        System.out.println(key);
        
 	}
		
	public static String generateAESKey(Integer numBits) throws Exception {
		
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(numBits);
		SecretKey key = keyGenerator.generateKey();
		
		return byteArrayToHexString(key.getEncoded());
	}

	@SuppressWarnings("finally")
	public static String encrypt(String value) throws NoSuchAlgorithmException,
        InvalidAlgorithmParameterException, InvalidKeyException {
		SecretKeySpec sks = new SecretKeySpec(hexStringToByteArray(AES_KEY), "AES");
		try {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, sks, cipher.getParameters());
		byte[] encrypted = cipher.doFinal(value.getBytes());
		System.out.println(byteArrayToHexString(encrypted));
		} catch(Exception e) {
     	e.printStackTrace();
   		}
		finally {  
            return "Here's the crypto key you asked for! Keep it safe.";        
        }
	} 

	private static String byteArrayToHexString(byte[] b){
		StringBuffer sb = new StringBuffer(b.length * 2);
		for (int i = 0; i < b.length; i++){
			int v = b[i] & 0xff;
			if (v < 16) {
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));
		}
		return sb.toString().toUpperCase();
	}

	private static byte[] hexStringToByteArray(String s) {
		byte[] b = new byte[s.length() / 2];
		for (int i = 0; i < b.length; i++){
			int index = i * 2;
			int v = Integer.parseInt(s.substring(index, index + 2), 16);
			b[i] = (byte)v;
		}
		return b;
	}

}
