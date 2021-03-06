package br.com.softcube.baseproject.controllers;

import br.com.softcube.baseproject.domains.EPrice;
import br.com.softcube.baseproject.mappers.PriceMapper;
import br.com.softcube.baseproject.models.dto.price.DPrice;
import br.com.softcube.baseproject.models.dto.common.DResponse;
import br.com.softcube.baseproject.services.PriceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/v1/price")
public class PriceController {

    private PriceService priceService;
    private PriceMapper priceMapper;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DResponse<List<DPrice>>> getPrices() {
        log.info("PriceController getPrices()");
        List<EPrice> prices = priceService.getPrices();

        return ResponseEntity.ok(DResponse.ok(priceMapper.fromEPriceListToDPriceList(prices)));
    }

}