package com.mufeng.vhr.controller;

import com.mufeng.vhr.beans.RespBean;
import com.mufeng.vhr.config.VerificationCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/18 17:00
 */
@RestController
public class LoginController {

    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse resp) throws IOException {
        VerificationCode code = new VerificationCode();
        BufferedImage image = code.getImage();
        String text = code.getText();
        HttpSession session = request.getSession(true);
        session.setAttribute("verify_code", text);
        VerificationCode.output(image,resp.getOutputStream());
    }
    @GetMapping("/login")
    public RespBean login() {
        return RespBean.error("尚未登录，请登录!");
    }
}
