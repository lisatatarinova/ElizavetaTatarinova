package com.epam.tc.hw2.testData;


import java.util.List;
import java.util.stream.Stream;

public class TestData {
    public String URL;
    public String browserTitle;
    public String userName;
    public String userPassword;
    public String userLoginName;
    public List<String> headerItems;
    public List<String> menuItems;
    public List<String> iconsTexts;
    public String differentElementsPage_URL;


    public TestData(){
        //Open test site by URL
        this.URL = "https://jdi-testing.github.io/jdi-light/index.html";
        this.differentElementsPage_URL = "https://jdi-testing.github.io/jdi-light/different-elements.html";
        //Assert Browser title
        this.browserTitle = "Home Page";
        //Perform login
        User userRoman = new User("Roman","Jdi1234");
        this.userName = userRoman.getUsername();
        this.userPassword = userRoman.getPassword();
        //Assert Username is loggined
        this.userLoginName = userRoman.getLoginName();
        //Assert that there are 4 items on the header section are displayed and they have proper texts
        HeaderSectionItems headerSectionItems = new HeaderSectionItems();
        this.headerItems = headerSectionItems.getHeaderSectionItems();
        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        LeftMenuSectionItems leftMenuSectionItems = new LeftMenuSectionItems();
        this.menuItems = leftMenuSectionItems.getLeftMenuItems();
        IconsTexts iconsTexts = new IconsTexts();
        this.iconsTexts = iconsTexts.getIconsTexts();
    }

}
