package app.services;

import app.Entities.SportGroup;

public interface IGroupService {
    public void addGroup(SportGroup sportGroup);
    public Iterable <SportGroup> getAllGroups();
    public void deleteGroupById(int idGroup);
    public void updateNameGroup(int idGroup, String newNameGroup);
    public SportGroup getNeedGroup(int idGroup);
}
