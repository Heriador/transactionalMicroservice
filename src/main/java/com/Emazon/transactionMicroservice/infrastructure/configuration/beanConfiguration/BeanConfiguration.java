package com.Emazon.transactionMicroservice.infrastructure.configuration.beanConfiguration;

import com.Emazon.transactionMicroservice.domain.api.ISupplyServicePort;
import com.Emazon.transactionMicroservice.domain.spi.IAuthenticationPersistencePort;
import com.Emazon.transactionMicroservice.domain.spi.IStockPersistencePort;
import com.Emazon.transactionMicroservice.domain.spi.ISupplyPersistencePort;
import com.Emazon.transactionMicroservice.domain.usecases.SupplyUseCases;
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


    @Bean
    public ISupplyPersistencePort supplyPersistencePort(){
        return new SupplyAdapter(supplyRepository, supplyEntityMapper);
    }

    @Bean
    public IAuthenticationPersistencePort authenticationPersistencePort(){
        return null;
    }

    @Bean
    public IStockPersistencePort stockPersistencePort(){
        return null;
    }


    @Bean
    public ISupplyServicePort supplyServicePort(){
        return new SupplyUseCases(supplyPersistencePort(), authenticationPersistencePort(), stockPersistencePort());
    }

}
