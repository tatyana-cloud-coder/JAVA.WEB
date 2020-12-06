package app.services.Impl;

import app.Entities.SportGroup;
import app.repos.SportGroupRepository;
import app.services.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GroupService implements IGroupService {
    @Autowired
    private SportGroupRepository sportGroupRepository;
    @Override
    @Transactional
    public Iterable<SportGroup> getAllGroups() {
        return sportGroupRepository.findAll();
    }

    @Override
    @Transactional
    public void addGroup(SportGroup sportGroup) {
        sportGroupRepository.save(sportGroup);
    }

    @Override
    @Transactional
    public void deleteGroupById(int idGroup) {
        if (!sportGroupRepository.findById(idGroup).isEmpty()) {
            sportGroupRepository.deleteById(idGroup);
        }
    }

    @Override
    @Transactional
    public void updateNameGroup(int idGroup, String newNameGroup) {
        if(!newNameGroup.isEmpty()) {
            SportGroup sportGroup = sportGroupRepository.getOne(idGroup);
            sportGroup.setNameGroup(newNameGroup);
            sportGroupRepository.save(sportGroup);
        }
    }

    @Override
    @Transactional
    public SportGroup getNeedGroup(int idGroup) {
        if (!sportGroupRepository.findById(idGroup).isEmpty()) {
            return sportGroupRepository.getOne(idGroup);
        }
        return null;
    }
}
