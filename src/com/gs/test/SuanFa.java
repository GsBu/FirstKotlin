package com.gs.test;

public class SuanFa {
    public static boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        if(charArray.length % 2 == 0){
            for (int i = 0; i < charArray.length / 2; i++){
                switch (charArray[i]){
                    case '(':
                        if(charArray[charArray.length - i - 1] != ')' || charArray[i + 1] != ')'){
                            return false;
                        }
                        break;
                    case '[':
                        if(charArray[charArray.length - i - 1] != ']' || charArray[i + 1] != ']'){
                            return false;
                        }
                        break;
                    case '{':
                        if(charArray[charArray.length - i - 1] != '}' || charArray[i + 1] != '}'){
                            return false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        }else {
            return false;
        }
        return true;
    }
}
