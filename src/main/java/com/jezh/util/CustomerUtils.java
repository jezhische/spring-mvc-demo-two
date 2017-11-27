package com.jezh.util;

public class CustomerUtils {
    public static String replaceFirstChar(String formContent) {
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

    public static String afterInitBinderReplaceFirstChar(String formContent) {
        if (formContent == null) return null;
        else {String firstChar = String.valueOf(formContent.charAt(0));
        return formContent.replaceFirst("[" + firstChar + "]",
                firstChar.toUpperCase());}
    }
}
