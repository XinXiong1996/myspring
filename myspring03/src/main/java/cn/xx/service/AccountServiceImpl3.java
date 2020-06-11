package cn.xx.service;

import java.lang.reflect.Array;
import java.util.*;

public class AccountServiceImpl3 implements AccountService {
    private String[] myStrs;
    private List<String> myList;
    private Set<String>  mySet;
    private Map<String,Object> myMap;
    private Properties myProes;

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, Object> myMap) {
        this.myMap = myMap;
    }

    public void setMyProes(Properties myProes) {
        this.myProes = myProes;
    }

    public void saveAccount() {
        System.out.println(Arrays.toString(myStrs));
        System.out.println(myList);
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(myProes);
    }
}
