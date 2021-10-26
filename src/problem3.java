public class problem3 {

    public static void main(String[] args)
    {
        DLLList<Integer> list = new DLLList<>();

        list.addLast(11);
        list.addLast(12);
        list.addLast(4);
        list.print();

        list.add(19, 0);
        list.print();
        list.add(7, 3);
        list.print();
        System.out.println(list.remove(2));
        list.print();
        System.out.println(list.get(0));
        list.print();
        list.set(5, 0);
        list.print();
    }
}
