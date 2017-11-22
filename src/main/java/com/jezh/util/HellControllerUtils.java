package com.jezh.util;

import javax.servlet.http.HttpServletRequest;

public class HellControllerUtils {
    public static String getMessageFromRequest(HttpServletRequest request) {
//        параметры с именами "name" и "surname" - это имена текстовых полей формы, которые я дал им при создании формы
//      в hello-form.jsp, а их value (то, что я забью в поле) будет получено с помощью request.getParameter("name")...

        StringBuilder builder = new StringBuilder(request.getParameter("name").trim());
        builder.replace(0, 1, String.valueOf(builder.charAt(0)).toUpperCase());
        String surnm = request.getParameter("surname").trim();
        String surnmFirstChar = String.valueOf(surnm.charAt(0));
        surnm = surnm.replaceFirst("[" + surnmFirstChar + "]",
                surnmFirstChar.toUpperCase());
        builder.append(" " + surnm);
        return builder.toString();
    }
}
