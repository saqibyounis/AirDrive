package com.air.drive.network;

public class RemoveIpAddressEnd {
public static String getIp(String ip){
    StringBuilder builder=new StringBuilder(ip);
    while(true){
       if(builder.charAt(builder.length()-1)=='.'){

           break;
       }else {

           builder.deleteCharAt(builder.length()-1);


       }

    }

    return builder.toString();
}
    public static String getLastIp(String ip){
    StringBuilder lastString=new StringBuilder();
        StringBuilder builder=new StringBuilder(ip);
        while(true){
            if(builder.charAt(builder.length()-1)=='.'){

                break;
            }else {

                //builder.deleteCharAt(builder.length()-1);
                   lastString.append(builder.charAt(builder.length()-1));
                builder.deleteCharAt(builder.length()-1);

            }

        }

        return lastString.toString();
    }
}
