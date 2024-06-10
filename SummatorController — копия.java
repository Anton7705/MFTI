package ru.mfti;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;


//REST API
@RestController
class SummatorController {

    @GetMapping("/make")
    public String arithmeticExpression(String expression) {
        return fun(expression);
    }

    //логику писать сюда

    public static String fun(String expression) {
        if (expression == null || expression.isEmpty()) {
            return "0";
        }
        ArrayList<String> arr1 = new ArrayList<>();
        String[] str2 = expression.split("\\b");
        for (int i = 0; i < str2.length; i++) {
            arr1.add(str2[i]);
        }

        arr1.add(0, "0");// на случай, если первая цифра меньше 0
        return fun2(arr1);
    }

    public static String fun2(ArrayList<String> arr1) {
        for (int j = 0; j < arr1.size(); j++) {
            if (arr1.get(j).equals("*")) {
                int x = Integer.parseInt(arr1.get(j - 1)) * Integer.parseInt(arr1.get(j + 1));
                arr1.set(j, Integer.toString(x));
                arr1.remove(j - 1);
                arr1.remove(j);
                j--;
            }
            if (arr1.get(j).equals("/")) {
                int x = Integer.parseInt(arr1.get(j - 1)) / Integer.parseInt(arr1.get(j + 1));
                arr1.set(j, Integer.toString(x));
                arr1.remove(j - 1);
                arr1.remove(j);
                j--;
            }
        }
        for (int j = 0; j < arr1.size(); j++) {
            if (arr1.get(j).equals("+")) {
                int x = Integer.parseInt(arr1.get(j - 1)) + Integer.parseInt(arr1.get(j + 1));
                arr1.set(j, Integer.toString(x));
                arr1.remove(j - 1);
                arr1.remove(j);
                j--;
            }
            if (arr1.get(j).equals("-")) {
                int x = Integer.parseInt(arr1.get(j - 1)) - Integer.parseInt(arr1.get(j + 1));
                arr1.set(j, Integer.toString(x));
                arr1.remove(j - 1);
                arr1.remove(j);
                j--;
            }
        }
        if (arr1.size() == 1) {
            return arr1.get(0);
        } // В этой версии JAVA не поддерживается getLast()

        return arr1.get(1);
    }
}