package aleixo.rafael.naruto.help.desk.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

@Service
public class MD5 {

	public String encriptar(String s) throws NoSuchAlgorithmException {
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.update(s.getBytes(), 0, s.length());
		return new BigInteger(1, m.digest()).toString(16);
	}

}
