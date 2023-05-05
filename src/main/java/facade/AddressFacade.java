package facade;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Address;

import java.util.List;

@Stateless(name = "AddressFacade")
@LocalBean
public class AddressFacade extends AbstractFacade<Address> implements AddressFacadeI{

    public AddressFacade() {
        super(Address.class);
    }

    public boolean createAddress(Address address){
        try{
            this.create(address);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean editAddress(Address address){
        try {
            this.edit(address);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void removeAddress(Address address){
        this.remove(address);
    }

    public List<Address> getAllAddress() {
        return this.findAll();
    }

    public List<Address> getRangeAddress(int[] range){
        return this.findRange(range);
    }

    public Address getAddressById(String id) {
        return this.find(id);
    }

    @Override
    public int countAddress() {
        return this.count();
    }
}
