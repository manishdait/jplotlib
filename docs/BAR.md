# Jplotlib.bar()

The `bar()` method in `Jplotlib` allows you to create 2D bar graphs with ease. This method is designed to visualize datasets using y-coordinates and labels for x-coordinates in the form of strings. It offers a convenient way to generate bar graph.

### Method Signature:

```java
bar(String[] xLabels, double[] yPoints)
```
The `bar()` method requires two arrays: `xLabels` containing labels for the x-coordinates (in String format) and `yPoints` containing the corresponding y-coordinates.

### Example Usage:

```java
import io.github.manishdait.jplotlib.Jplotlib;

public class App {
  public static void main(String[] args) {
    Jplotlib jplotlib = new Jplotlib();
    String[] x = {"A", "B", "C", "D"};
    double[] y = {3, 8, 1, 10};
    jplotlib.bar(x, y);
    jplotlib.show();
  }
}
```
In this example, we use the `bar()` method to create a bar graph using `x` as the labels for the x-coordinates and `y` as the y-coordinates. Each bar in the graph represents a category defined by the labels, and its height corresponds to the respective value from `y`.

<img src="assets/bar/bar_EG1.png" alt="bar_eg1.png" width="620px">

Bar graphs are particularly useful for comparing the values of different categories and displaying discrete data. They are commonly used to visualize categorical data and show how different groups or items compare with each other.


## Bar Color

In Jplotlib, similar to `.plot()`[.color()](PLOT.md) you can customize the color of the bars in a bar graph using the `.color()` method. This feature allows you to change the color of individual bars or sets of bars, making your bar graph more visually appealing and informative.

### Example Usage:

```java
import io.github.manishdait.jplotlib.Jplotlib;
import io.github.manishdait.jplotlib.defaults.color.LibColor;

public class App {
  public static void main(String[] args) {
    Jplotlib jplotlib = new Jplotlib();
    String[] x = {"A", "B", "C", "D"};
    double[] y = {3, 8, 1, 10};
    jplotlib.bar(x, y)
      .color(LibColor.PINK.getColor());
    jplotlib.show();
  }
}
```

In this example, we use the `.color(LibColor.PINK.getColor())` method with the `bar()` method to set the color of the bars in the bar graph to pink. You can use the `LibColor` enum to choose from a variety of predefined colors like `LibColor.RED`, `LibColor.GREEN`, `LibColorColor.ORANGE`, and more.

<img src="assets/bar/bar_EG2.png" alt="bar_eg2.png" width="620px">

You can also use the java.awt.Color class to specify custom colors using RGB values, like `.color(new Color(255, 0, 0))` for red.

# Jplotlib.barh()

The `barh()` method in `Jplotlib` allows you to create Horizonta; 2D bar graphs. It has all similar features like above `bar()` method.

### Method Signature:

```java
barh(String[] xLabels, double[] yPoints)
```
The `barh()` method requires two arrays: `xLabels` containing labels for the x-coordinates (in String format) and `yPoints` containing the corresponding y-coordinates.

### Example Usage:

```java
import io.github.manishdait.jplotlib.Jplotlib;

public class App {
  public static void main(String[] args) {
    Jplotlib jplotlib = new Jplotlib();
    String[] x = {"A", "B", "C", "D"};
    double[] y = {3, 8, 1, 10};
    jplotlib.barh(x, y);
    jplotlib.show();
  }
}
```

In this example, we use the `barh()` method to create a bar graph using `x` as the labels for the x-coordinates and `y` as the y-coordinates. Each bar in the graph represents a category defined by the labels, and its width corresponds to the respective value from `x`.

<img src="assets/bar/bar_EG3.png" alt="bar_eg3.png" width="620px">