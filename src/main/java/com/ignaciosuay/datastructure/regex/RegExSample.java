package com.ignaciosuay.datastructure.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


//        .	Any character (may or may not match line terminators)
//        \d	A digit: [0-9]
//        \D	A non-digit: [^0-9]
//        \s	A whitespace character: [ \t\n\x0B\f\r]
//        \S	A non-whitespace character: [^\s]
//        \w	A word character: [a-zA-Z_0-9]
//        \W	A non-word character: [^\w]
public class RegExSample {

    public String incrementValues(String string) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            String value = matcher.group();
            Integer num = Integer.parseInt(value);
            Integer increment = num + 1;
            string = string.replaceFirst(value, increment.toString());
        }

        return string;
    }

    public boolean isEmailAddress(String email){

        Pattern pattern = Pattern.compile(".+@.+\\..+");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
}
