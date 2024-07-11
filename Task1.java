import java.util.Scanner;

class Show {
    void show(String arr[][]) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(arr[i][j] + "    ");
            }
            System.out.println();
        }
    }
}

class Add extends Show {
    String[][] add(String[][] arr, int i, String name, String roll) {
        arr[i][0] = name;
        arr[i][1] = roll;
        System.out.println("Successfully Entered");
        return arr;
    }
}

interface Search {
    int search(String arr[][], String roll);
}

class Remove extends Show implements Search {
    public int search(String arr[][], String roll) {
        for (int i = 0; i < 10; i++) {
            if (arr[i][1] != null && arr[i][1].equals(roll)) {
                System.out.println("Found at index: " + i);
                return i;
            }
        }
        System.out.println("Not Found");
        return -1;
    }

    void remove(String arr[][], String roll) {
        int idx = search(arr, roll);
        if (idx != -1) {
            arr[idx][0] = null;
            arr[idx][1] = null;
            System.out.println("Successfully Removed");
        } else {
            System.out.println("Student not found");
        }
    }
}

class Update extends Add {
    void update(String[][] arr, int idx, String n, String r) {
        if (idx >= 0 && idx < arr.length) {
            arr[idx][0] = n;
            arr[idx][1] = r;
            System.out.println("Successfully Updated");
        } else {
            System.out.println("Invalid index");
        }
    }
}

class Task1 extends Update {
    public static void main(String ar[]) {
        String arr[][] = new String[10][2];
        arr[0][0] = "Ram";
        arr[0][1] = "1001";

        arr[1][0] = "Sita";
        arr[1][1] = "1002";

        arr[2][0] = "Ravan";
        arr[2][1] = "1003";

        arr[3][0] = "Lakshman";
        arr[3][1] = "1004";

        arr[4][0] = "Gita";
        arr[4][1] = "1005";

        Scanner s = new Scanner(System.in);
        Task1 m = new Task1();
        Remove se = new Remove();

        int i = 5;
        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student Details");
            System.out.println("2. Remove Student Details");
            System.out.println("3. Update Student Details");
            System.out.println("4. Search Student Details");
            System.out.println("5. Show Student Details");
            System.out.println("6. Exit");
            System.out.println("Choose number ");

            int x = s.nextInt();

            switch (x) {
                case 1: {
                    if (i < 10) {
                        System.out.println("Enter Name");
                        String nam = s.next();
                        System.out.println("Enter Roll");
                        String roll = s.next();
                        m.add(arr, i, nam, roll);
                        i++;
                    } else {
                        System.out.println("No Space");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter roll");
                    String r = s.next();
                    se.remove(arr, r);
                    break;
                }
                case 3: {
                    System.out.println("Enter Roll");
                    String r = s.next();
                    int id = se.search(arr, r);
                    if (id != -1) {
                        System.out.println("Enter New Name: ");
                        String n = s.next();
                        System.out.println("Enter New Roll: ");
                        String nr = s.next();
                        m.update(arr, id, n, nr);
                    }
                    break;
                }
                case 4: {
                    System.out.println("Enter Roll");
                    String roll = s.next();
                    se.search(arr, roll);
                    break;
                }
                case 5: {
                    m.show(arr);
                    break;
                }
                case 6: {
                    System.out.println("Exiting...");
                    s.close();
                    return;
                }
                default: {
                    System.out.println("Invalid");
                    break;
                }
            }
        }
    }
}
