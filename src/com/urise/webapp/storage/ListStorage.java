package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 21.06.2016.
 */
public class ListStorage extends AbstractStorage <Integer>  {

    private List<Resume> list = new ArrayList<>();


    @Override
    protected Integer getContext(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected boolean exist(Integer ctx) {
        return ctx >=0;
    }

    @Override
    protected void doClear() {
        list.clear();

    }

    @Override
    protected void doUpdate(Resume r, Integer ctx) {
        list.set(ctx, r);

    }

    @Override
    protected void doSave(Resume r, Integer ctx) {
        list.add(r);

    }

    @Override
    protected Resume doGet(Integer ctx) {
        return list.get(ctx);
    }

    @Override
    protected void doDelete(Integer ctx) {
        list.remove(ctx.intValue());

    }

    @Override
    protected List<Resume> getAll() {
        return new ArrayList<>(list);
    }

    @Override
    protected int getSize() {
        return list.size();
    }
}
