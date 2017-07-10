/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.services;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author rafae
 */

@Service
public class CriptografiaService {

    private static SecretKey skey;
    private static KeySpec ks;
    private static PBEParameterSpec ps;
    private static final String algorithm = "PBEWithMD5AndDES";
    private static BASE64Encoder enc = new BASE64Encoder();
    private static BASE64Decoder dec = new BASE64Decoder();

    static {
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance(algorithm);
            ps = new PBEParameterSpec(new byte[]{3, 1, 4, 1, 5, 9, 2, 6}, 20);
            ks = new PBEKeySpec("EAlGeEen3m8YkO".toCharArray());
            skey = skf.generateSecret(ks);
        } catch (java.security.NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        } catch (java.security.spec.InvalidKeySpecException ex) {
            ex.printStackTrace();
        }
    }

    public static final String encrypt(final String text)
            throws
            BadPaddingException,
            NoSuchPaddingException,
            IllegalBlockSizeException,
            InvalidKeyException,
            NoSuchAlgorithmException,
            InvalidAlgorithmParameterException {
        final Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, skey, ps);
        return enc.encode(cipher.doFinal(text.getBytes()));
    }

    public static final String decrypt(final String text)
            throws
            BadPaddingException,
            NoSuchPaddingException,
            IllegalBlockSizeException,
            InvalidKeyException,
            NoSuchAlgorithmException,
            InvalidAlgorithmParameterException {
        final Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, skey, ps);
        String ret = null;
        try {
            ret = new String(cipher.doFinal(dec.decodeBuffer(text)));
        } catch (Exception ex) {
        }
        return ret;
    }

}
