package app.controllers;

import app.Entities.Client;
import app.Entities.SportGroup;
import app.services.Impl.ClientService;
import app.services.Impl.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Controller
public class ClientController {

    private final ClientService clientService;
    private final GroupService groupService;
    @Autowired
    public ClientController(ClientService clientService, GroupService groupService) {
        this.clientService = clientService;
        this.groupService = groupService;
    }
    @GetMapping("/Clients")
    public String getAllClients(Map<String, Object> model)  {
        Iterable<Client> clients = clientService.getAllClients();
        model.put("clients", clients);
        return "mainClients";
    }
    @PostMapping("/Clients")
    public String addClient(@RequestParam String firstName, @RequestParam String lastName,
                            @RequestParam String telephoneNumber, @RequestParam int idGroup,  Map<String, Object> model)
    {
        SportGroup group = groupService.getNeedGroup(idGroup);
        if (group !=null) {
            group.setNumber(group.getNumber() + 1);
            Client client = new Client(firstName, lastName, telephoneNumber, group);
            clientService.addClient(client);
        }
        Iterable<Client> clients = clientService.getAllClients();
        model.put("clients", clients);
        return "mainClients";
    }
    @RequestMapping ("searchClients")
    public String searchClients(@RequestParam String firstName, Map<String, Object> model) {
        Iterable<Client> clients = clientService.searchClients(firstName);
        model.put("clients", clients);
        return "mainClients";
    }

    @RequestMapping("searchClientsBy")
    public String searchClients(@RequestParam String firstName,
                                @RequestParam String lastName, Map<String, Object> model) {
        Iterable<Client> clients = clientService.searchClients(firstName, lastName);
        model.put("clients", clients);
        return "mainClients";
    }
    @RequestMapping(path = "deleteClientById")
    public String deleteClientById(@PathVariable String idClient, Map<String, Object> model) {
        Integer id =Integer.parseInt(idClient);
        Client client = clientService.getNeedClient(id);
        if (client!=null) {
            client.getGroup().setNumber(client.getGroup().getNumber()-1);
            clientService.deleteClientById(id);
        }
        Iterable<Client> clients = clientService.getAllClients();
        model.put("clients", clients);
        return "mainClients";
    }
    @RequestMapping("updateClients")
    public String updateClients(@RequestParam Integer idClient,
                                @RequestParam String newFirstName, Map<String, Object> model) {
        clientService.updateClientFirstName(idClient, newFirstName);
        Iterable<Client> clients = clientService.getAllClients();
        model.put("clients", clients);
        return "mainClients";
    }
    @RequestMapping("searchClientsCustomSec")
    public String searchClients(@RequestParam Integer maxNumber,  Map <String, Object> model) {
        Iterable<Client> clients = clientService.searchClients(maxNumber);
        model.put("clients", clients);
        return "mainClients";
    }
}
