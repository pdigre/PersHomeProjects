package org.digre.organizer.navigator;


public class GKey {

    public Object id;

    public GKey(Object id) {
        this.id=id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
    @Override
    public boolean equals(Object id) {
        return this.id.equals(id);
    }
}
