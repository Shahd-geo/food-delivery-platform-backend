package com.fooddelivery.Services;

import com.fooddelivery.Dto.RestaurantRequestDTO;
import com.fooddelivery.Dto.RestaurantResponseDTO;
import com.fooddelivery.Entities.Restaurant;
import com.fooddelivery.Entities.RestaurantOwner;
import com.fooddelivery.Exceptions.ResourceNotFoundException;
import com.fooddelivery.Repositories.MenuItemRepository;
import com.fooddelivery.Repositories.RestaurantOwnerRepository;
import com.fooddelivery.Repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private RestaurantOwnerRepository restaurantOwnerRepository;
    @Autowired
    private MenuItemRepository menuItemRepository;

    public RestaurantResponseDTO createRestaurant(RestaurantRequestDTO dto, Integer ownerId) {
        RestaurantOwner owner = restaurantOwnerRepository.findById(ownerId).orElseThrow(() ->
                new ResourceNotFoundException("Owner not found"));
        Restaurant restaurant = dto.toEntity();
        restaurant.setRestaurantOwner(owner);
        restaurantRepository.save(restaurant);
        return RestaurantResponseDTO.fromEntity(restaurant);
    }
}
