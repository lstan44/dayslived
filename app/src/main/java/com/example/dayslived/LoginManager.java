package com.example.dayslived;
import android.widget.Toast;

import java.util.*;


public class LoginManager{
    public static boolean isKnownUser(String name, String psswd) {
        if (name.equals("stanley") && psswd.equals("lalanne")) {
            return true;
        } else {
            return false;
        }
    }

}
