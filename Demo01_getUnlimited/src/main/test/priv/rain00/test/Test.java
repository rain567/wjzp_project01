package priv.rain00.test;

import com.alibaba.fastjson.JSONObject;
import priv.rain00.utils.GetCode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

    @org.junit.Test
    public void test01(){
        String token = GetCode.sendGet("https://api.weixin.qq.com/cgi-bin/token","grant_type=client_credential&appid=wx497b799d99fb56b4&secret=fcf1d6f752b0b38fc426925e4e9519b1");
        System.out.println(token);
    }

    @org.junit.Test
    public void test02(){
        String token = GetCode.sendGet("https://api.weixin.qq.com/cgi-bin/token", "grant_type=client_credential&appid=wx82d06619359fabd5&secret=3bcb7e32e48478f1af90c7f5e385b57f");
        JSONObject json_test = JSONObject.parseObject(token);
        String openid = "test";
        String qrName = "session" + openid;
        String Path = "D:\\java\\projects\\Demo01_getUnlimited\\src\\main\\webapp\\" + qrName + ".png";
        //你的json数据 ,格式不要错
        String json = "{\"scene\":\"name=jerry\",\"width\":300}";
        byte[] data = GetCode.post("https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=" + json_test.getString("access_token"), json);

        //new一个文件对象用来保存图片
        File imageFile = new File(Path);
        //创建输出流
        FileOutputStream outStream = null;
        try {
            outStream = new FileOutputStream(imageFile);
            //写入数据
            outStream.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭输出流
                outStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
