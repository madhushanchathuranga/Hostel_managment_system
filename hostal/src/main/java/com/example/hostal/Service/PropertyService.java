package com.example.hostal.Service;
import com.example.hostal.Entity.Property;
public interface PropertyService {
    Property saveProperty(Property property);

    Iterable<Property> getAllProperty();

    Property getPropertyById(Integer id);
}
