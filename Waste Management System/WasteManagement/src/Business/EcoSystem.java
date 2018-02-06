package Business;

import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author jay
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private WasteDirectory wasteDirectory;

    public WasteDirectory getWasteDirectory() {
        return wasteDirectory;
    }

    public void setWasteDirectory(WasteDirectory wasteDirectory) {
        this.wasteDirectory = wasteDirectory;
    }

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
            business.setWasteDirectory(new WasteDirectory());

        }
        return business;
    }

    private EcoSystem() {
        super(null);
        networkList = new ArrayList<>();
        this.wasteDirectory = new WasteDirectory();

    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public Network createAndAddNetwork() {
        Network network = new Network();
        
        networkList.add(network);
        return network;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    public boolean checkIfUsernameIsUnique(String username) {

        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
            return false;
        }

        return true;
    }
}
