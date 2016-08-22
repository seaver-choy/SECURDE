/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.securde1.controller;

import com.mycompany.securde1.dao.AccountDAO;
import dao.ProductDAO;
import com.mycompany.securde1.db_connection.MySQLConnector;
import com.mycompany.securde1.model.AccountModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import model.ProductModel;
import object.Account;
import object.Product;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author Seaver
 */

@Controller
public class MainController {
    /*
    @RequestMapping(path = {"/", "/index**"}, method = RequestMethod.GET)
    public ModelAndView indexPage()
    {
        ModelAndView model = new ModelAndView();
         
        model.setViewName("index");
        return model;
    }
    */
    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public ModelAndView registerPage()
    {
        ModelAndView model = new ModelAndView();
        model.setViewName("register");
        return model;
    }
    
    @RequestMapping(value = {"/admin**"}, method = RequestMethod.GET)
    public ModelAndView adminPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("admin");
        return model;
    }
    
    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login(
    @RequestParam(value = "error", required = false) String error,
    @RequestParam(value = "logout", required = false) String logout)
    {
        ModelAndView model = new ModelAndView();
        
        if(error != null){
            model.addObject("error", "Invalid username and password!");
        }
        
        if(logout !=null){
            model.addObject("msg", "You have been logged out successfully");
        }
        
        model.setViewName("login");
        return model;
    }
    
    @RequestMapping(value = {"/","/main"}, method = RequestMethod.GET)
    public ModelAndView mainPage(){
        ModelAndView model = new ModelAndView();
        ProductDAO prodDAO = new ProductModel();
        List<Product> daoList = prodDAO.getAllProducts();
        
        
        model.addObject("products", daoList);
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        
        System.out.println(auth.getName() + " authentication name");
        if(!auth.getName().equalsIgnoreCase("anonymousUser")){
            AccountDAO accDAO = new AccountModel();
            Account currentAccount = accDAO.getAccount(auth.getName());
            model.addObject("user", currentAccount);
        }
        model.setViewName("mainPage");
        return model;
    }
    
    @RequestMapping(value = {"/accountingmanager"}, method = RequestMethod.GET)
    public ModelAndView accountingManagerPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("accountManager");
        return model;
    }
    
    @RequestMapping(value = {"/productmanager"}, method = RequestMethod.GET)
    public ModelAndView productManagerPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("productManager");
        return model;
    }
    
    @RequestMapping(value = "products", method = RequestMethod.GET)
    public List<Product> productList(Map<String, Object> model)
    {
        ProductDAO prodDAO = new ProductModel();
        List<Product> daoList = prodDAO.getAllProducts();
        return daoList;
    }
}
