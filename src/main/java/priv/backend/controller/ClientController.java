package priv.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.backend.entity.PageBean;
import priv.backend.entity.RestBean;
import priv.backend.entity.dto.Client;
import priv.backend.service.ClientService;
import priv.backend.utils.ReturnUtils;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/list")
    public RestBean<Object> getAllClients(PageBean pageBean) {
        return ReturnUtils.messageData(clientService::getAllClients, pageBean);
    }

    @GetMapping("/{id}")
    public RestBean<Object> getClientById(@PathVariable("id") Integer id) {
        return ReturnUtils.messageData(clientService::getClientById, id);
    }

    @PostMapping("/add")
    public RestBean<Void> addClient(@RequestBody Client client) {
        return ReturnUtils.message(clientService::addClient, client);
    }

    @PutMapping("/update")
    public RestBean<Void> updateClient(@RequestBody Client client) {
        return ReturnUtils.message(clientService::updateClient, client);
    }

    @DeleteMapping("/delete/{id}")
    public RestBean<Void> deleteClient(@PathVariable("id") Integer id) {
        return ReturnUtils.message(clientService::deleteClient, id);
    }

    @GetMapping("/getAll")
    public RestBean<Object> getAllClients() {
        return ReturnUtils.messageData(clientService::getClients);
    }

    @PostMapping("/search")
    public RestBean<Object> searchClient(@RequestBody Client client) {
        return ReturnUtils.messageData(clientService::SearchClients, client);
    }

}