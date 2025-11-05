package com.sc.productservice.grpc;

import com.sc.productservice.exception.ProductNotFoundException;
import com.sc.productservice.model.Product;
import com.sc.productservice.repository.ProductRepository;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import product.*;

import java.util.UUID;

@GrpcService
public class ProductServiceGrpcServer extends ProductServiceGrpc.ProductServiceImplBase {

    private final Logger log = LoggerFactory.getLogger(ProductServiceGrpcServer.class);
    private final ProductRepository productRepository;

    public ProductServiceGrpcServer(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public void getProductById(GetProductRequest request , StreamObserver<GetProductResponse> observer){
        try {
            log.info("Get Product by Id request received : " , request.toString());

            Product product = productRepository.findById(UUID.fromString(request.getProductId())).orElseThrow(()-> new ProductNotFoundException("The product is not found : " + request.getProductId()));

            GetProductResponse response = GetProductResponse.newBuilder()
                    .setId(product.getId().toString())
                    .setName(product.getName())
                    .setDescription(product.getDescription())
                    .setInventoryCount(product.getInventoryCount())
                    .setPrice(product.getPrice())
                    .build();

            observer.onNext(response);
            observer.onCompleted();
        } catch (ProductNotFoundException e) {
            observer.onError(Status.NOT_FOUND.withDescription(e.getMessage()).asRuntimeException());
        }
        catch (Exception e){
            observer.onError(Status.INTERNAL.withDescription("Unexpected Error : "+e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void updateStock(UpdateStockRequest request , StreamObserver<UpdateStockResponse> observer){
        Product product = productRepository.findById(UUID.fromString(request.getId())).orElseThrow(()->new ProductNotFoundException("The product is not found" + request.getId()));

        int updatedInventory = Integer.parseInt(product.getInventoryCount());
        updatedInventory += request.getDelta();

        if(updatedInventory < 0 ){
            throw new RuntimeException("Inventory count cannot be negative");
        }

        product.setInventoryCount(String.valueOf(updatedInventory));

        productRepository.save(product);

        UpdateStockResponse response = UpdateStockResponse.newBuilder()
                .setId(product.getId().toString())
                .setInventoryCount(Integer.parseInt(product.getInventoryCount()))
                .setMessage("Stock Succesfully Updated ")
                .build();

        observer.onNext(response);
        observer.onCompleted();
    }
}
