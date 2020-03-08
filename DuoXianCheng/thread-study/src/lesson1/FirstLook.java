package lesson1;

public class FirstLook {
  /*  public static void main(String[] args) throws InterruptedException {
        Thread.sleep(9999999L);
    }*/

  /*public static void main(String[] args) {

      new Thread(new Runnable() {
          @Override
          public void run() {
              try {
                  Thread.sleep(9999999L);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      }).start();
  }*/

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                    System.out.println(Thread.currentThread().getName());
            }
        }).start();
        System.out.println(Thread.currentThread().getName());
    }
}
