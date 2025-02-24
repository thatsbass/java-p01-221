package com.example.interfaces;

public interface Identifiable {
    int getId();

    default void setId(int id) {
        throw new UnsupportedOperationException("setId non implémenté");
    }
}
