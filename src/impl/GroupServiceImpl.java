package impl;

import db.Database;
import model.Group;
import service.GroupService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroupServiceImpl implements GroupService {
    private Database database;
    public GroupServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public String addNewGroup(Group group) {
        database.getGroups().add(group);
        return "Группа успешно добавлена.\n"+group.toString();
    }

    @Override
    public String getGroupById(int id) {
        List<Group> groupList = database.getGroups().stream()
                .filter(g -> g.getId() == id)
                .toList();
        if (groupList.size() == 0) {
            return "Группа не найдена.";
        }
        return groupList.get(0).toString();

    }

    @Override
    public List<Group> getAllGroups() {
        return database.getGroups();
    }

    @Override
    public String updateGroupName(int id, String groupName) {
        List<Group> groupList = database.getGroups().stream()
                .filter(g -> g.getId() == id)
                .toList();
        if (groupList.size() == 0) {
            return "Группа не найдена.";
        }
        groupList.get(0).setName(groupName);
        return "Название группы успешно обновлено.";
    }

    @Override
    public List<Group> filterByYear(int year, String ascDesc) {
        return database.getGroups().stream()
                .filter(group -> group.getYear() == year)
                .sorted((g1, g2) -> ascDesc.equals("asc") ? g1.getName()
                        .compareTo(g2.getName()) : g2.getName().compareTo(g1.getName()))
                .toList();
    }

    @Override
    public List<Group> sortGroupByYear(String ascDesc) {
        return database.getGroups().stream()
                .sorted((g1, g2) -> ascDesc.equals("asc") ? Integer.compare(g1.getYear(),
                        g2.getYear()) : Integer.compare(g2.getYear(), g1.getYear()))
                .toList();
    }

    @Override
    public void deleteGroupById(int id) {
        database.getGroups().remove(id);
    }
}
