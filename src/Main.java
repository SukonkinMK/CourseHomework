import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Registry registry = new Registry();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("========================================================");
            System.out.println("Введите команду:");
            System.out.println("1 - Завести новое животное");
            System.out.println("2 - Вывести текущий список животных");
            System.out.println("3 - Увидеть список команд, которое выполняет животное");
            System.out.println("4 - Обучить животное новым командам");
            System.out.println("5 - Выход из приложения");
            try (MyCounter counter = new MyCounter()) {
                int input = Integer.parseInt(scanner.next());
                System.out.println(input);
                switch (input){
                    case 1: //Завести новое животное
                        Pets pet = createPet(scanner);
                        if(registry.addNewPet(pet)){ 
							counter.add();
                            System.out.println("Домашнее животное " + pet.getName() + " добавлено в реестр");
                        }
						else{
							System.out.println("Домашнее животное добавить в реестр не удалось");
						}
                        break;
                    case 2: //Вывести текущий список животных
                        List<Pets> list = registry.getPets();
                        if(list.size() == 0){
                            System.out.println("Реестр пуст");
                        }
                        else {
                            for (Pets item:list) {
                                System.out.println(item);
                            }
                        }
						break;
					case 3: //Увидеть список команд, которое выполняет животное
						System.out.println("Введите имя животного:");
						Pets targetPet = registry.findPetInRegistry(scanner.next());
						if(targetPet != null) {
							System.out.println("Список известных питомцу " + targetPet.getName() + " команд:");
							String commands = targetPet.getKnownCommands();
							if(commands.equals("")){
								System.out.println("Список команд пуст");
							}
							else {
									System.out.println(commands);
							}
                        }
						else{
							System.out.println("Домашнее животное в реестре не найдено");
						}
                        break;
					case 4: //Обучить животное новым командам
						System.out.println("Введите имя животного:");
						Pets pet1 = registry.findPetInRegistry(scanner.next());
						if(pet1 != null){
							boolean addCommand = true;
							while(addCommand){
								System.out.println("Введите новую команду для обучения животного");
								String command = scanner.next();
								if(!pet1.commandExistCheck(command)){
									pet1.teachNewCommand(command);
									System.out.println("Команда успешно добавлена");
								}
								else {
									System.out.println("Такая команда уже добавлена");
								}
								System.out.println("Желаете продолжить добавление команд (y/n): ");
								if(!scanner.next().equals("y")){
									addCommand = false;
								}
							}
						}
						else {
							System.out.println("Домашнее животное в реестре не найдено");
						}
						break;
                    case 5:
                        System.out.println("Выход из приложения");
                        return;
                }
            }
            catch (Exception e){
                System.out.println("Введена неверная команда");
            }
        }
    }
    public static Pets createPet(Scanner scanner) throws Exception{
        Pets pet = null;
        System.out.println("Введите\n 1, если это собака\n 2, если это кот\n 3, если это хомяк");
        int input = Integer.parseInt(scanner.next());
        if(input == 1 || input == 2 || input == 3) {
            System.out.println("Введите имя питомца");
            String name = scanner.next();
            System.out.println("Введите дату рождения питомца в формате dd/MM/yyyy");
            SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
            Date date = parser.parse(scanner.next());
            if (input == 1)
                pet = new Dogs(name, date);
            else if (input == 2)
                pet = new Cats(name, date);
            else
                pet = new Hamsters(name, date);
        }
        else {
            System.out.println("Нет такого животного");
        }
        return pet;
    }
	
}