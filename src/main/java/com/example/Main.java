package com.example;
import com.example.views.HomeView;

public class Main {
    
    public static void main(String[] args) {
        try {
            HomeView homeView = new HomeView();
            homeView.showMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
