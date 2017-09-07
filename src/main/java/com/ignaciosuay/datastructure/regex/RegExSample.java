package com.ignaciosuay.datastructure.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


//Regular Expression	Description
//.   Matches any character
//^regex  Finds regex that must match at the beginning of the line.
//regex$  Finds regex that must match at the end of the line.
//[abc]   Set definition, can match the letter a or b or c.
//[abc][vz]   Set definition, can match a or b or c followed by either v or z.
//[^abc]  When a caret appears as the first character inside square brackets, it negates the pattern. This pattern matches any character except a or b or c.
//[a-d1-7]    Ranges: matches a letter between a and d and figures from 1 to 7, but not d1.
//X|Z     Finds X or Z.
//XZ  Finds X directly followed by Z.
//$   Checks if a line end follows.

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
