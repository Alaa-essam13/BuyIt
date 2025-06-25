package org.example.springsec.ecomm.repo;

import org.example.springsec.ecomm.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AddressRepo extends JpaRepository<Address, Long> {


    @Query("""
            select a from Address a where a.user.id = :id
""")
    public List<Address> findAdresses(Long orderId);

}
