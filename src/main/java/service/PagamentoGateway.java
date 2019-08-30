package service;

import models.Compra;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import java.io.Serializable;

public class PagamentoGateway implements Serializable {


    public String pagar(Compra compra) {
        return ClientBuilder.newClient()
                .target("http://book-payment.herokuapp.com/payment")
                .request()
                .post(Entity.json(compra), String.class);
    }



}
