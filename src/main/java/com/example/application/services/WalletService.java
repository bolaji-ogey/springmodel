package com.example.application.services;

import   i.ogeyingbo.wallet.data.Profile;
import   i.ogeyingbo.wallet.data.Device;
import   i.ogeyingbo.wallet.data.Wallet;
import  i.ogeyingbo.wallet.data.ProfileRepository;
import  i.ogeyingbo.wallet.data.DeviceRepository;
import  i.ogeyingbo.wallet.data.WalletRepository;
import org.springframework.stereotype.Service;

import java.util.List;
//import org.springframework.context.annotation.Bean;


//@Service
public class WalletService {

    private final ProfileRepository  profileRepository;
    private final DeviceRepository  deviceRepository;
    private final WalletRepository  walletRepository;

     
    
    public WalletService(ProfileRepository   inProfileRepository,  DeviceRepository   inDeviceRepository,
                                    WalletRepository  inWalletRepository) {
        this.profileRepository =  inProfileRepository;
        this.deviceRepository =  inDeviceRepository;
        this.walletRepository =  inWalletRepository;
    }
    

    
    
    public List<Profile> findAllProfiles(String  stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return   profileRepository.findAll();
        } else {
            return   profileRepository.search(stringFilter);
        }
    }
    
    
    
    
    public List<Wallet> findAllWallets(String  stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return   walletRepository.findAll();
        } else {
            return   walletRepository.search(stringFilter);
        }
    }

    
   
    public List<Device> findAllDevices(String  stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return   deviceRepository.findAll();
        } else {
            return   deviceRepository.search(stringFilter);
        }
    }

       
       
    /**
    public long countContacts() {
        return contactRepository.count();
    }
    **/
    
    public long countProfiles() {
        return  profileRepository.count();
    }
    
    
     public long countDevices() {
        return   deviceRepository.count();
    }

     /***
    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);
    }
  ****/
     
    public void saveProfile(Profile  profile) {
        if (profile == null) {
            System.err.println("Profile is null. Are you sure you have connected your form to the application?");
            return;
        }
        profileRepository.save(profile);
    }

    
    
    public List<Profile> findAllProfiles() {
        return  profileRepository.findAll();
    }

    
    /***
    public List<Status> findAllStatuses(){
        return statusRepository.findAll();
    }
    ***/
    
}
