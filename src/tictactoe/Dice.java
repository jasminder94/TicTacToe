package tictactoe;
/*
 *  GameMain.fx - 
 *  A compiled JavaFX program that demonstrates creating custom
 *  components with CompositeNode
 * 
 *
 *  Developed 2008 by James L. Weaver (jim.weaver at lat-inc.com)
 *  to serve as a JavaFX Script example.
 */

import javafx.ui.*;
import javafx.ui.canvas.*;
import java.lang.System;

Frame {
  var model = GameModel {}
  width: 210
  height: 170
  title: "Dice"
  background: Color.WHITE
  content: 
    BorderPanel {
      center:
        Canvas {
          content:
            for (diceNum in [0 .. model.numDice - 1]) {
              model.newDice =
              Dice {
                x: diceNum * 100 + 10
                y: 10
                width: 80
                height: 80
                faceColor: Color.RED
                pipColor: Color.WHITE
              }
            }
        }
      bottom:
        FlowPanel {
          content:
            Button {
              text: "Roll"
              defaultButton: true
              action:
                function():Void {
                  model.roll();
                }
            }
        }
    } 
  visible: true
  onClose:
    function():Void {
      System.exit(0);
    }
}
Dice.fx

/*
 *  Dice.fx - 
 *  A compiled JavaFX program that demonstrates creating custom
 *  components with CompositeNode
 * 
 *
 *  Developed 2008 by James L. Weaver (jim.weaver at lat-inc.com)
 *  to serve as a JavaFX Script example.
 */

import javafx.ui.*;
import javafx.ui.canvas.*;
import java.lang.Math;
import java.lang.System;

public class Dice extends CompositeNode {
  public attribute value:Integer = 5;
  public attribute x:Integer;
  public attribute y:Integer;
  public attribute width:Integer;
  public attribute height:Integer;
  public attribute faceColor:Color;
  public attribute pipColor:Color;
  
  attribute pipPlace:PipPlacement[];
  
  postinit {
    insert
      PipPlacement {
        pipLocsX: [
          .5, 0, 0, 0, 0, 0
        ]
        pipLocsY: [
          .5, 0, 0, 0, 0, 0
        ]
      }
      into pipPlace;
    insert
      PipPlacement {
        pipLocsX: [
          0.3, 0.7, 0, 0, 0, 0
        ]
        pipLocsY: [
          0.7, 0.3, 0, 0, 0, 0
        ]
      }
      into pipPlace;
    insert
      PipPlacement {
        pipLocsX: [
          0.2, 0.5, 0.8, 0, 0, 0
        ]
        pipLocsY: [
          0.8, 0.5, 0.2, 0, 0, 0
        ]
      }
      into pipPlace;
    insert
      PipPlacement {
        pipLocsX: [
          0.25, 0.25, 0.75, 0.75, 0, 0
        ]
        pipLocsY: [
          0.25, 0.75, 0.25, 0.75, 0, 0
        ]
      }
      into pipPlace;
    insert
      PipPlacement {
        pipLocsX: [
          0.2, 0.5, 0.8, 0.8, 0.2, 0
        ]
        pipLocsY: [
          0.8, 0.5, 0.2, 0.8, 0.2, 0
        ]
      }
      into pipPlace;
    insert
      PipPlacement {
        pipLocsX: [
          0.3, 0.3, 0.3, 0.7, 0.7, 0.7
        ]
        pipLocsY: [
          0.8, 0.5, 0.2, 0.8, 0.5, 0.2
        ]
      }
      into pipPlace;
  } 
    
  public function roll():Void {
    value = (Math.random() * 6 + 1) as Integer;
  }
  
  public function composeNode():Node {
    Group {
      transform: bind [
        Translate.translate(x, y)
      ]
      content: bind [
        Rect {
          x: 0
          y: 0
          width: this.width;
          height: this.height;
          fill: faceColor
        },
        for (pipIdx in [0 .. value-1]) {
          Circle {
            cx: bind pipPlace[value - 1].pipLocsX[pipIdx] * width
            cy: bind pipPlace[value - 1].pipLocsY[pipIdx] * height
            radius: width * .1
            fill: pipColor
          }
        }
      ]  
    }
  }
}
GameModel.fx

/*
 *  GameModel.fx - 
 *  The model behind the dice game
 *
 *  Developed 2008 by James L. Weaver (jim.weaver at lat-inc.com)
 *  to serve as a JavaFX Script example.
 */

class GameModel {
  attribute numDice:Integer = 2;
  attribute newDice:Dice on replace {
    insert newDice into dice;
  }
  attribute dice:Dice[];
  
  function roll():Void {
    for (die in dice) {
      die.roll();
    }
  }
}

PipPlacement.fx

/*
 *  PipPlacement.fx - 
 *  The placement of the pips on a dice
 *
 *  Developed 2008 by James L. Weaver (jim.weaver at lat-inc.com)
 *  to serve as a JavaFX Script example.
 */

public class PipPlacement {
  public attribute pipLocsX:Number[];
  public attribute pipLocsY:Number[];
}