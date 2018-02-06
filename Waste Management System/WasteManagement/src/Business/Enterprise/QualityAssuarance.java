/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author jay
 */
public class QualityAssuarance extends Enterprise {

    public QualityAssuarance(String name) {
        super(name, EnterpriseType.QualityAssuarance);

    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

}
