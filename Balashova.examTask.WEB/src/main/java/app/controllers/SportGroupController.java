package app.controllers;

import app.Entities.Client;
import app.Entities.SportGroup;
import app.services.Impl.ClientService;
import app.services.Impl.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class SportGroupController {
    private final GroupService groupService;
    private final ClientService clientService;
    @Autowired
    public SportGroupController(GroupService groupService, ClientService clientService) {
        this.groupService = groupService;
        this.clientService = clientService;
    }
    @GetMapping("/Groups")
    public String getAllGroups(Map<String, Object> model) {
        Iterable<SportGroup> groups = groupService.getAllGroups();
        model.put("groups", groups);
        return "mainGroups";
    }
    @PostMapping("/Groups")
    public String addGroup(@RequestParam String nameGroup, @RequestParam int workingDay,
                            Map<String, Object> model)
    {
        SportGroup sportGroup = new SportGroup(nameGroup, workingDay);
        groupService.addGroup(sportGroup);
        Iterable<SportGroup> groups = groupService.getAllGroups();
        model.put("groups", groups);
        return "mainGroups";
    }
    @PostMapping("deleteGroupById")
    public String deleteGroupById(@RequestParam Integer idGroup, Map<String, Object> model) {
        SportGroup group = groupService.getNeedGroup(idGroup);
        if (group != null) {
            clientService.updateClientsGroup(idGroup);
            groupService.deleteGroupById(idGroup);
        }
        Iterable<SportGroup> groups = groupService.getAllGroups();
        model.put("groups", groups);
        return "mainGroups";
    }
    @RequestMapping("updateGroups")
    public String updateGroups(@RequestParam Integer idGroup, @RequestParam String newNameGroup, Map<String, Object> model) {
        if (groupService.getNeedGroup(idGroup) != null) {
            groupService.updateNameGroup(idGroup, newNameGroup);
        }
        Iterable<SportGroup> groups = groupService.getAllGroups();
        model.put("groups", groups);
        return "mainGroups";
    }
}
