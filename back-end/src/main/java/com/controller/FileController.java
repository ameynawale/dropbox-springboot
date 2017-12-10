package com.controller;

import com.entity.Files;
import com.entity.User;
import com.entity.UserModel;
//import org.apache.commons
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
//import org.apache.commons.io.FileUtils;
//import java.nio.file.Files;


import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
//import java.io.File.renameTo;

@Controller    // This means that this class is a Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/files")

public class FileController {
   // @Autowired
    public User user;
    String uploads = System.getProperty("user.dir")+"\\src\\main\\Uploads";
    @PostMapping(path="/myfiles", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<String> getAllfiles(@RequestBody String userdata, HttpSession session) {
        System.out.println("in /myfiles");
        // This returns a JSON with the users
        JSONObject jsonObject = new JSONObject(userdata);
        System.out.println(userdata);
        System.out.println((String)jsonObject.get("username"));
        String username = (String)jsonObject.get("username");
//        session.setAttribute("name",jsonObject.getString("username"));
//        System.out.println(session.getAttribute("name"));
        List<String> results = new ArrayList<String>();
        System.out.println("session in /myfiles"+username);
       // File[] files = new File(uploads/*+"\\"+jsonObject.getString("userdata")*/).listFiles();
//If this pathname does not denote a directory, then listFiles() returns null.
        File[] files = new File(uploads+"\\"+username).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName());
            }

        }
        System.out.println(results);
       // JSONObject jsonObject1 = new JSONObject(results);
        //System.out.println(jsonObject1);
        return results;
    }


    @PostMapping(path="/doGetStar", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<String> getAllStar(@RequestBody String userdata, HttpSession session) {
        System.out.println("in /doGetStar");
        // This returns a JSON with the users
        JSONObject jsonObject = new JSONObject(userdata);
        System.out.println(userdata);
        System.out.println((String)jsonObject.get("username"));
        String username = (String)jsonObject.get("username");
//        session.setAttribute("name",jsonObject.getString("username"));
//        System.out.println(session.getAttribute("name"));
        List<String> results = new ArrayList<String>();
        System.out.println("session in /myfiles"+username + "_star");
        // File[] files = new File(uploads/*+"\\"+jsonObject.getString("userdata")*/).listFiles();
//If this pathname does not denote a directory, then listFiles() returns null.
        File[] files = new File(uploads+"\\"+username+ "_star").listFiles();
        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName());
            }

        }
        System.out.println(results);
        // JSONObject jsonObject1 = new JSONObject(results);
        //System.out.println(jsonObject1);
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

    @PostMapping(path="/doStar",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity doStar( @RequestBody String username, HttpSession session) {
        // This returns a JSON with the users
           JSONObject jsonObject = new JSONObject(username);
     //   UserModel um = new UserModel();
        System.out.println("username"+username);
        // System.out.println("jsonobject"+jsonObject);
       /* System.out.println(jsonObject.getString("username"));
        session.setAttribute("name",jsonObject.getString("username"));
        System.out.println(session.getAttribute("name"));*/
        File file = new File(uploads+"\\"+jsonObject.getString("username")+"\\"+jsonObject.getString("item"));
        try{
          //  System.out.println("username1"+username);
            file.renameTo(new File(uploads+File.separator+jsonObject.getString("username")+"_star"+File.separator+jsonObject.getString("item")));

            file.delete();
            System.out.println("File moved successfully");
        }
        catch (Exception e){
            System.out.println("Failed to move the file");
            System.out.println(e);
        }

      //  String userResult=username;
      //  System.out.println("username3"+username);
        return new ResponseEntity(HttpStatus.OK);
      //  um.setUsername(username);
      //  return um;
    }

    @PostMapping(path="/doDelStar",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity doDelStar( @RequestBody String username, HttpSession session) {
        // This returns a JSON with the users
        JSONObject jsonObject = new JSONObject(username);
        //   UserModel um = new UserModel();
        System.out.println("username"+username);
        // System.out.println("jsonobject"+jsonObject);
       /* System.out.println(jsonObject.getString("username"));
        session.setAttribute("name",jsonObject.getString("username"));
        System.out.println(session.getAttribute("name"));*/
        File file = new File(uploads+"\\"+jsonObject.getString("username")+"_star"+"\\"+jsonObject.getString("item"));
        try{
            //  System.out.println("username1"+username);
            file.renameTo(new File(uploads+File.separator+jsonObject.getString("username")+File.separator+jsonObject.getString("item")));

            file.delete();
            System.out.println("File moved successfully");
        }
        catch (Exception e){
            System.out.println("Failed to move the file");
            System.out.println(e);
        }

        //  String userResult=username;
        //  System.out.println("username3"+username);
        return new ResponseEntity(HttpStatus.OK);
        //  um.setUsername(username);
        //  return um;
    }


    @PostMapping(path="/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody UserModel Upload(@RequestParam("mypic") MultipartFile file, @RequestParam("username") String username, HttpSession session) {
        // This returns a JSON with the users
    //    JSONObject jsonObject = new JSONObject(username);
        UserModel um = new UserModel();
        System.out.println("username"+username);
       // System.out.println("jsonobject"+jsonObject);
       /* System.out.println(jsonObject.getString("username"));
        session.setAttribute("name",jsonObject.getString("username"));
        System.out.println(session.getAttribute("name"));*/
        try{
            file.transferTo(new File(uploads+File.separator+username+File.separator+file.getOriginalFilename()));
        }
        catch (Exception e){
            System.out.println(e);
        }

        String userResult=username;
      //  return new ResponseEntity(HttpStatus.CREATED);
        um.setUsername(username);
        return um;
    }

    @PostMapping(path="/doShare",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity doShare( @RequestBody String username, HttpSession session) {
        // This returns a JSON with the users
        JSONObject jsonObject = new JSONObject(username);
        //   UserModel um = new UserModel();
        System.out.println("username"+username);
        // System.out.println("jsonobject"+jsonObject);
       /* System.out.println(jsonObject.getString("username"));
        session.setAttribute("name",jsonObject.getString("username"));
        System.out.println(session.getAttribute("name"));*/
        File file = new File(uploads+"\\"+jsonObject.getString("username")+"\\"+jsonObject.getString("activeItemName"));

        File source = new File("/Users/pankaj/tmp/sourceChannel.avi");
        File dest = new File("/Users/pankaj/tmp/destChannel.avi");
        //start = System.nanoTime();
        //copyFileUsingChannel(source, dest);
        //System.out.println("Time taken by Channel Copy = "+(System.nanoTime()-start));

        private static void copyFileUsingChannel(File source, File dest) throws IOException {
            FileChannel sourceChannel = null;
            FileChannel destChannel = null;
            try {
                sourceChannel = new FileInputStream(source).getChannel();
                destChannel = new FileOutputStream(dest).getChannel();
                destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
            }finally{
                sourceChannel.close();
                destChannel.close();
            }
        }

        //source = new File("/Users/pankaj/tmp/sourceChannel.avi");
        //dest = new File("/Users/pankaj/tmp/destChannel.avi");
        //start = System.nanoTime();
        //copyFileUsingChannel(source, dest);

        try{
            //  System.out.println("username1"+username);
            file.renameTo(new File(uploads+File.separator+jsonObject.getString("emails")+File.separator+jsonObject.getString("activeItemName")));

        //    file.delete();
            System.out.println("File moved successfully");
        }
        catch (Exception e){
            System.out.println("Failed to move the file");
            System.out.println(e);
        }

        //  String userResult=username;
        //  System.out.println("username3"+username);
        return new ResponseEntity(HttpStatus.OK);
        //  um.setUsername(username);
        //  return um;
    }
}
