package main;

import util.InputUtil;
import util.MenuUtil;

public class Main {
    public static void main(String[] args) {
        int menu = 0;
        while (true) {
            menu = InputUtil.requireNumber("""
                                           what do you want to do?
                                           1. Register Student
                                           2. Show all students
                                           3. Find Student
                                           4. Update Student
                                           5. Exit""");
            MenuUtil.processMenu(menu);
        }
    }
}
