import java.util.ArrayList;
import java.util.List;

public class Registry {
    private List<Pets> pets;

    public Registry() {
        this.pets = new ArrayList<>();
    }

    public boolean addNewPet(Pets pet){
		if(pet == null)
			return false;
		else if(pets.size() == 0 || !checkNameExist(pet.getName()))
		{
			pets.add(pet);
			return true;
		}
		else
			return false;
    }

    public List<Pets> getPets(){
        return pets;
    }

	private boolean checkNameExist(String name){
		for (Pets item:pets){
			if(item.getName().equals(name)){
				return true;
			}
		}
		return false;
	}

	public Pets findPetInRegistry(String name){
		for (Pets item:pets){
			if(item.getName().equals(name)){
				return item;
			}
		}
		return null;
	}
}
