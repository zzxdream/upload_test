package com.zzxq.controller;

import com.zzxq.dao.TestDao;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.http.ResponseEntity;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.stream.FileImageInputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Author: ZZXQ
 * @Date: 2021/10/24 18:54
 */
@RestController
public class FileUploadController {

    @ConfigurationProperties(prefix = "config.entity.cat")
    @Bean
    public Cat cat() {
        return new Cat();
    }
//    @Resource
    Cat cat;
    HttpServletResponse resp;
//    @Value("${email.name}")
    private String name;
//    @Value("${email.num}")
    private int num;

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Resource
    RedisTemplate redisTemplate;
    
    @GetMapping(produces = "multipart/form-data")
    public String z(HttpServletResponse response) {
        return "111222";
    }
    
    /**
     * 测试重定向
     */
    @GetMapping("/tt")
    public void te(HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException {
        System.out.println("name = " + name);
        System.out.println("num = " + num);
        System.out.println(cat);
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        //转发
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/cc");
//        dispatcher.forward(request, response);
        response.setStatus(301);
        response.setHeader("location", "https://www.baidu.com/");
        System.out.println("牛逼");
        if(resp == null) {
            System.out.println("p");
            resp = response;
        }
        resp.setHeader("h", "h");
        System.out.println(resp.getHeader("h"));
        Thread.sleep(10000);
        PrintWriter writer = response.getWriter();
        writer.write("123");
        writer.write("456");
        writer.flush();
    }

    private AtomicInteger count = new AtomicInteger(0);

    @Resource
    TestDao testDao;

    @GetMapping("/cc")
    public void test(HttpServletResponse response) throws IOException {
        System.out.println(resp.getHeader("h") + " " + (response == resp));
        PrintWriter writer = resp.getWriter();
        writer.write("kkk");
        writer.flush();
//        testDao.insert(null, "CC");
//        return "OK";
    }

    @PostMapping("/a")
    public String aa() throws InterruptedException {
        Thread.sleep(10000);
        count.getAndAdd(1);
        System.out.println(count.get());
        return "笑死我了";
    }

    @GetMapping("/b")
    public String bb() {
        return count.get() + "";
    }


    private String filePath = "F:\\files";
    private static String parentPath = "F:\\pictures\\";

    @GetMapping("/a")
    public String a(){
//        int i = 1 / 0;
        return UUID.randomUUID().toString();
    }


    @GetMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile upload) throws IOException {
        File parentFile = new File(filePath);
        if(!parentFile.exists()){
            parentFile.mkdir();
        }
        //获取文件的原始名，如：123.png
        String originalFileName = upload.getOriginalFilename();//获取原始图片的扩展名
        //获取文件后缀名
        String lastName = originalFileName.split(".")[1];
        String newFileName = UUID.randomUUID().toString();
        String newFilePath=filePath + "\\" + newFileName; //新文件的路径
        File newFile = new File(newFilePath);
        upload.transferTo(newFile);
        return "OK";
    }

    @GetMapping("/getMeetingPlacePictureByPath/{mapPath}")
    public void getMeetingPlacePictureById(@PathVariable("mapPath") String mapPath,
                                           HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg/jpg/png/gif/bmp/tiff/svg");
        String realPath = parentPath + mapPath;
        File file = new File(realPath);
        if(file.exists()){
            FileImageInputStream in = new FileImageInputStream(file);
            ServletOutputStream os = response.getOutputStream();
            byte[] buffer = new byte[1024];
            while (in.read(buffer) != -1){
                os.write(buffer);
            }
            in.close();
            os.flush();
            os.close();
        }
    }

    @GetMapping("/getMeetingFileByPath/{meetingFilePath}")
    public void getMeetingFileByPath(@PathVariable("meetingFilePath") String meetingFilePath,
                                     HttpServletResponse response) throws IOException {
        String realPath = "F:\\files\\" + meetingFilePath;
        File file = new File(realPath);
        if(file.exists()){
            FileImageInputStream in = new FileImageInputStream(file);
            ServletOutputStream os = response.getOutputStream();
            byte[] buffer = new byte[1024];
            while (in.read(buffer) != -1){
                os.write(buffer);
            }
            in.close();
            os.flush();
            os.close();
        }
    }

    @GetMapping("/test")
    public String ok(){
        System.out.println("ok");
        return "OK";
    }

    @PostMapping("/t")
    public String t(@RequestBody List<Integer> ids){
        System.out.println(ids.size());
        return "OK";
    }

    @PostMapping("/tt")
    public String tt(@RequestBody String id){
        System.out.println(id);
        return "OK";
    }

    /**
     * 批量下载图片
     * @param response
     */
    @GetMapping("/getMultiFiles")
    public void download(List<String> pictureList, HttpServletResponse response){
        try {

            String downloadFilename = System.currentTimeMillis()+"_图片.zip";//文件的名称
            downloadFilename = URLEncoder.encode(downloadFilename, "UTF-8");//转换中文否则可能会产生乱码
            response.setContentType("application/octet-stream");// 指明response的返回对象是文件流
            response.setHeader("Content-Disposition", "attachment;filename=" + downloadFilename);// 设置在下载框默认显示的文件名

            //如果没有指定要下载的图片，返回错误信息
            if(null == pictureList){
                Map<String, Object> result = new HashMap<>();
                response.getWriter().write("没了");
                return;
            }

            ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());

            for (int i = 0; i < pictureList.size(); i++) {
//                URL url = new URL(files[i]);
                String realPath = "F:\\files\\" + pictureList.get(i);
                File file = new File(realPath);
                if(file.exists()){
                    zos.putNextEntry(new ZipEntry(pictureList.get(i)));
                    FileInputStream fis = new FileInputStream(file);
                    byte[] buffer = new byte[1024];
                    int r = 0;
                    while ((r = fis.read(buffer)) != -1) {
                        zos.write(buffer, 0, r);
                    }
                    fis.close();
                }
            }
            zos.flush();
            zos.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
