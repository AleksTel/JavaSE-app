package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Collection;

/**
 * Array based storage for Resumes
 */
public interface C_Storage {

    void clear();

    void update(Resume r);

    void save(Resume r);

    Resume get(String uuid);

    void delete(String uuid);

    Collection<Resume> getAllSorted();

    int size();

}
