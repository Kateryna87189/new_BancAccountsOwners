import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*

Дан список  BankAccount {Person owner, String IBAN, double balance).
Класс Person состоит из {String fName, String lName String email)

Используя stream необходимо получить List всех аккаунтов, баланс которых составляет менее 100.

Используя stream необходимо получить List всех владельцев счетов

Используя stream,  сформировать лист строк вида “Lennon J.;IBAN: DE199988643;lennon@gmail.com”
 (т.е. ФИО; счет, email)  для всех клиентов, чей баланс более 100000


 */
public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>(List.of(
                new Person("Andrej","Homichev","homich@mail.com"),
                new Person("Georgij","Muha","muha@mail.com"),
                new Person("Olesya","Shyshkina","shzshka@mail.com"),
                new Person("Oleksandr","Prokopchuk","prokop@mail.com"),
                new Person("Maryna","Kushka","kushka@mail.com")
                ));
        List<BankAccount> accounts = new ArrayList<>(List.of(
               new BankAccount( personList.get(0), "DE123456789",90.00),
               new BankAccount(personList.get(1),"DE987654321",30000.00),
               new BankAccount(personList.get(2),"DE234561789",180000.43),
               new BankAccount(personList.get(3), "DE564783289",100000.15),
               new BankAccount(personList.get(4),"DE876539876",54.03)
        ));

        List<BankAccount> lowBalansAccount = new ArrayList<>();
      accounts.stream()
              .filter(a->a.getBalans()<100)
              .forEach(lowBalansAccount::add);
        System.out.println("-----клієнти чий баланс меньше 100-----");
      lowBalansAccount.forEach(System.out::println);

      List<Person> accountOwners = new ArrayList<>();
      accounts.stream()
              .map(BankAccount::getOwner)
              .forEach(accountOwners::add);
        System.out.println("-----Усі клієнти банку-----");
      accountOwners.forEach(System.out::println);


      List<String> richClient=new ArrayList<>();
      accounts.stream()
              .filter(a->a.getBalans()>100000)
              .map(a->a.getOwner().getlName()+" "+ a.getOwner().getfName()
             +", IBAN "+a.getIBAN()+";"+ a.getOwner().getEmail() )
              .forEach(richClient::add);
        System.out.println("---------Клієнти чий баланс більше 100000-----------");
      richClient.forEach(System.out::println);

    }
}