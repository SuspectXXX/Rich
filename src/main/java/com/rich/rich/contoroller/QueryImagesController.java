package com.rich.rich.contoroller;

import com.rich.rich.bean.QueryImage;
import com.rich.rich.service.QueryImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Controller
@ResponseBody
public class QueryImagesController {

    @Autowired
    QueryImagesService queryImagesService;

    @RequestMapping("/uploadImage")
    public String uploadImage(@RequestParam MultipartFile[] files) {
        System.out.println(files[0].getSize());
        System.out.println(files[0].getOriginalFilename());
        return "1111";
    }

    @RequestMapping("/uploadImages")
    public String uploadImages(MultipartRequest request, @RequestParam String content, HttpServletRequest req) {
//        System.out.println(files);
        QueryImage queryImage = new QueryImage();
//        //项目根路径下的目录
//        public final static String UPLOAD_PATH_PREFIX = "static/static";
        String realPath = new String("src/main/resources/static/images/");
//        System.out.println("上传文件保存的路径" + realPath);
        String imagePath = "";
        //存放上传文件的文件夹
        File file = new File(realPath);
        if(! file.exists()) {
            file.mkdir();
        }
//        System.out.println(content);
//        System.out.println(content);
        Map<String, MultipartFile> fileMap = request.getFileMap();
        if(!fileMap.isEmpty()) {
            for (Map.Entry<String, MultipartFile> entry : fileMap.entrySet()) {
//            System.out.println(entry.getKey());
//            System.out.println( entry.getValue());
//            System.out.println(entry.getValue().getOriginalFilename());
                String oldName = entry.getValue().getOriginalFilename();
                String newName = UUID.randomUUID().toString().replace("-", "")
                        + oldName.substring(oldName.lastIndexOf("."));
//            System.out.println("newName" + newName);
                try {
                    File newFile = new File(file.getAbsolutePath() + File.separator + newName);
                    entry.getValue().transferTo(newFile);
                    String filePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort()
                            + "/images/" + newName;
//                System.out.println("filePath:" + filePath);
                    imagePath = imagePath.concat(filePath + ";");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            queryImage.setImagePath(imagePath);
        } else {
            queryImage.setImagePath("");
        }
//        System.out.println(imagePath);

        queryImage.setContent(content);


        queryImage.setDate(new Date());
        String msg = queryImagesService.insertQueryImages(queryImage);
        return msg;
    }
}
