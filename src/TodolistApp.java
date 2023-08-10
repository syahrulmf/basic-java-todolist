public class TodolistApp {
  public static String[] model = new String[10];
  public static java.util.Scanner scanner = new java.util.Scanner(System.in);
  public static void main(String[] args) {
    viewShowTodoList();
  }

  /**
   * Menampilkan todo list
   */
  public static void showTodoList(){
    for (var i = 0; i < model.length; i++) {
      var todo = model[i];
      var no = i + 1;

      if (todo != null){
        System.out.println(no + ". " + todo);
      }
    }
  }

  public static void testShowTodoList(){
    model[0] = "Belajar Java Basic";
    model[1] = "Belajar Java OOP";
    showTodoList();
  }

  /**
   * Menambah todo ke list
   */
  public static void addTodoList(String todo){
//    1. cek apakah model isFull
    var isFull = true;
    for (int i = 0; i < model.length; i++) {
      if (model[i] == null){
//        model masih ada yang kosong
        isFull = false;
        break;
      }
    }
    
//    2. jika penuh, kita resize ukuran array 2x lipat
    if (isFull){
      var temp = model;
      model = new String[model.length * 2];

      for (int i = 0; i < temp.length; i++) {
        model[i] = temp[i];
      }
    }
    
//    3. tambahkan todo ke posisi yang data array nya NULL
    for (var i = 0; i < model.length; i++) {
      if (model[i] == null){
        model[i] = todo;
        break;
      }
    }
  }

  public static void testAddTodoList(){
    for (int i = 0; i < 25; i++) {
      addTodoList("Contoh todo ke - " + (i + 1));
    }

    showTodoList();
  }

  /**
   * Menghapus todo dari list
   */
  public static boolean removeTodoList(Integer number){
    if ((number - 1) >= model.length){
      return false;
    } else if (model[number - 1] == null){
      return false;
    } else {
      for (int i = (number  - 1); i < model.length; i++) {
        if (i == (model.length - 1)){
          model[i] = null;
        } else {
          model[i] = model[i + 1];
        }
      }

      return true;
    }
  }

  public static void testRemoveTodoList(){
    addTodoList("Satu");
    addTodoList("Dua");
    addTodoList("Tiga");
    addTodoList("Empat");
    addTodoList("Lima");

    var result = removeTodoList(20);
    System.out.println(result);

    result = removeTodoList(7);
    System.out.println(result);

    result = removeTodoList(2);
    System.out.println(result);

    showTodoList();
  }

  public static String input(String info){
    System.out.print(info + " : ");
    String data = scanner.nextLine();
    return data;
  }

  public static void testInput(){
    var data = input("Nama");
    System.out.println("Hii, " + data);

    var address = input("Alamat : ");
    System.out.println(address);
  }

  /**
   * Menampilkan view todo list
   */
  public static void viewShowTodoList(){
    while(true){
      System.out.println("TODO LIST");

      showTodoList();

      System.out.println("MENU : ");
      System.out.println("1. Tambah");
      System.out.println("2. Hapus");
      System.out.println("x. Keluar");

      var input = input("Pilih ");

      if (input.equals("1")){
        viewAddTodoList();
      } else if (input.equals("2")){
        viewRemoveTodoList();
      } else if (input.equals("x")) {
        break;
      } else {
        System.out.println("\nPilihan tidak dimengerti!.\n");
      }
    }
  }

  public static void testViewShowTodoList() {
    addTodoList("Satu");
    addTodoList("Dua");
    addTodoList("Tiga");
    addTodoList("Empat");
    addTodoList("Lima");

    viewShowTodoList();
  }

  /**
   * Menampilkan view tambah todo ke list
   */
  public static void viewAddTodoList(){
    System.out.println("TAMBAH TODO LIST");

    var todo = input("Todo (tekan x Jika Batal)");

    if (todo.equals("x")){
//      batal
    } else {
      addTodoList(todo);
    }
  }

public static void testViewAddTodoList(){
    addTodoList("Satu");
  addTodoList("Dua");

    viewAddTodoList();

    showTodoList();
}


  /**
   * Menampilkan view menghapus todo dari list
   */
  public static void viewRemoveTodoList(){
    System.out.println("HAPUS TODO LIST");

    var numberTodo = input("Nomor Todo yang di hapus (tekan x Jika Batal)");

    if (numberTodo.equals("x")){
//      batal
    } else {
      boolean success = removeTodoList(Integer.valueOf(numberTodo));
      if (!success){
        System.out.println("Gagal menghapus todo list.");
      }
    }
  }

  public static void testViewRemoveTodoList(){
    addTodoList("Satu");
    addTodoList("Dua");
    addTodoList("Tiga");

    showTodoList();

    viewRemoveTodoList();

    showTodoList();
  }

}
