package com.udemy.backendninja.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestCryp {
                                                // muestra encliptado el rawPassword
    public static void main(String[] args){
        BCryptPasswordEncoder se = new BCryptPasswordEncoder();
        System.out.print(se.encode("user"));
    }
}
