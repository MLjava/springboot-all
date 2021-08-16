package fish.study.utils;

import com.alibaba.fastjson.JSONObject;
import fish.study.base.BaseResult;
import lombok.SneakyThrows;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author: malin
 * @date:2020/4/23
 **/
public class ResponseUtils {

    private ResponseUtils() {
    }

    /**
     * 输出JSON 数据消息数据
     *
     * @param response 服务器响应体
     */
    @SneakyThrows
    public static void JSONResponsePrint(HttpServletResponse response, BaseResult baseResult) {
        response.setContentType("application/json;charset=utf-8");
        var printWriter = response.getWriter();
        printWriter.write(JSONObject.toJSONString(baseResult));
        printWriter.flush();
        printWriter.close();
    }
}