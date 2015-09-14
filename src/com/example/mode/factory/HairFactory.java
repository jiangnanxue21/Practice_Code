package com.example.mode.factory;



import java.util.ResourceBundle;

/**
 * Created by xue on 15/9/12.
 */
public class HairFactory {
    public HairInterface getHairByClassKey(String key){
        ResourceBundle bundle = ResourceBundle.getBundle("type") ;
        String name = bundle.getString(key) ;
        HairInterface hair = null;
        try {
            hair = (HairInterface)Class.forName(name).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  hair ;
    }
}
