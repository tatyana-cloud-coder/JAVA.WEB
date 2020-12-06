package app.services;

import app.Entities.Client;

import java.util.List;

public interface IClientService {
    public void addClient(Client client);
    public Iterable<Client> getAllClients();
    public Iterable<Client> searchClients(String firstName);
    public Iterable<Client> searchClients(String firstName, String lastName);
    public Iterable<Client> searchClients(int number);
    public void updateClientsGroup(int idGroup);
    public Client getNeedClient(int idClient);
    public void updateClientFirstName(int idClient, String newFirstName);
    public void deleteClientById(int idClient);
}
