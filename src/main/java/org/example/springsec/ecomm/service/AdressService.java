package org.example.springsec.ecomm.service;

import lombok.RequiredArgsConstructor;
import org.example.springsec.ecomm.entity.Address;
import org.example.springsec.ecomm.repo.AddressRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdressService {
    private final AddressRepo addressRepo;

    public ResponseEntity<Void> addAddress(Address address){
        addressRepo.save(address);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> updateAddress(Address address){
        addressRepo.save(address);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> deleteAddress(Address address){
        addressRepo.delete(address);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<Address>> getAllAddressesOfUser(Long userId){
        return ResponseEntity.ok(addressRepo.findAdresses(userId));
    }
}
