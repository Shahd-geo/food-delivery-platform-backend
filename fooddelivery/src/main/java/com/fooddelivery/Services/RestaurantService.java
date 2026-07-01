package com.fooddelivery.Services;

import com.fooddelivery.Dto.MenuItemResponseDTO;
import com.fooddelivery.Dto.RestaurantRequestDTO;
import com.fooddelivery.Dto.RestaurantResponseDTO;
import com.fooddelivery.Entities.MenuItem;
import com.fooddelivery.Entities.Restaurant;
import com.fooddelivery.Entities.RestaurantOwner;
import com.fooddelivery.Exceptions.ResourceNotFoundException;
import com.fooddelivery.Repositories.MenuItemRepository;
import com.fooddelivery.Repositories.RestaurantOwnerRepository;
import com.fooddelivery.Repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public RestaurantResponseDTO toggleAcceptingOrders(Integer restaurantId) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));
        restaurant.setAcceptingOrders(!restaurant.getAcceptingOrders());
        restaurantRepository.save(restaurant);
        return RestaurantResponseDTO.fromEntity(restaurant);
    }
    public RestaurantResponseDTO updateDeliveryFee(Integer restaurantId, Double newFee) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));
        restaurant.setDeliveryFee(newFee);
        restaurantRepository.save(restaurant);
        return RestaurantResponseDTO.fromEntity(restaurant);
    }
    public List<RestaurantResponseDTO> getRestaurantsByCuisine(String cuisineType) {
        List<Restaurant> restaurants = restaurantRepository.findByCuisineTypeIgnoreCase(cuisineType);
        return RestaurantResponseDTO.fromEntity(restaurants);
    }
    public List<RestaurantResponseDTO> getRestaurantsUnderDeliveryFee(Double fee) {
        List<Restaurant> restaurants = restaurantRepository.findByDeliveryFeeLessThanEqual(fee);
        return RestaurantResponseDTO.fromEntity(restaurants);
    }
    public List<MenuItemResponseDTO> getMenuForRestaurant(Integer restaurantId) {
        List<MenuItem> menuItems = menuItemRepository.findByRestaurantId(restaurantId);
        return MenuItemResponseDTO.fromEntity(menuItems);
    }
}
