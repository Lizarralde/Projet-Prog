package user;

import gestion_stock.Etat;

import java.util.List;

import material.Material;
import material.MaterialQuantity;

/**
 * @author Dorian LIZARRALDE
 * 
 */
public class Manager extends User {

    public Manager(String name, String forname) {

        super(name, forname);
    }

    /**This method simulates the sending of a material to the repair
     * @author Falou SECK
     * @param materials A list of materials to be repaired (only if they are damaged)
     */
    public void sendMaterialToRepair(List<MaterialQuantity> materials){
        
        for(MaterialQuantity mat: materials)
            if (mat.getMat().getState().equals(Etat.Inutilisable)){
                mat.getMat().setState(Etat.EnReparation);
                mat.getMat().setNumberOfRepair(mat.getMat().getNumberOfRepair()+1);
            }
                
        
    }
    
    
    /**This method simulates the repair of a list of damaged materials
     * @author Falou SECK
     * @param materials The list of damaged 
     */
    public void repairMaterial(List<MaterialQuantity> materials){
        for(MaterialQuantity mat: materials)
            if (mat.getMat().getState().equals(Etat.EnReparation)){
                mat.getMat().setQuality(mat.getMat().getQuality()+50);
                mat.getMat().setState(Etat.Disponible);
            }
    }
    
    /**
     * This method returns the device with the highest number of loans
     * @param materials A list of different materials
     * @return The most loaned material
     */
    public Material mostLoanedMaterial(List<Material> materials){
        if (!materials.isEmpty()){
            Material material = materials.get(0);
            for (Material device: materials){
                if(device.getNombreEmprunt()>material.getNombreEmprunt())
                    material=device;
            }
            return material;
        }
        return null;
    }
   
    /**
     * This method returns the device with the highest number of repairs
     * @param materials A list of different materials
     * @return The most damaged material
     */
    public Material mostDamagedMaterial(List<Material> materials){
        if (!materials.isEmpty()){
            Material material = materials.get(0);
            for (Material device: materials){
                if(device.getNumberOfRepair()>material.getNumberOfRepair())
                    material=device;
            }
            return material;
        }
        return null;
    }
    
    /**
     * This method returns the user with the highest number of loans 
     * @param users A list of users (Borrowers)
     * @return The user who has done the highest number of loans
     */
    public User greatestBorrower(List<User> users){
        if (!users.isEmpty()){
            User user = users.get(0);
            for (User borrower: users){
                if(borrower.getNumberOfLoan()>borrower.getNumberOfLoan() )
                    user= borrower;
            }
            return user;
        }
        return null;
    }
   
    
}


