package br.com.ews.jse8;

import java.util.Optional;

/**
 * Created by wallace on 17/06/16.
 */
public class OptiononalTest {


    public static void main(String[] args) {

        Optional<String> optional = Optional.ofNullable(null);
        optional.ifPresent(s -> System.out.println(s));

    }

}
