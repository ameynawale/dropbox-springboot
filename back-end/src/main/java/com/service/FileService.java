package com.service;

import com.entity.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class FileService {

    String uploads = System.getProperty("user.dir")+"\\src\\main\\Uploads";
    public InputStreamResource download(String username, String file, String path) throws IOException {
        File file1=new File(uploads+ File.separator+username + File.separator+ file);
        return new InputStreamResource(new FileInputStream(file1));
    }
}
