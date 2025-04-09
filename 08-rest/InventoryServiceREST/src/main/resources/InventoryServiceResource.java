package inventory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/inventory")
public class InventoryServiceResource {

    private static Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(1, "Product A", "Description of Product A"));
        products.put(2, new Product(2, "Product B", "Description of Product B"));
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{productId}")
    public Response getProduct(@PathParam("productId") int productId) {
        Product product = products.get(productId);
        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Product not found").build();
        }
        return Response.ok(product).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllProducts() {
        return Response.ok(products.values()).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createProduct(Product product) {
        products.put(product.getId(), product);
        return Response.status(Response.Status.CREATED).entity(product).build();
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{productId}")
    public Response updateProduct(@PathParam("productId") int productId, Product product) {
        if (productId != product.getId()) {
            return Response.status(Response.Status.CONFLICT).entity("Product ID mismatch").build();
        }
        products.put(productId, product);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("{productId}")
    public Response deleteProduct(@PathParam("productId") int productId) {
        if (!products.containsKey(productId)) {
            return Response.status(Response.Status.NOT_FOUND).entity("Product not found").build();
        }
        products.remove(productId);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
