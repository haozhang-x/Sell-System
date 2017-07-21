package com.example.web.controller.api;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by zhang on 2017/7/14.
 */
@Controller
@RequestMapping("/api")
public class FileUploadApiController {
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap upload(@RequestParam("file") MultipartFile file, ModelMap modelMap, HttpServletRequest request) throws IOException {
        if (!file.isEmpty()) {
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            String contextPath = request.getServletContext().getRealPath("/")+"image" ;
            System.out.println(contextPath);
            File file1 = new File(contextPath, fileName);
            FileUtils.copyInputStreamToFile(file.getInputStream(), file1);
            modelMap.addAttribute("code", 200);
            modelMap.addAttribute("message", "success");
            modelMap.addAttribute("result", "/image/"+fileName);
        } else {
            modelMap.addAttribute("code", 400);
            modelMap.addAttribute("message", "failed");
            modelMap.addAttribute("result", null);
        }

        return modelMap;
    }
}
