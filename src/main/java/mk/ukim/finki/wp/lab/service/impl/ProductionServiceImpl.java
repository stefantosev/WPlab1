package mk.ukim.finki.wp.lab.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.lab.model.Production;
import mk.ukim.finki.wp.lab.repository.ProductionRepository;
import mk.ukim.finki.wp.lab.service.ProductionInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductionServiceImpl implements ProductionInterface {

    public ProductionServiceImpl(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }

    private final ProductionRepository productionRepository;
    @Override
    public List<Production> findAll() {
        return this.productionRepository.findAll();
    }
}
