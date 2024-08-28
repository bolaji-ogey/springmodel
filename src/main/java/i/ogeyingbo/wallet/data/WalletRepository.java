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


//@Repository
public  interface  WalletRepository  extends  JpaRepository<Wallet, Long> {

    
      @Query("select w from Wallet w " +
            "where lower(w.firstName) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(w.lastName) like lower(concat('%', :searchTerm, '%'))")
    List<Wallet> search(@Param("searchTerm") String searchTerm);
    
    
}
