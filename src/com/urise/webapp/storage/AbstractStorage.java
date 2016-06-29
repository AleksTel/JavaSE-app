package com.urise.webapp.storage;

import com.sun.xml.internal.ws.api.model.ExceptionType;
import com.urise.webapp.model.Resume;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * Array based storage for Resumes
 */
abstract public class AbstractStorage<C> implements  Storage{

    protected abstract C getContext(String uuid);

    protected abstract boolean exist(C ctx);


    @Override
    public void clear() {
        doClear();
    }

    protected abstract void doClear();

    private C getContext(Resume r) {
        return getContext(r.getUuid());
    }


    @Override
    public void update(Resume r) {
        requireNonNull(r, "Resume must not be null");
        C ctx = getContext(r);
        mustExist(r.getUuid(), ctx);
        doUpdate(r, ctx);
    }

    protected abstract void doUpdate(Resume r, C ctx);


    @Override
    public void save(Resume r) {
        requireNonNull(r, "Resume must not be null");
        C ctx = getContext(r);
        mustNotExist(r.getUuid(), ctx);
        doSave(r, ctx);
    }

    protected abstract void doSave(Resume r, C ctx);

    @Override
    public Resume get(String uuid) {
        requireNonNull(uuid, "UUID must not be null");
        C ctx = getContext(uuid);
        mustExist(uuid, ctx);
        return doGet(ctx);
    }

    protected abstract Resume doGet(C ctx);

    @Override
    public void delete(String uuid) {
        requireNonNull(uuid, "UUID must not be null");
        C ctx = getContext(uuid);
        mustExist(uuid, ctx);
        doDelete(ctx);
    }

    protected abstract void doDelete(C ctx);

    @Override
    public Collection<Resume> getAllSorted() {
        List<Resume> list = getAll();
        Collections.sort(list);
        return list;
    }

    protected abstract List<Resume> getAll();

    @Override
    public int size() {
        int size = getSize();
        return size;
    }

    protected abstract int getSize();


    private void mustExist(String uuid, C ctx) {
    }

    private void mustNotExist(String uuid, C ctx){

    }

    
}
