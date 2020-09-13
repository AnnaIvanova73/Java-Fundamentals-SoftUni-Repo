import java.util.*;
public class Task_1_Concert {

    static class Band {

        public int getTime() {
            return time;
        }

        public List<String> getMembers() {
            return members;
        }

        public String getName() {
            return name;
        }

        public Band(String name) {
            this.name = name;
        }

        public void addTime(int time) {
            this.time += time;
        }

        public void addMembers(String member) {
            if (!this.members.contains(member)) {
                this.members.add(member);
            }
        }

        private String name;
        private int time;
        private List<String> members = new ArrayList<>();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Band> bandsName = new HashMap<>();
        String input = scan.nextLine();
        while (!"start of concert".equals(input)) {
            String[] tokens = input.split(";+");
            String command = tokens[0].trim();
            String bandName = tokens[1].trim();

            Band band = bandsName.get(bandName);
            if (band == null) {
                band = new Band(bandName);
                bandsName.put(bandName, band);
            }

            switch (command) {
                case "Add":
                    String[] members = tokens[2].split(", ");
                    for (String member : members) {
                        String currMemb = member.trim();
                        band.addMembers(currMemb);
                    }

                    break;
                case "Play":
                    int time = Integer.parseInt(tokens[2].trim());
                    band.addTime(time);
                    break;
            }


            input = scan.nextLine();
        }

        int totalTime = 0;
        for (Band band : bandsName.values()) {
            totalTime += band.getTime();
        }
        System.out.println("Total time: " + totalTime);

        bandsName.entrySet().stream().sorted((a, b) -> {
            int first = a.getValue().getTime();
            int second = b.getValue().getTime();
            int comp = second - first;
            if (comp == 0) {
                comp = a.getKey().compareTo(b.getKey());
            }
            return comp;
        }).forEach((p) -> {
            System.out.printf("%s -> %s%n", p.getKey(), p.getValue().getTime());
        });

        String bandToPrint = scan.nextLine();
        Band band = bandsName.get(bandToPrint);
        System.out.println(bandToPrint);
        band.getMembers().forEach((a) -> {
            System.out.printf("=> %s%n", a);
        });
    }
}
