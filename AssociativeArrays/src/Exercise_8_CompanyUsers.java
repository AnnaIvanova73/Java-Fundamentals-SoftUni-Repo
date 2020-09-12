import java.util.*;

public class Exercise_8_CompanyUsers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, ArrayList<String>> companyRegister = new HashMap<>();

        String input = scan.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("->");
            String company = tokens[0].trim();
            String idEmployee = tokens[1].trim();

            companyRegister.putIfAbsent(company, new ArrayList<>());
            if (!companyRegister.get(company).contains(idEmployee)) {
                companyRegister.get(company).add(idEmployee);
            }


            input = scan.nextLine();
        }

        companyRegister
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach((c) -> {
                    System.out.printf("%s%n",c.getKey());
                    c.getValue()
                            .forEach(id -> System.out.println(String.format("-- %s", id)));
                });

    }
}
