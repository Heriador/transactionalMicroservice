package com.Emazon.transactionMicroservice.infrastructure.configuration.beanConfiguration;

import com.Emazon.transactionMicroservice.domain.api.ISupplyServicePort;
import com.Emazon.transactionMicroservice.domain.spi.IAuthenticationPersistencePort;
import com.Emazon.transactionMicroservice.domain.spi.IStockPersistencePort;
import com.Emazon.transactionMicroservice.domain.spi.ISupplyPersistencePort;
import com.Emazon.transactionMicroservice.domain.usecases.SupplyUseCases;
import com.Emazon.transactionMicroservice.infrastructure.configuration.feignConfiguration.IStockFeignClient;
import com.Emazon.transactionMicroservice.infrastructure.output.feignClient.adapter.StockFeignAdapter;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.adapter.AuthenticationAdapter;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.adapter.SupplyAdapter;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.mapper.SupplyEntityMapper;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.repository.ISupplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ISupplyRepository supplyRepository;
    private final SupplyEntityMapper supplyEntityMapper;
    private final IStockFeignClient stockFeignClient;


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

}
