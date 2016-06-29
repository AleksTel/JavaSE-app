package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Александр on 21.06.2016.
 */

public class MapStorage extends AbstractStorage<Resume> {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected Resume getContext(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected boolean exist(Resume ctx) {
        return ctx != null;
    }

    @Override
    protected void doClear() {
        map.clear();

    }

    @Override
    protected void doUpdate(Resume r, Resume ctx) {
        map.put(r.getUuid(), ctx);

    }

    @Override
    protected void doSave(Resume r, Resume ctx) {
        map.put(r.getUuid(), ctx);

    }

    @Override
    protected Resume doGet(Resume ctx) {
        return ctx;
    }

    @Override
    protected void doDelete(Resume ctx) {
        map.remove(ctx.getUuid());

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
