package app.services.Impl;

import app.Entities.Client;
import app.repos.ClientRepository;
import app.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;

@Service
public class ClientService implements IClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Override
    @Transactional
    public void addClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    @Transactional
    public Iterable<Client> getAllClients() {
        Iterable<Client> clients = clientRepository.findAll();
        return clients;
    }

    @Override
    @Transactional
    public Iterable<Client> searchClients(String firstName) {
        Iterable<Client> clients;
        if (firstName != null  && !firstName.isEmpty()) {
            clients = clientRepository.findByFirstNameContaining(firstName);
        } else {
            clients = clientRepository.findAll();
        }
        return clients;
    }

    @Override
    @Transactional
    public void deleteClientById(int idClient) {
        clientRepository.deleteById(idClient);
    }

    @Override
    @Transactional
    public Iterable<Client> searchClients(String firstName, String lastName) {
        Iterable<Client> clients;
        if (firstName.isEmpty() || lastName.isEmpty()) {
            clients = clientRepository.findAll();
        } else {
            clients = clientRepository.findAllByFirstNameAndLastName(firstName, lastName);
        }
        return clients;
    }
    @Override
    @Transactional
    public void updateClientFirstName(int idClient, String newFirstName) {
        if (newFirstName!= null && !newFirstName.isEmpty() && !clientRepository.findById(idClient).isEmpty()) {
            Client client = clientRepository.getOne(idClient);
            client.setFirstName(newFirstName);
            clientRepository.save(client);
        }
    }

    @Override
    @Transactional
    public Iterable<Client> searchClients(int number) {
        return clientRepository.findAllByNumber(number);
    }

    @Override
    @Transactional
    public Client getNeedClient(int idClient) {
        if (!clientRepository.findById(idClient).isEmpty()) {
            return clientRepository.getOne(idClient);
        }
        return null;
    }

    @Override
    @Transactional
    public void updateClientsGroup(int idGroup) {
        clientRepository.updateClientsGroup(idGroup);
    }
}
