package com.lmc.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Author lmc
 * @Description
 * @Date: Create in 22:53 2020/8/16
 */
@Component
public class MyPasswordEncoder implements PasswordEncoder {

    @Autowired
    private static final String SALT = "lmc";

    @Override
    public String encode(CharSequence charSequence) {
        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        return encoder.encodePassword(charSequence.toString(), SALT);
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        return encoder.isPasswordValid(s, charSequence.toString(), SALT);
    }
}
