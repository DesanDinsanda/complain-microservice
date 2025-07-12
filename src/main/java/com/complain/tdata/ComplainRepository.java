package com.complain.tdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplainRepository extends JpaRepository<Complain,Integer> {

    @Query("SELECT c FROM Complain c WHERE c.customerId=?1")
    public List<Complain> getComplainsByCustomerId(int id);

    @Modifying
    @Query("UPDATE Complain c SET c.status='Resolved' WHERE c.id=?1")
    public void updateComplainStatus(int id);
}
