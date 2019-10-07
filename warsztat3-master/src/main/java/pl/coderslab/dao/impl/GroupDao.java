package pl.coderslab.dao.impl;

import pl.coderslab.dao.DaoInterface;
import pl.coderslab.domain.Group;

import java.util.List;

public class GroupDao implements DaoInterface<Group> {
    @Override
    public List<Group> findAll() {
        return null;
    }

    @Override
    public Group findById(Long id) {
        return null;
    }

    @Override
    public Group update(Group group) {
        return null;
    }

    @Override
    public Group create(Group group) {
        return null;
    }

    @Override
    public boolean remove(Group group) {
        return false;
    }
}
