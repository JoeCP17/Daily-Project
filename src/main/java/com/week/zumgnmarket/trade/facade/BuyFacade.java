package com.week.zumgnmarket.trade.facade;

import com.week.zumgnmarket.trade.dto.buy.TradeRequest;
import com.week.zumgnmarket.trade.dto.buy.TradeResponse;
import com.week.zumgnmarket.trade.service.buyer.PurchaseProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BuyFacade {

    private final PurchaseProcessor purchaseProcessor;

    public TradeResponse buy(Long productId, TradeRequest tradeRequest) {

        try{
            purchaseProcessor.process(productId, tradeRequest);
            return TradeResponse.of(productId, true, "구매 요청 성공");

        }catch (Exception e){
            return TradeResponse.of(productId, false, e.getMessage());
        }
    }
}
