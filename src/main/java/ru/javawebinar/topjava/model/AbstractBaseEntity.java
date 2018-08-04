package ru.javawebinar.topjava.model;

public abstract class AbstractBaseEntity {
    protected Integer id;

    AbstractBaseEntity(Integer id) {
        this.id = id;
    }

    AbstractBaseEntity() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public boolean isNew() {
        return this.id == null;
    }

    @Override
    public String toString() {
        return String.format("Entity %s (%s)", getClass().getName(), id);
    }
}