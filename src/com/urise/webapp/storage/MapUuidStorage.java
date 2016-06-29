package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

/**
 * Created by Александр on 29.06.2016.
 */
public class MapUuidStorage extends AbstractStorage<String> {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected String getContext(String uuid) {
        return uuid;
    }

    @Override
    protected boolean exist(String ctx) {
        return map.containsKey(ctx);
    }

    @Override
    protected void doClear() {
        map.clear();
    }

    @Override
    protected void doUpdate(Resume r, String ctx) {
        map.put(ctx, r);

    }

    @Override
    protected void doSave(Resume r, String ctx) {
        map.put(ctx, r);

    }

    @Override
    protected Resume doGet(String ctx) {
        return map.get(ctx);
    }

    @Override
    protected void doDelete(String ctx) {
        map.remove(ctx);

    }

    @Override
    protected List<Resume> getAll() {
       return new ArrayList<>(map.values());
    }

    @Override
    protected int getSize() {
        return map.size();
    }
}
