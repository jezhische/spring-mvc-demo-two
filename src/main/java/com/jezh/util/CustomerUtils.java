package com.jezh.util;

import org.jetbrains.annotations.Contract;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CustomerUtils {
    @Contract("null -> null")
    public static String replaceFirstCharWithTrim(String formContent) {
        if (formContent == null)
            return null;
        else {
            String trimmed = formContent.trim();
            if (trimmed.length() == 0) return null; // иначе в следующей строчке .charAt(0) даст NullPointerException
                // (или ArrayIndexOutOfTheBoundary?)
            else {
                String firstChar = String.valueOf(trimmed.charAt(0));
                return formContent.replaceFirst("[" + firstChar + "]",
                        firstChar.toUpperCase());
            }
        }
    }

    @Contract("null -> null")
    public static String afterInitBinderReplaceFirstChar(String formContent) {
        if (formContent == null) return null;
        else {String firstChar = String.valueOf(formContent.charAt(0));
        return formContent.replaceFirst("[" + firstChar + "]",
                firstChar.toUpperCase());}
    }

    public static boolean checkCourseCode(String pattern, String courseCode) {
        Pattern thePattern = Pattern.compile("^(" + pattern + "*)");
        Matcher matcher = thePattern.matcher(courseCode);
        return matcher.find();
    }
}
