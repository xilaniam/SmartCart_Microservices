package com.sc.orderservice.grpc;

import com.sc.orderservice.exception.ProductNotFoundException;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import product.*;

@Service
public class ProductServiceGrpcClient {
    private final ProductServiceGrpc.ProductServiceBlockingStub blockingStub;

    public ProductServiceGrpcClient(@Value("${product.service.address:localhost}") String serverAdress ,
                                    @Value("${product.service.grpc.port:6001}") int serverPort){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAdress,serverPort).usePlaintext().build();
        blockingStub = ProductServiceGrpc.newBlockingStub(channel);
    }

    public GetProductResponse getProductId(String id){
        try {
            GetProductRequest request = GetProductRequest.newBuilder().setProductId(id).build();
            GetProductResponse response = blockingStub.getProductById(request);
            return response;
        } catch (StatusRuntimeException e) {
            throw new ProductNotFoundException(e.getMessage());
        }
    }

    public UpdateStockResponse updateProductStock(String id , int value){
        UpdateStockRequest request = UpdateStockRequest.newBuilder().setId(id).setDelta(value).build();
        UpdateStockResponse response = blockingStub.updateStock(request);
        return response;
    }

}
