package qrcode.birdex.com.birdexqr.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.text.ParseException;

/**
 */
public class JSonParser {
    public static void jsonReadToString(String path) {
//从JSon文件读取数据
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            while ((line = br.readLine()) != null) {
                stringBuffer.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
//将Json文件数据形成JSONObject对象
            JSONObject jsonObject = new JSONObject(stringBuffer.toString());
//获取JSONObject对象数据并打印
            JSONArray provinces = jsonObject.getJSONArray("provinces");
            String name = null;
            StringBuffer jsonFileInfo = new StringBuffer();
            JSONArray citys = null;
            for (int i = 0; i < provinces.length(); i++) {
                name = provinces.getJSONObject(i).getString("name");
                jsonFileInfo.append("/nname:" + name + "/n" + "citys:");
                citys = provinces.getJSONObject(i).getJSONArray("citys");
                for (int j = 0; j < citys.length(); j++) {
                    jsonFileInfo.append(citys.getString(j) + "/t");
                }
            }

            System.out.println(jsonFileInfo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
