package com.library.oc.library.model.bean.book;

import org.jetbrains.annotations.NonNls;

import javax.validation.constraints.NotNull;

public class Editor {

    // ==================== Attributs ====================
    private Integer id;

    @NotNull
    private String name;

    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public Editor() {
    }

    public Editor(Integer pId) { id = pId;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
