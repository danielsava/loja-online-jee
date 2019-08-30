package service;

import dao.CompraDao;
import models.Compra;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Path("/pagamento")
public class PagamentoService {

    private static ExecutorService executor = Executors.newFixedThreadPool(50);

    @Inject
    private CompraDao compraDao;

    @Inject
    private PagamentoGateway pagamentoGateway;

    @Inject
    private ServletContext servletContext;

    @POST
    public void pagar(@Suspended final AsyncResponse ar, @QueryParam("uuid") String uuid) {

        Compra compra = compraDao.buscarPorUUID(uuid);

        executor.submit(() ->  {
            try {
                pagamentoGateway.pagar(compra);
                URI responseUri = UriBuilder
                        .fromPath("http://localhost:8080" + servletContext.getContextPath() + "/index.xhtml" + servletContext.getContextPath())
                        .queryParam("msg", "Compra realizada com sucesso")
                        .build();
                Response response = Response.seeOther(responseUri).build();
                ar.resume(response);
            } catch (Exception e) {
                ar.resume(new WebApplicationException(e));
            }
        });

    }

}
