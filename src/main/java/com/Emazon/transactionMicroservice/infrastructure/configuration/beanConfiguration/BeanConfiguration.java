package com.Emazon.transactionMicroservice.infrastructure.configuration.beanConfiguration;

import com.Emazon.transactionMicroservice.domain.api.ISaleDetailsServicePort;
import com.Emazon.transactionMicroservice.domain.api.ISaleServicePort;
import com.Emazon.transactionMicroservice.domain.api.ISupplyServicePort;
import com.Emazon.transactionMicroservice.domain.spi.*;
import com.Emazon.transactionMicroservice.domain.usecases.SaleDetailsUseCase;
import com.Emazon.transactionMicroservice.domain.usecases.SaleUseCases;
import com.Emazon.transactionMicroservice.domain.usecases.SupplyUseCases;
import com.Emazon.transactionMicroservice.infrastructure.configuration.feignConfiguration.IShoppingCartFeignClient;
import com.Emazon.transactionMicroservice.infrastructure.configuration.feignConfiguration.IStockFeignClient;
import com.Emazon.transactionMicroservice.infrastructure.output.feignClient.adapter.ShoppingCartFeignAdapter;
import com.Emazon.transactionMicroservice.infrastructure.output.feignClient.adapter.StockFeignAdapter;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.adapter.AuthenticationAdapter;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.adapter.SaleAdapter;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.adapter.SaleDetailsAdapter;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.adapter.SupplyAdapter;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.mapper.ISaleDetailsEntityMapper;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.mapper.ISaleEntityMapper;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.mapper.SupplyEntityMapper;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.repository.ISaleDetailsRepository;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.repository.ISaleRepository;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.repository.ISupplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ISupplyRepository supplyRepository;
    private final ISaleRepository saleRepository;
    private final ISaleDetailsRepository saleDetailsRepository;
    private final SupplyEntityMapper supplyEntityMapper;
    private final ISaleEntityMapper saleEntityMapper;
    private final ISaleDetailsEntityMapper saleDetailsEntityMapper;
    private final IStockFeignClient stockFeignClient;
    private final IShoppingCartFeignClient shoppingCartFeignClient;


    @Bean
    public ISupplyPersistencePort supplyPersistencePort(){
        return new SupplyAdapter(supplyRepository, supplyEntityMapper);
    }

    @Bean
    public IAuthenticationPersistencePort authenticationPersistencePort(){
        return new AuthenticationAdapter();
    }

    @Bean
    public IStockPersistencePort stockPersistencePort(){
        return new StockFeignAdapter(stockFeignClient);
    }


    @Bean
    public ISupplyServicePort supplyServicePort(){
        return new SupplyUseCases(supplyPersistencePort(), authenticationPersistencePort(), stockPersistencePort());
    }

    @Bean
    IShoppingCartPersistencePort shoppingCartPersistencePort(){
        return new ShoppingCartFeignAdapter(shoppingCartFeignClient);
    }

    @Bean
    public ISalePersistencePort salePersistencePort(){
        return new SaleAdapter(saleRepository,saleEntityMapper,saleDetailsEntityMapper);
    }

    @Bean
    public ISaleDetailsPersistencePort saleDetailsPersistencePort(){
        return new SaleDetailsAdapter(saleDetailsRepository, saleDetailsEntityMapper);
    }

    @Bean
    public ISaleDetailsServicePort saleDetailsServicePort(){
        return new SaleDetailsUseCase(stockPersistencePort(), saleDetailsPersistencePort());
    }

    @Bean
    public ISaleServicePort saleServicePort(){
        return new SaleUseCases(salePersistencePort(),
                authenticationPersistencePort(),
                stockPersistencePort(),
                shoppingCartPersistencePort()
//                saleDetailsServicePort()
                );
    }

    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOriginPattern("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsFilter(source);

    }

}
