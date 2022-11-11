import java.nio.channels.Channel;

public class AplikasiTodolist {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodolist();
    }

    /**
     * Menampilkan todo list
     */
    public static void showToDoList() {
        System.out.println("TODOLIST");
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodolist() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi Kasus membuat aplikasi todolist";
        showToDoList();
    }

    /**
     * Menambah todo ke list
     */
    public static void addToDoList(String todo) {
        // cek apakah model penuh?
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                // model masih ada yang kosong
                isFull = false;
            break;
        }
    }

    // Jika penuh, kita resize ukuran array 2x
    if (isFull) {
        var temp = model;
        model = new String[model.length * 2];

        for (int i = 0; i < temp.length; i++) {
            model[i] = temp[i];
        }
    }

    // tambahkan ke posisi yang data arraynya null
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList () {
        for (int i = 0; i < 25; i++) {
            addToDoList("Contoh Todo Ke" + i);
        }
        showToDoList();
    }
    /**
     * Menghapus todo list
     */
    public static boolean removeTodoList(Integer number ) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {

            for (int i = (number - 1) ; i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i]= null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList () {
        addToDoList("Satu");
        addToDoList("Dua");
        addToDoList("Tiga");
        addToDoList("Empat");
        addToDoList("Lima");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList (7);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showToDoList();
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi " + name);

        var channel = input("Channel");
        System.out.println(channel);
    }

    /**
     * Menampilkan view todo list
     */

    public static void viewShowTodolist() {
        while (true) {
            showToDoList();

            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Piih");

            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengeti");
            }
        }
    }


    public static void testViewShowTodoList() {
        addToDoList("Satu");
        addToDoList("Dua");
        addToDoList("Tiga");
        addToDoList("Empat");
        addToDoList("Lima");
        viewShowTodolist();
    }

    public static void viewAddTodoList() {
        System.out.println("Menambah TODOLIST");

        var todo = input("Todo (x Jika Batal)");

        if (todo.equals("x")) {
            // batal
        } else{
            addToDoList(todo);
        }
    }

    public static void testViewaddTodoList () {
        addToDoList("Satu");
        addToDoList("Dua");

        viewAddTodoList();

        showToDoList();
    }

    public static void viewRemoveTodoList() {
        System.out.println( " HAPUS TODOLIST");

        var number = input("Nomor yg dihapus (x Jika Batal)");

        if (number.equals("x")){
        } else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus todolist : " + number);
            }
        }
    }

    public static void testViewRemoveTodoList() {
        addToDoList("Satu");
        addToDoList("Dua");
        addToDoList("Tiga");

        showToDoList();

        viewRemoveTodoList();

        showToDoList();
    }
}