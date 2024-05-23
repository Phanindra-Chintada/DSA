package com.dsa;

import com.dsa.Arrays.CustomArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class DsaApplication {

    public static void main(String[] args) {
//        SpringApplication.run(DsaApplication.class, args);
        CustomArray array = new CustomArray(2);
        array.insert(1);
        array.insert(2);
        array.insert(3);
        array.insert(4);
        System.out.println(array.getCount());
        array.removeAt(0);
        array.print();

    }

}
