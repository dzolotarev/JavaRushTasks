package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> params = new LinkedHashMap<>();
        params.put("name", "Ivanov");
        params.put("country", "Ukraine");
        params.put("city", "Kiev");
        params.put("age", null);
        System.out.println(getQuery(params));

    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> e : params.entrySet()) {
            String key = e.getKey();
            String value = e.getValue();
            if (value != null) {
                sb.append(" and ").append(key).append(" = ").append("'").append(value).append("'");
            }
        }

        return sb.delete(0,5).toString();
    }

//    public static String getQuery(Map<String, String> params) {
//        StringBuilder queryBuilder = new StringBuilder();
//        for (String s : params.keySet()) {
//            String value = params.get(s);
//            if (value == null) {
//                continue;
//            }
//            if (queryBuilder.toString().length() != 0) {
//                queryBuilder.append(" and ");
//            }
//            queryBuilder.append(s + " = '" + value + "'");
//        }
//        return queryBuilder.toString();
//    }
}
