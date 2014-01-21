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
            if (mat.getMat().getState().equals(Etat.Inutilisable))
                mat.getMat().setState(Etat.EnReparation);
        
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
    
    public Material mostLoanedMaterial(){
        return null;
    }
    
    public Material greatestBorrower(){
        return null;
    }
    public Material mostDamagedMaterial(){
        return null;
    }
    
}


