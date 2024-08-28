/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.wallet.data;
 
/**
 *
 * @author BOLAJI-OGEYINGBO
 */ 
  
 
import com.example.application.data.AbstractEntity;
import com.example.application.data.Contact;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.annotations.Formula;



@Entity
public class  Profile  extends AbstractEntity {
    
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "wallet")
    @Nullable
    private List<Wallet> wallets  = new LinkedList<>();

    @Formula("(select count(w.id) from Wallet w where w.profile_id = id)")
    private int walletCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Wallet> getWallets() {
        return  wallets;
    }

    public void setWallets(List<Wallet>  wallets) {
        this.wallets = wallets;
    }

    public int getWalletCount(){
        return  walletCount;
    }
    
    
    
}

