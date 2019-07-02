package priv.rain00.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.rain00.bean.Token;
import priv.rain00.utils.GetCode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
@RequestMapping("/file")
public class GetUnlimitedCode {

    @RequestMapping("/getCode")
    @ResponseBody
    public String getCode(HttpServletResponse response,Token token) {
        String token0 = GetCode.sendGet("https://api.weixin.qq.com/cgi-bin/token", "grant_type=client_credential&appid="+token.getAppid()+"&secret="+token.getSecret());
        JSONObject json_test = JSONObject.parseObject(token0);
        System.out.println(json_test);
        String openid = "test";
        String qrName = "session" + openid;
        String Path = "D:\\java\\projects\\Demo01_getUnlimited\\src\\main\\webapp\\images\\" + qrName + ".png";
        //你的json数据 ,格式不要错
        String json = "{\"scene\":\"name=jerry\",\"width\":300}";
        byte[] data = GetCode.post("https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=" + json_test.getString("access_token"), json);

        //new一个文件对象用来保存图片
        File imageFile = new File(Path);
        if(imageFile.isDirectory()){
            imageFile.mkdirs();
        }
        //创建输出流
        FileOutputStream outStream = null;
        try {
            outStream = new FileOutputStream(imageFile);
            response.getOutputStream();
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
            System.out.println(Path);
            return qrName;
        }
    }
}
