package org.example.service.Impl;

import org.example.dto.PromotionDTO;
import org.example.request.CreatePromotionRequest;
import org.example.request.UpdatePromotionRequest;
import org.example.response.GetPromotionResponse;

import java.util.List;

public interface PromotionService {

    void createPromotion(CreatePromotionRequest createPromotionRequest);

    void updatePromotion(UpdatePromotionRequest updatePromotionRequest, Integer promotionId);

    GetPromotionResponse getPromotionById(Integer promotionId);

    List<PromotionDTO> showAll();

    PromotionDTO create(PromotionDTO dto);

    void delete(Integer promotionId);

    PromotionDTO update(PromotionDTO dto);

    PromotionDTO showOne(Integer promotionId);
}
