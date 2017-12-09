package com.controller;

import com.entity.Files;
import com.entity.User;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
//import org.apache.commons
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller    // This means that this class is a Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/files")
public class FileController {
    String uploads = System.getProperty("user.dir")+"\\src\\main\\Uploads";
    @PostMapping(path="/myfiles", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<String> getAllfiles(@RequestBody String uname) {
        // This returns a JSON with the users
        JSONObject jsonObject = new JSONObject(uname);
      //  System.out.println(jsonObject.getString("userdata"));
        List<String> results = new ArrayList<String>();

        File[] files = new File(uploads/*+"\\"+jsonObject.getString("userdata")*/).listFiles();
//If this pathname does not denote a directory, then listFiles() returns null.

        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName());
            }

        }
        System.out.println(results);
        return results;
    }
    @PostMapping(path="/getfolders",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<String> getAllfolders(@RequestBody String uname) {
        // This returns a JSON with the users
        JSONObject jsonObject = new JSONObject(uname);
        System.out.println(jsonObject.getString("uname"));
        List<String> results = new ArrayList<String>();
        File[] files = new File(uploads+"\\"+jsonObject.getString("uname")).listFiles();
//If this pathname does not denote a directory, then listFiles() returns null.

        for (File file : files) {
            if (!file.isFile()) {
                results.add(file.getName());
            }
        }
        return results;
    }

    @PostMapping(path="/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity Upload(@RequestParam("mypic") MultipartFile file, HttpSession session) {
        // This returns a JSON with the users
        try{
            file.transferTo(new File(uploads+File.separator+session.getAttribute("name")+File.separator+file.getOriginalFilename()));
        }
        catch (Exception e){
            System.out.println(e);
        }


        return new ResponseEntity(HttpStatus.CREATED);
    }
}
