package com.controller;
//package com.controller;

//  import com.AbstractTest;
import org.json.JSONObject;
import org.junit.Assert;
import com.service.UserService;
import com.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
//  import java.nio.file.Paths;

@Transactional
public class FileServiceTest {

@Autowired
private UserService fileServices;

@Test
public void login() throws Exception{
        Assert.assertEquals("login",fileServices.login("a", "a"));
        }

@Test
public void signup() throws Exception{
        Assert.assertEquals("signup",fileServices.signup("a","a","a","a"));
        }

@Test
public void createfolder() throws Exception{
        Assert.assertEquals("folder created",fileServices.findsomething("m@g.c1"));
        }

@Test
public void share() throws Exception{
        Assert.assertEquals("shared",fileServices.getAllUsers());
        }

    /*@Test
    public void delete() throws Exception{
        Assert.assertEquals("deleted",fileServices.star("m@g.c1","272.txt","/"));
    }*/
        }