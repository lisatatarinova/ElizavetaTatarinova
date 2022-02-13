package com.epam.tc.hw2.testData;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsersParser {
    public List<User> users;

    public void doParsing(){
        String baseDir = System.getProperty("user.dir");
        String filepath= baseDir + "/src/test/java/com/epam/tc/hw2/testData/JDIUsers";
        File xmlFile = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder builder;
        try{
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("user");

            List<User> userList = new ArrayList<>();
            for(int i = 0; i < nodeList.getLength(); i++){
                userList.add(getUser(nodeList.item(i)));
            }
            this.users = userList;
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private static User getUser(Node node){
        User user = new User();
        if(node.getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) node;
            user.setUsername(getTagValue("username",element));
            user.setLoginName(getTagValue("loginname",element));
            user.setPassword(getTagValue("password",element));
        }
        return user;
    }

    private static String getTagValue(String tag, Element element){
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

    public String getUserName(String username, String password){
        doParsing();
        users.stream().filter(user -> (user.password == password)&&(user.username == username))
                .collect(Collectors.toList());
        return users.get(0).loginName;
    }
}
