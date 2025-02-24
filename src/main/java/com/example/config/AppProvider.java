package com.example.config;

import com.example.controllers.PersonneController;
import com.example.repositories.PersonneRepository;
import com.example.services.PersonneService;

public class AppProvider {

    private static AppProvider instance;
    private final PersonneRepository personneRepository;
    private final PersonneService personneService;
    private final PersonneController personneController;


    private AppProvider() {
        this.personneRepository = new PersonneRepository();
        this.personneService = new PersonneService(personneRepository);
        this.personneController = new PersonneController(personneService);
    }

    public static AppProvider getInstance() {
        if (instance == null) {
            instance = new AppProvider();
        }
        return instance;
    }
    public PersonneRepository getPersonneRepository() {
        return personneRepository;
    }
    public PersonneService getPersonneService() {
        return personneService;
    }
    public PersonneController getPersonneController() {
        return personneController;
    }
}
