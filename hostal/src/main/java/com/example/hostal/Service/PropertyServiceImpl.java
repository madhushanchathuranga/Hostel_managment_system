package com.example.hostal.Service;

import com.example.hostal.Entity.Property;
import com.example.hostal.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService{
    @Autowired
    private PropertyRepository propertyRepository;

    public PropertyServiceImpl(PropertyRepository propertyRepository){
        super();
        this.propertyRepository=propertyRepository;
    }
    @Override
    public Property saveProperty(Property property) {
        return (Property) propertyRepository.save(property);
    }
    @Override
    public Iterable<Property> getAllProperty() {
        return (List<Property>) propertyRepository.findAll();
    }


    @Override
    public Property getPropertyById(Integer id) {
        Optional<Property> propertyOptional = propertyRepository.findById(id);
        return propertyOptional.orElse(null);
    }
}
