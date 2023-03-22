import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Pets {
    private String name;
    private List<String> knownCommands;
    private Date birthday;

    public Pets(String name, Date birthday){
        this.name = name;
        this.knownCommands = new ArrayList<>();
        this.birthday = birthday;
    }

    public void teachNewCommand(String command){
        knownCommands.add(command);
    }

    public String getName() {
        return name;
    }

    public String getKnownCommands() {
		String result = "";
		for(String item:knownCommands){
			result += item;
			result += " ";
		}
        return result;
    }

    public Date getBirthday() {
        return birthday;
    }

	public boolean commandExistCheck(String command) {
		if(knownCommands.size() == 0){
			return false;
		}
		for (String item:knownCommands){
			if(item.equals(command)){
				return true;
			}
		}
		return false;
	}

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return name + " " + format.format(birthday);
    }
}
