package com.nss.utilities;

import java.util.Enumeration;
import java.util.ResourceBundle;


public class readproperties 
{
    String value;
    public String readconfig(String prop) {

        ResourceBundle rb = ResourceBundle.getBundle("configfiles.config");
        Enumeration <String> keys = rb.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            if(key.equals(prop))
            {
            value = rb.getString(key);
            break;
            
            }
        }
        return value;
    }

}