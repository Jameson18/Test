package itmostady.exam3;

import java.util.Scanner;

public class Game{
    Scanner scan = new Scanner(System.in);


    public void start() {
        showMenu();
    }

    public void save() {
    }

    public void load() {
    }

    public void showMenu(){
        System.out.println("Для выбора пункта меню введите соответствующую цифру");
        System.out.println("1 - Начать новую игру");
        System.out.println("2 - Загрузить игру");
        System.out.println("3 - Выход");
        while (true){
            int choice = scan.nextInt();
            if (choice == 1){
                GameText newGame = new GameText(new Game());
                newGame.startGame();
            }else if (choice == 2){
               // LoadGame loadGame = new LoadGame();
                break;
            }else if (choice == 3){
                break;
            }
            else System.out.println("Вы ввели некорректное значение");
        }
    }
}
