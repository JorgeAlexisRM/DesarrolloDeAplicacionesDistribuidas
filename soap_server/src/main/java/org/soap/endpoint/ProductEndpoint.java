package org.soap.endpoint;

import java.util.List;

import org.soap.converter.ProductConverter;
import org.soap.gen.*;
import org.soap.model.ProductModel;
import org.soap.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProductEndpoint {

	private static final String NAMESPACE_URI = "http://www.org.com/soap/gen";

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductRequest")
    @ResponsePayload
    public GetProductResponse getProduct(@RequestPayload GetProductRequest request) {
        GetProductResponse response = new GetProductResponse();
        ProductModel productModel = productRepository.findByName(request.getName());
        response.setProduct(productConverter.convertProductModelToProduct(productModel));
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductsRequest")
    @ResponsePayload
    public GetProductsResponse getProducts(@RequestPayload GetProductsRequest request) {
        GetProductsResponse response = new GetProductsResponse();
        List<ProductModel> productModels = productRepository.findAll();
        List<Product> products = productConverter.convertProductModelsToProducts(productModels);
        response.getProducts().addAll(products);
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postProductRequest")
    @ResponsePayload
    public PostProductResponse postProducts(@RequestPayload PostProductRequest request) {
        PostProductResponse response = new PostProductResponse();
        ProductModel productModel = productConverter.convertProductToProductModel(request.getProduct());
        Product product = productConverter.convertProductModelToProduct(productRepository.save(productModel));
        response.setProduct(product);
        return response;
    }
}
