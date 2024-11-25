//Name: Arun Sharma
//Date: 11/24/2024
//Assignment name and number: Module 7: More JavaFX - Assignment 7

//Sources: https://www.w3schools.com/, https://www.geeksforgeeks.org/
//Purpose of code: This program creates four circles styled using a CSS file and arranges them in a layout to match the given specifications.
//The circles include two white circles with black borders, one red circle, and one green circle. The program centers the layout vertically and horizontally.
//Github link: https://github.com/SharmaArun017/CSD-420

package com.example.demoj;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleStyleDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create circles with styles
        Circle circle1 = new Circle(50);
        circle1.getStyleClass().add("plaincircle");

        Circle circle2 = new Circle(50);
        circle2.getStyleClass().add("plaincircle");

        Circle redCircle = new Circle(50);
        redCircle.setId("redcircle");

        Circle greenCircle = new Circle(50);
        greenCircle.setId("greencircle");

        // Arrange the circles horizontally
        HBox hBoxCircles = new HBox(20, circle2, redCircle, greenCircle);
        hBoxCircles.setAlignment(Pos.CENTER); // Align circles in the center

        // Create a vertical box for the border and the first circle
        VBox vBoxLeft = new VBox(circle1);
        vBoxLeft.getStyleClass().add("border");
        vBoxLeft.setAlignment(Pos.CENTER); // Center the single circle vertically

        // Main layout combining the left and right parts
        HBox mainLayout = new HBox(20, vBoxLeft, hBoxCircles);
        mainLayout.setAlignment(Pos.CENTER); // Center everything vertically

        // Create a scene and load the stylesheet
        Scene scene = new Scene(mainLayout, 400, 200);
        scene.getStylesheets().add("file:///Users/arunsharma/demoj/src/main/java/com/example/demoj/mystyle.css");

        // Configure the stage
        primaryStage.setTitle("Exercise31_01");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/*
Step-by-Step Explanation of the Code:

1. Circle Creation:
   - Four `Circle` objects are created using the `Circle` class.
   - `circle1` and `circle2` are styled with the "plaincircle" class, which defines a white fill and black border.
   - `redCircle` and `greenCircle` are styled using the "redcircle" and "greencircle" IDs, which define their respective fill and border colors.

2. Horizontal Layout for Circles (hBoxCircles):
   - The `HBox` layout is used to arrange `circle2`, `redCircle`, and `greenCircle` horizontally.
   - The circles are spaced 20 pixels apart using the `HBox` constructor.
   - The `hBoxCircles` layout is centered vertically using `setAlignment(Pos.CENTER)`.

3. Vertical Layout for Left Circle (vBoxLeft):
   - The `VBox` layout contains `circle1` and is styled with the "border" class to add a black border around the vertical section.
   - The vertical alignment of `circle1` is set to `Pos.CENTER` to ensure it is vertically centered within the box.

4. Main Layout (mainLayout):
   - The `mainLayout` is an `HBox` that combines the vertical box (`vBoxLeft`) and the horizontal layout of circles (`hBoxCircles`).
   - It is aligned vertically to the center of the scene using `setAlignment(Pos.CENTER)`.

5. Scene Creation and Styling:
   - The `Scene` object is created with the `mainLayout` as its root.
   - The CSS file `mystyle.css` is applied to the scene using an absolute path (`file:///Users/arunsharma/demoj/src/main/java/com/example/demoj/mystyle.css`).

6. Stage Configuration:
   - The `Stage` is configured with a title ("Exercise31_01") and the created `Scene`.
   - The `primaryStage.show()` method displays the application window.

7. Purpose:
   - The program creates four circles with different styles using a CSS file, arranges them in a layout, and ensures the layout is centered both horizontally and vertically in the application window.

*/

