package fish.study.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author: malin
 * @date:2020/4/22 spring security 路由配置
 **/
@Controller
public class SpringSecurityController {

    @Autowired
    private Map<String, SpringSecurityAuthenticationProcessor> processors;


    /**
     * @return 默认登录地址
     */
    @GetMapping("/index/page")
    public String indexPage() {
        return "index";
    }

    /**
     * 生成验证码
     */
    @GetMapping("/code/{className}")
    public String verificationCode(@PathVariable String className, HttpServletRequest request, HttpServletResponse response) {
        String processorName = String.format(SpringSecurityConstants.PROCESSOR_NAME, className);
        String generatorName = String.format(SpringSecurityConstants.GENERATOR_NAME, className);
        processors.get(processorName).handleAuthenticationCode(new ServletWebRequest(request, response), generatorName);
        return "/index";
    }

    @GetMapping("/mobile")
    public String mobile() {
        return "mobile";
    }

    /**
     * 404页面
     */
    @GetMapping("/404")
    public String page404() {
        return "404";
    }


}
