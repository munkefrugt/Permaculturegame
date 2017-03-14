package com.company;

import java.util.ArrayList;

/**
 * Created by v on 4/8/16.
 */
public class Setup {

    Tree tree;
    Gui gui;
    Draw draw;
    Game game;
    ArrayList<ArrayList<String>> maze;

    int width;
    int height;
    int totalHeight;
    int totalWidth;


    public Setup()
    {

        // build up game:
        game = new Game(this);
        
        game.generateBoard();
        width = game.getWidth();
        height =game.getHeight();
        maze = game.getMaze();
        totalHeight= height+4;
        totalWidth = width +4;

        int startMinotaurRow =  game.getStartMinotaurRow();
        int startMinotaurColumn = game.getStartMinotaurColumn();


        Minotaur minotaur = new Minotaur(maze,startMinotaurRow,startMinotaurColumn,height,width);





        tree = new Tree(this,game);

        game.addTreeObject(tree);
        makeStartLandscape();

        System.out.println(" lav guien");
        minotaur.insertMinotaur();
        gui= new Gui(game,minotaur,maze,totalHeight,totalWidth,startMinotaurRow,startMinotaurColumn);
        draw = new Draw(minotaur,maze,totalHeight,totalWidth,startMinotaurRow,startMinotaurColumn);


        //game.passInstanceOfRecursiveBacktracker(game);



    }

    private void makeStartLandscape() {
        tree.addrandomMediumTrees(10);
        tree.addRandomSmallTrees(100);
        tree.addRandBigTrees(10);
        tree.addRandLevel1Trees(4);
        tree.addRandLevel2Trees(10);
    }

}
