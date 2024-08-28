/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.wallet.data;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */ 
   
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface  DeviceRepository extends JpaRepository<Device, Long> {
    
     @Query("select w from Device  w " +
            "where lower(w.firstName) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(w.lastName) like lower(concat('%', :searchTerm, '%'))")
    List<Device> search(@Param("searchTerm") String searchTerm);

}
