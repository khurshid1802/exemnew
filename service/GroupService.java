package service;

import model.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupService implements BaseService<Group>{
    public List<Group> groups =new ArrayList<>();

    @Override
    public Group add(Group group) {
        groups.add(group);
        return group;
    }

    @Override
    public List<Group> list() {
        return groups;
    }
}
